package br.com.acme.fakeecomerce.timezone.domain.model;
//package br.com.acme.fakeecomerce.timezone.model;
//
//import java.math.BigDecimal;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//@Entity
//public class Checkout {
//
//	private static final BigDecimal FRETE_GRATUITO = new BigDecimal(250);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@OneToOne
//	private Cart cart;
//
//	@JsonProperty
//	public BigDecimal getSubtotal() {
//
//		BigDecimal valorProdutos = new BigDecimal(0);
//
//		for (ItemCart item : getCart().getCartItens()) {
//			valorProdutos = valorProdutos
//					.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())));
//		}
//		return valorProdutos;
//	}
//
//	@JsonProperty
//	public BigDecimal getTotal() {
//		return getSubtotal().add(getFrete());
//	}
//
//	@JsonProperty
//	public BigDecimal getFrete() {
//
//		BigDecimal valorProdutos = new BigDecimal(0);
//		Integer quantidadeProdutos = 0;
//
//		for (ItemCart item : getCart().getCartItens()) {
//
//			quantidadeProdutos += item.getQuantity();
//
//			valorProdutos = valorProdutos
//					.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())));
//
//			/*
//			 * Quando o valor dos produtos adicionados ao carrinho for igual ou superior a
//			 * R$ 250,00, o frete é grátis.
//			 */
//			if (valorProdutos.compareTo(FRETE_GRATUITO) >= 0) {
//				return new BigDecimal(0);
//			}
//
//		}
//
//		// A cada produto adicionado, deve-se somar R$ 10,00 ao frete.
//		BigDecimal frete = new BigDecimal(quantidadeProdutos * 10);
//
//		return frete;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
//
//}
