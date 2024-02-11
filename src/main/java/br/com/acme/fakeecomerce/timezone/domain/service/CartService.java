package br.com.acme.fakeecomerce.timezone.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.acme.fakeecomerce.timezone.api.dto.ItemCartDTO;
import br.com.acme.fakeecomerce.timezone.domain.model.AcaoEnum;
import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.model.ItemCart;
import br.com.acme.fakeecomerce.timezone.domain.model.Produto;
import br.com.acme.fakeecomerce.timezone.domain.model.User;
import br.com.acme.fakeecomerce.timezone.domain.repository.CartRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final UserService userService;
    private final ProductService produroService;

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart findById(Long id) {
        return cartRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Carrinho não encontrado."));
    }

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public void deleteById(long id) {
        cartRepository.deleteById(id);
    }

    public Cart addItemCarrinho(ItemCart item) {
        User usuario = obterUsuarioLogado();
        boolean possueItem = verificarSePossueItem(item, usuario.getCart(), AcaoEnum.ADICIONAR);
        
        if(!possueItem) {
            usuario.getCart().getCartItens().add(item);                            
        }
        
        return save(usuario.getCart());
    }

    public Cart removerItemCarrinho(ItemCart item) {
        User usuario = obterUsuarioLogado();
        boolean possueItem = verificarSePossueItem(item, usuario.getCart(), AcaoEnum.REMOVER);
        
        if(possueItem) {
            usuario.getCart().getCartItens().remove(item);
        }
        
        return save(usuario.getCart());
    }
    
    private boolean verificarSePossueItem(ItemCart item, Cart cart, AcaoEnum acao) {
        boolean possueItem = false;
        for (ItemCart itemCart : cart.getCartItens()) {
            if(itemCart.getProduto().equals(item.getProduto())) {
                int qt = acao.equals(AcaoEnum.ADICIONAR) 
                    ? itemCart.getQuantidade() +  item.getQuantidade() 
                    : itemCart.getQuantidade() - item.getQuantidade();
                itemCart.setQuantidade(qt < 0 ? 0 : qt ); 
                possueItem = true;
                break;
            }
        }
        return possueItem;
    }

    private User obterUsuarioLogado() {
        return userService.obtemUsuario();
    }
    
    public Cart obterCart() {
        return obterUsuarioLogado().getCart();
    }

    public ItemCart bindItem(ItemCartDTO itemCartDTO) {

        if (itemCartDTO.getQuantidade().equals(0)) {
            // TODO adicionar exceção
        }

        Produto produto = produroService.findById(itemCartDTO.getProduto().getId());
        ItemCart itemCart = new ItemCart();
        itemCart.setProduto(produto);
        itemCart.setQuantidade(itemCartDTO.getQuantidade());

        return itemCart;
    }
    
    public void limparCarrinho(Cart cart) {
    	cart.getCartItens().removeAll(cart.getCartItens());
        cartRepository.save(cart);
    }
}
