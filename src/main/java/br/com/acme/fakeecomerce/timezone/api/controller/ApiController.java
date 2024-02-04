package br.com.acme.fakeecomerce.timezone.api.controller;

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
import br.com.acme.fakeecomerce.timezone.api.dto.UserDTO;
import br.com.acme.fakeecomerce.timezone.api.mapper.CheckoutAssembler;
import br.com.acme.fakeecomerce.timezone.core.exception.ErrorInfo;
import br.com.acme.fakeecomerce.timezone.core.exception.ProdutoNaoEncontradoException;
import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.model.NfDTO;
import br.com.acme.fakeecomerce.timezone.domain.model.Produto;
import br.com.acme.fakeecomerce.timezone.domain.service.CartService;
import br.com.acme.fakeecomerce.timezone.domain.service.CheckoutService;
import br.com.acme.fakeecomerce.timezone.domain.service.DominiosService;
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
	private final CheckoutAssembler checkoutAssembler;
	private final CheckoutService checkService;

	private final DominiosService dominiosService;

	@GetMapping(path = { "", "home" })
	public String home(Model model) {
		dominiosService.getDominiosHome(model);
		return "index";
	}

	@GetMapping("shop")
	public String shop(Model model) {
		dominiosService.getDominiosShop(model);
		return AppConstantes.PAGE_PRODUTOS;
	}

	@PostMapping("regiao")
	public String atualizarRegiao(UserDTO userDTO, Model model) {
		userService.updateDadosUsuario(userDTO);
		return AppConstantes.REDIRECT_CART;
	}

	@GetMapping("contact")
	public String contato(Model model) {
		dominiosService.getDominiosContatos(model);
		return AppConstantes.CONTATOS;
	}

	@GetMapping(params = "codigo", value = "produto")
	public String produto(@RequestParam("codigo") Long id, Model model) {
		Produto produto = service.findById(id);
		dominiosService.getDominiosObterPtoduto(model, produto);
		return AppConstantes.PAGE_PRODUTO;
	}
	
	@PostMapping("confirmation")
	public String confirmacao(NfDTO nf, Model model) {
    CheckoutDTO checkout = checkoutAssembler.toDTO(checkService.obterCheckout(Utils.obterCarrinho(userService)));
		nf.setCheckout(checkout);
		String pathNF = Utils.gerarNF(nf);
		dominiosService.getDominiosConfirmacao(model, checkout, pathNF);
		return AppConstantes.FINALIZACAO;
	}
	
	@GetMapping(params = "codigo", value = "download-nf/item")
	public void downloadNf(@RequestParam("codigo") String pathNota, HttpServletResponse response) {
		Utils.downloadNF(pathNota.replace("-", System.getProperty("file.separator")), response);
		Cart cart = Utils.obterCarrinho(userService);
		cartService.limparCarrinho(cart);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProdutoNaoEncontradoException.class)
	@ResponseBody
	ErrorInfo handleBadRequest(HttpServletRequest req, ProdutoNaoEncontradoException ex) {
		return new ErrorInfo(req.getRequestURI(), ex);
	}
}
