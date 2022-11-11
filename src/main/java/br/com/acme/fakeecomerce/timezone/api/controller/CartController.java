package br.com.acme.fakeecomerce.timezone.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.acme.fakeecomerce.timezone.api.dto.ItemCartDTO;
import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.model.ItemCart;
import br.com.acme.fakeecomerce.timezone.domain.service.CartService;
import br.com.acme.fakeecomerce.timezone.domain.service.ItemService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    
    private final CartService cartService;
    private final ItemService itemService;
    
    @PostMapping("addItemCart")
    public String addItemCart(ItemCartDTO itemCartDTO, Model model) {
        Cart cart = cartService.addItemCarrinho(cartService.bindItem(itemCartDTO));
        model.addAttribute("cart", cart);
        return "redirect:/produto?codigo=" + itemCartDTO.getProduto().getId() ;
    }
    
    @GetMapping(params = "codigo", value = "item")
    public String removeItemCart(@RequestParam("codigo") Long id, Model model) {
        ItemCart item = itemService.findById(id);
        cartService.removerItemCarrinho(item);
        return "redirect:/cart";
    }
}
