package br.com.acme.fakeecomerce.timezone.api.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import br.com.acme.fakeecomerce.timezone.api.dto.CheckoutDTO;
import br.com.acme.fakeecomerce.timezone.api.dto.ItemCartDTO;
import br.com.acme.fakeecomerce.timezone.api.dto.ProdutoDTO;
import br.com.acme.fakeecomerce.timezone.api.dto.UserDTO;
import br.com.acme.fakeecomerce.timezone.api.mapper.CheckoutAssembler;
import br.com.acme.fakeecomerce.timezone.api.mapper.ProdutoAssembler;
import br.com.acme.fakeecomerce.timezone.api.mapper.UserDisassembler;
import br.com.acme.fakeecomerce.timezone.core.exception.ErrorInfo;
import br.com.acme.fakeecomerce.timezone.core.exception.ProdutoNaoEncontradoException;
import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.model.NfDTO;
import br.com.acme.fakeecomerce.timezone.domain.model.Produto;
import br.com.acme.fakeecomerce.timezone.domain.model.User;
import br.com.acme.fakeecomerce.timezone.domain.service.CartService;
import br.com.acme.fakeecomerce.timezone.domain.service.CheckoutService;
import br.com.acme.fakeecomerce.timezone.domain.service.ProductService;
import br.com.acme.fakeecomerce.timezone.domain.service.UserService;
import br.com.acme.fakeecomerce.timezone.util.AppConstantes;
import br.com.acme.fakeecomerce.timezone.util.Utils;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ApiController {

	private final ProductService service;
	private final UserService userService;
	private final CartService cartService;
	private final ProdutoAssembler mapper;
	private final UserDisassembler userDisassembler;
	private final CheckoutAssembler checkoutAssembler;
	private final CheckoutService checkService;

	private Cart cart;

	@GetMapping(path = { "", "home" })
	public String home(Model model) {
		model.addAttribute(AppConstantes.PRODUTOS, service.findProdutos());
		model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
		model.addAttribute("itemCartDTO", new ItemCartDTO());
		return "index";
	}

	@GetMapping("shop")
	public String shop(Model model) {
		List<ProdutoDTO> produtos = service.findProdutos();
		
		List<ProdutoDTO> produtosPorPreco = new ArrayList<>(produtos);
		Collections.sort(produtosPorPreco, Comparator.comparing(ProdutoDTO::getPreco));
		
		List<ProdutoDTO> maisPopulares = new ArrayList<>(produtos);
		Collections.sort(maisPopulares, Comparator.comparing(ProdutoDTO::getNome));
		
		model.addAttribute("produtos", produtos);
		model.addAttribute("produtosPorPreco", produtosPorPreco);
		model.addAttribute("maisPopulares", maisPopulares);
		model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
		return AppConstantes.PAGE_PRODUTOS;
	}

	@PostMapping("regiao")
	public String atualizarRegiao(UserDTO userDTO, Model model) {
		User user = userService.obtemUsuario();
		userDisassembler.copyToDomainObject(userDTO, user);
		userService.save(user);
		return "redirect:/cart";
	}

	@GetMapping("contact")
	public String contato(Model model) {
		model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
		return AppConstantes.CONTATOS;
	}

	@GetMapping(params = "codigo", value = "produto")
	public String produto(@RequestParam("codigo") Long id, Model model) {
		Produto produto = service.findById(id);
		model.addAttribute("produto", produto);
		model.addAttribute("itemCartDTO", new ItemCartDTO(mapper.toDTO(produto)));
		model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
		return AppConstantes.PAGE_PRODUTO;
	}
	
	@PostMapping("confirmation")
	public String confirmacao(NfDTO nf, Model model) {
		CheckoutDTO checkout = checkoutAssembler.toDTO(checkService.obterCheckout(Utils.obterCarrinho(userService)));
		nf.setCheckout(checkout);
		String pathNF = Utils.gerarNF(nf);
		model.addAttribute("pathNF", pathNF.replace("/", "-").replace("\\", "-"));
		model.addAttribute(AppConstantes.CHECKOUT, checkout);
		return AppConstantes.FINALIZACAO;
	}
	
	@GetMapping(params = "codigo", value = "download-nf/item")
	public void downloadNf(@RequestParam("codigo") String pathNota, HttpServletResponse response) {
		Utils.downloadNF(pathNota.replace("-", System.getProperty("file.separator")), response);
		cart = Utils.obterCarrinho(userService);
		cartService.limparCarrinho(cart);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProdutoNaoEncontradoException.class)
	@ResponseBody
	ErrorInfo handleBadRequest(HttpServletRequest req, ProdutoNaoEncontradoException ex) {
		return new ErrorInfo(req.getRequestURI(), ex);
	}
}
