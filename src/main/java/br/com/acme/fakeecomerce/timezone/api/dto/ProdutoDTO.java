package br.com.acme.fakeecomerce.timezone.api.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.acme.fakeecomerce.timezone.domain.model.Imagem;
import lombok.Data;

@Data
public class ProdutoDTO {
	private Long id;
	private String nome;
	private BigDecimal preco;
	private String descricao;
	private List<Imagem> imagens;
}
