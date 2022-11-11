package br.com.acme.fakeecomerce.timezone.util;

import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.model.Checkout;
import br.com.acme.fakeecomerce.timezone.domain.service.UserService;

public final class Utils {
    
    public static Integer totalItensCarrinho(UserService service) {
        return service.obtemUsuario().getCart().getCartItens().size();
    }
    
    public static Cart obterCarrinho(UserService service) {
        return service.obtemUsuario().getCart();
    }
    
    public static Checkout verificarCheck(Cart cart) {
        return new Checkout(cart);
    }
}
