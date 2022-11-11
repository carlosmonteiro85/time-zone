package br.com.acme.fakeecomerce.timezone.api.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.acme.fakeecomerce.timezone.api.dto.ItemCartDTO;
import br.com.acme.fakeecomerce.timezone.api.dto.ProdutoDTO;
import br.com.acme.fakeecomerce.timezone.api.dto.UserDTO;
import br.com.acme.fakeecomerce.timezone.api.mapper.ProdutoAssembler;
import br.com.acme.fakeecomerce.timezone.api.mapper.UserDisassembler;
import br.com.acme.fakeecomerce.timezone.core.exception.ErrorInfo;
import br.com.acme.fakeecomerce.timezone.core.exception.ProdutoNaoEncontradoException;
import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.model.Produto;
import br.com.acme.fakeecomerce.timezone.domain.model.User;
import br.com.acme.fakeecomerce.timezone.domain.service.ProductService;
import br.com.acme.fakeecomerce.timezone.domain.service.UserService;
import br.com.acme.fakeecomerce.timezone.util.AppConstantes;
import br.com.acme.fakeecomerce.timezone.util.Utils;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
	
	private final ProductService service;
	private final UserService userService;
	private final ProdutoAssembler mapper;
	private final UserDisassembler userDisassembler;
	
	@GetMapping(path = { "", "home" })
	public String home(Model model) {
		List<ProdutoDTO> produtos = service.findProdutos();
		model.addAttribute("produtos", produtos);
		model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
		model.addAttribute("itemCartDTO", new ItemCartDTO());
		return "index";
	}

	@GetMapping("shop")
	public String shop(Model model) {
	    List<ProdutoDTO> produtos = service.findProdutos();
	    model.addAttribute("produtos", produtos);
	    
	    List<ProdutoDTO> produtosPorPreco = new ArrayList<>(produtos);
	    Collections.sort(produtosPorPreco, Comparator.comparing(ProdutoDTO::getPreco));
	    model.addAttribute("produtosPorPreco", produtosPorPreco);
        
	    List<ProdutoDTO> maisPopulares = new ArrayList<>(produtos);
        Collections.sort(maisPopulares, Comparator.comparing(ProdutoDTO::getNome));
        model.addAttribute("maisPopulares", maisPopulares);
	    
        model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
		return "shop";
	}
	
	@GetMapping("elements")
	public String elements(Model model) {
		return "elements";
	}
	
	@GetMapping("cart")
	public String cart2(Model model) {
	    
	    Cart cart = Utils.obterCarrinho(userService);
	    
	    model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
	    model.addAttribute("cart", cart);
	    model.addAttribute(AppConstantes.CHECKOUT, Utils.verificarCheck(cart));
	    model.addAttribute("userDTO", new UserDTO());
	    
		return "cart";
	}
	
	@PostMapping("regiao")
    public String atualizarRegiao(UserDTO userDTO, Model model) {
	    User user = userService.obtemUsuario();
	    userDisassembler.copyToDomainObject(userDTO, user);
	    userService.save(user);
        return "redirect:/cart";
    }
	
	@GetMapping("confirmation")
    public String elements3(Model model) {
        return "confirmation";
    }
	
	@GetMapping("checkout")
    public String elements6(Model model) {
	    
	    Cart cart = Utils.obterCarrinho(userService);
        
//        model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
//        model.addAttribute("cart", cart);
        model.addAttribute(AppConstantes.CHECKOUT, Utils.verificarCheck(cart));
	    
        return "checkout";
    }
	
	@GetMapping("contact")
    public String elements4(Model model) {
	    model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
        return "contact";
    }
	
	@GetMapping("product_details")
    public String elements5(Model model) {
        return "product_details";
    }
	
    @GetMapping(params = "codigo", value = "produto")
    public String main(@RequestParam("codigo") Long id, Model model) {
        Produto produto = service.findById(id);
        ItemCartDTO itemCartDTO = new ItemCartDTO(mapper.toDTO(produto));
        model.addAttribute("produto", produto);
        model.addAttribute("itemCartDTO", itemCartDTO);
        model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
        return "product_details";
    }
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProdutoNaoEncontradoException.class)
	@ResponseBody ErrorInfo
	handleBadRequest(HttpServletRequest req, ProdutoNaoEncontradoException ex) {
	    return new ErrorInfo(req.getRequestURI(), ex);
	} 
}
