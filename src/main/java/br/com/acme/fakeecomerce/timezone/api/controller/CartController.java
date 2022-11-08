package br.com.acme.fakeecomerce.timezone.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.acme.fakeecomerce.timezone.api.dto.CartDTO;
import br.com.acme.fakeecomerce.timezone.api.dto.ItemCartDTO;
import br.com.acme.fakeecomerce.timezone.api.mapper.CartAssembler;
import br.com.acme.fakeecomerce.timezone.api.mapper.ItemDisassembler;
import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.service.CartService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    
    private final ItemDisassembler itemDisassembler;
    private final CartAssembler cartAssembler;
    private final CartService cartService;
    
    @PostMapping("addItemCart")
    public String addItemCart(ItemCartDTO itemCartDTO, Model model) {
        Cart cart = cartService.addItemCarrinho(cartService.bindItem(itemCartDTO));
        model.addAttribute("cart", cart);
        return "redirect:/produto?codigo=" + itemCartDTO.getProduto().getId() ;
    }
    
    @DeleteMapping("removeItemCart")
    public CartDTO removeItemCart(ItemCartDTO cartItem) {
        Cart cart = cartService.removerItemCarrinho(itemDisassembler.toModel(cartItem));
        return cartAssembler.toDTO(cart);
    }
//    
//    @PutMapping("/{id}")
//    public ResponseEntity<Cart> update(@PathVariable("id") long id, @RequestBody Cart cart) {
//        return cartService.findById(id).map(record -> {
//            
//            List<ItemCart> itensToPersist = new ArrayList<>();
//            
//            // Atualiza os items já persistidos
//            record.getCartItens().stream()
//                .filter(itemPersisted -> cart.getCartItens().contains(itemPersisted))
//                .forEach(itemPersisted -> {
//                    int indexOf = cart.getCartItens().indexOf(itemPersisted);
//                    itemPersisted.setQuantity(cart.getCartItens().get(indexOf).getQuantity());
//                    itensToPersist.add(itemPersisted);
//                });
//            
//            // Insere itens novos
//            cart.getCartItens().stream()
//                .filter(itemFromJson -> !record.getCartItens().contains(itemFromJson))
//                .forEach(itemNew -> {
//                     //Define no "itens do carrinho" o "carrinho"
//                     itemNew.setCart(cart);
//                     itensToPersist.add(itemNew);
//                });
//            
//            record.getCartItens().clear();
//            record.getCartItens().addAll(itensToPersist);
//            Cart updated = cartService.save(record);
//            
//            return ResponseEntity.ok().body(updated);
//            
//        }).orElse(ResponseEntity.notFound().build());
//    }
//    
//    @DeleteMapping("{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") long id) {
//        return cartService.findById(id).map(c -> {
//            cartService.deleteById(id);
//            return ResponseEntity.ok().build();
//        }).orElse(ResponseEntity.notFound().build());
//    }
//    
//    @GetMapping("{id}")
//    public ResponseEntity<Cart> findById(@PathVariable long id) {
//        return cartService.findById(id)
//                .map(c -> ResponseEntity.ok().body(c))
//                .orElse(ResponseEntity.notFound().build());
//    }
//    
//    @GetMapping
//    public List<Cart> findAll() {
//        return cartService.findAll();
//    }

}
