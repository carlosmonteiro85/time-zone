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
	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Getter
	@OneToOne
	private Cart cart;
	@Getter
	private BigDecimal subTotal;
	@Getter
	private BigDecimal total;
	@Getter
	private BigDecimal frete;

	public Checkout(Cart cart) {
	    this.cart = cart;
	}

	public Checkout(Cart cart, BigDecimal subTotal, BigDecimal total, BigDecimal frete) {
		this.cart = cart;
		this.frete = frete;
		this.subTotal = subTotal;
		this.total = total;
	}
}
