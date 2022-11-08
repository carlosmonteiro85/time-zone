package br.com.acme.fakeecomerce.timezone.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemCartDTO {

	private ProdutoDTO produto;
	private Integer quantidade;

	public ItemCartDTO(ProdutoDTO produto) {
		this.produto = produto;
		this.quantidade = 1;
	}
}
