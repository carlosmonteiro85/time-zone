package br.com.acme.fakeecomerce.timezone.api.dto;

import java.math.BigDecimal;

import javax.persistence.OneToOne;

import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import lombok.Getter;
import lombok.Setter;


public class CheckoutDTO {
	@Getter
	@Setter
	@OneToOne
	private Cart cart;
	@Getter
	@Setter
	private BigDecimal subTotal;
	@Getter
	@Setter
	private BigDecimal total;
	@Getter
	@Setter
	private BigDecimal frete;
}
