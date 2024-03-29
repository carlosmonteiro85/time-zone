package br.com.acme.fakeecomerce.timezone.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.acme.fakeecomerce.timezone.api.dto.ItemCartDTO;
import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.model.Checkout;
import br.com.acme.fakeecomerce.timezone.domain.model.ItemCart;
import br.com.acme.fakeecomerce.timezone.domain.model.Produto;
import br.com.acme.fakeecomerce.timezone.domain.service.CartService;
import br.com.acme.fakeecomerce.timezone.domain.service.CheckoutService;
import br.com.acme.fakeecomerce.timezone.domain.service.DominiosService;
import br.com.acme.fakeecomerce.timezone.domain.service.ItemService;
import br.com.acme.fakeecomerce.timezone.domain.service.ProductService;
import br.com.acme.fakeecomerce.timezone.domain.service.UserService;
import br.com.acme.fakeecomerce.timezone.util.AppConstantes;
import br.com.acme.fakeecomerce.timezone.util.Utils;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    
    private final CartService cartService;
    private final ItemService itemService;
    private final ProductService produtoService;
    private final UserService userService;
	private final CheckoutService checkService;

    private final DominiosService dominiosService;
    
    @GetMapping()
    public String cart(Model model) {
        Cart cart = Utils.obterCarrinho(userService);
        Checkout checkout = checkService.obterCheckout(cart);
        dominiosService.getDominiosCarrinho(model, cart, checkout);
        return AppConstantes.CART;
    }
    
    @PostMapping("addItemCart")
    public String addItemCart(ItemCartDTO itemCartDTO, Model model) {
        Cart cart = cartService.addItemCarrinho(cartService.bindItem(itemCartDTO));
        model.addAttribute(AppConstantes.CART , cart);
        return "redirect:/produto?codigo=" + itemCartDTO.getProduto().getId() ;
    }
    
    @GetMapping(params = "codigo", value = "item")
    public String removeItemCart(@RequestParam("codigo") Long id, Model model) {
        ItemCart item = itemService.findById(id);
        cartService.removerItemCarrinho(item);
        return AppConstantes.REDIRECT_CART;
    }
    
    @GetMapping(params = "codigo", value = "produto")
    public String addItemSimplesAoCart(@RequestParam("codigo") Long id, Model model) {
        Produto produto = produtoService.findById(id);
        cartService.addItemCarrinho(new ItemCart(produto, 1));
        return "redirect:/";
    }
}
