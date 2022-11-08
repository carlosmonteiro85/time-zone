package br.com.acme.fakeecomerce.timezone.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class ItemCart {

    @Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Setter
    @Getter
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;

	@Getter
    @Setter
	private Integer quantidade;
	
	public ItemCart() {
	}

	public ItemCart(Produto produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
}
