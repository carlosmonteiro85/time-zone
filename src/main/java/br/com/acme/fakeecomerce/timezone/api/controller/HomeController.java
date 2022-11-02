package br.com.acme.fakeecomerce.timezone.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.acme.fakeecomerce.timezone.api.dto.ProdutoDTO;
import br.com.acme.fakeecomerce.timezone.api.mapper.ProdutoAssembler;
import br.com.acme.fakeecomerce.timezone.core.exception.ErrorInfo;
import br.com.acme.fakeecomerce.timezone.core.exception.ProdutoNaoEncontradoException;
import br.com.acme.fakeecomerce.timezone.domain.model.Produto;
import br.com.acme.fakeecomerce.timezone.domain.service.ProductService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
	
	private final ProductService service;
	private final ProdutoAssembler mapper;
	

	@GetMapping(path = { "", "home" })
	public String home(Model model) {
		List<ProdutoDTO> produtos = service.findProdutos();
		model.addAttribute("produtos", produtos);
		return "index";
	}

	@GetMapping("shop")
	public String shop(Model model) {
		return "product_details";
	}
	
	@GetMapping("elements")
	public String elements(Model model) {
		return "elements";
	}
	
	@GetMapping("cart")
	public String elements2(Model model) {
		return "cart";
	}
	
	@GetMapping("main")
	public String main(Model model) {
		return "main";
	}
	
	@GetMapping(params = "codigo", value = "produto")
	public String main(@RequestParam("codigo") Long IdProduto, Model model) {
			Produto produto = service.findById(IdProduto);
			model.addAttribute("produto", mapper.toDTO(produto));
		return "product_details";
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProdutoNaoEncontradoException.class)
	@ResponseBody ErrorInfo
	handleBadRequest(HttpServletRequest req, ProdutoNaoEncontradoException ex) {
	    return new ErrorInfo(req.getRequestURI(), ex);
	} 
}
