package br.com.acme.fakeecomerce.timezone.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "checkout")
public class Checkout {

	private static final BigDecimal FRETE_GRATUITO = new BigDecimal(2000);

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@OneToOne
	private Cart cart;

	// TODO Mudar para o service
	public BigDecimal getSubtotal() {

		BigDecimal valorProdutos = new BigDecimal(0);

		for (ItemCart item : getCart().getCartItens()) {
			valorProdutos = valorProdutos
					.add(item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade())));
		}
		return valorProdutos;
	}

	// TODO Mudar para o service
	public BigDecimal getTotal() {
		return getSubtotal().add(getFrete());
	}

	// TODO Mudar para o service
	public BigDecimal getFrete() {

		BigDecimal valorProdutos = new BigDecimal(0);
		Integer quantidadeProdutos = 0;

		for (ItemCart item : getCart().getCartItens()) {

			quantidadeProdutos += item.getQuantidade();

			valorProdutos = valorProdutos
					.add(item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade())));

			/*
			 * Quando o valor dos produtos adicionados ao carrinho for igual ou superior a
			 * R$ 2000,00, o frete é grátis.
			 */
			if (valorProdutos.compareTo(FRETE_GRATUITO) >= 0 || cart.getUser().getRegiao().equals(RegiaoEnum.CENTRO_OESTE )) {
				return new BigDecimal(0);
			}
		}

		// A cada produto adicionado, deve-se somar R$ 10,00 ao frete.
		BigDecimal frete = new BigDecimal(quantidadeProdutos * 10);

		return frete;
	}
	
	public Checkout(Cart cart) {
	    this.cart = cart;
	}
}
