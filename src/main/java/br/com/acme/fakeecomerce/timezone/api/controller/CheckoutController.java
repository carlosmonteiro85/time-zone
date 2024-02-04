package br.com.acme.fakeecomerce.timezone.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.acme.fakeecomerce.timezone.api.mapper.CheckoutAssembler;
import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.model.Checkout;
import br.com.acme.fakeecomerce.timezone.domain.model.NfDTO;
import br.com.acme.fakeecomerce.timezone.domain.service.CheckoutService;
import br.com.acme.fakeecomerce.timezone.domain.service.UserService;
import br.com.acme.fakeecomerce.timezone.util.AppConstantes;
import br.com.acme.fakeecomerce.timezone.util.Utils;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/checkout")
public class CheckoutController {
    
	private final UserService userService;
	private final CheckoutService checkService;
	private final CheckoutAssembler checkoutAssembler;
	
	@GetMapping()
	public String elements6(Model model) {
		Cart cart = Utils.obterCarrinho(userService);
		Checkout checkout = checkService.obterCheckout(cart);
		model.addAttribute(AppConstantes.CHECKOUT, checkoutAssembler.toDTO(checkout));
		model.addAttribute(AppConstantes.ITEM_CART, Utils.totalItensCarrinho(userService));
		model.addAttribute("nf", new NfDTO());
		return "checkout";
	}
}
