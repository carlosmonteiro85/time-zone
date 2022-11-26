package br.com.acme.fakeecomerce.timezone.domain.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.model.Checkout;
import br.com.acme.fakeecomerce.timezone.domain.model.ItemCart;
import br.com.acme.fakeecomerce.timezone.domain.model.RegiaoEnum;
import br.com.acme.fakeecomerce.timezone.util.AppConstantes;

@Service
public class CheckoutService {

	private BigDecimal obterValorFrete(Cart cart) {
		BigDecimal valorProdutos = new BigDecimal(0);
		int quantidadeProdutos = 0;
		for (ItemCart item : cart.getCartItens()) {
			quantidadeProdutos += item.getQuantidade();
			valorProdutos = valorProdutos.add(item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade())));
			
			if (valorProdutos.compareTo(AppConstantes.FRETE_GRATUITO) >= 0 || cart.getUser().getRegiao().equals(RegiaoEnum.CENTRO_OESTE)) {
				return new BigDecimal(0);
			}
			
		}
		return new BigDecimal(quantidadeProdutos * 10);
	}
	
	private BigDecimal getSubtotal(Cart cart) {
		BigDecimal valorProdutos = new BigDecimal(0);
		for (ItemCart item : cart.getCartItens()) {
			valorProdutos = valorProdutos
					.add(item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade())));
		}
		return valorProdutos;
	}
	
	public Checkout obterCheckout(Cart cart) {
		BigDecimal subtotal = getSubtotal(cart);
		BigDecimal frete = obterValorFrete(cart);
		BigDecimal total = subtotal.add(frete);
		return new Checkout(cart, frete, subtotal,total);
	}
}