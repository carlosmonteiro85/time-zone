package br.com.acme.fakeecomerce.timezone.util;

import br.com.acme.fakeecomerce.timezone.domain.service.UserService;

public final class Utils {
    
    public static Integer totalItensCarrinho(UserService service) {
        return service.obtemUsuario().getCart().getCartItens().size();
    }

}
