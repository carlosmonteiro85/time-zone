package br.com.acme.fakeecomerce.timezone.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.acme.fakeecomerce.timezone.api.dto.ProdutoDTO;
import br.com.acme.fakeecomerce.timezone.domain.model.Produto;

@Component
public class ProdutoDisassembler {

	@Autowired
	private ModelMapper mapper;

	public Produto toModel(ProdutoDTO produto) {
		return mapper.map(produto, Produto.class);
	}

	public List<Produto> toCollectionDTO(List<ProdutoDTO> list) {
		return list.stream().map(this::toModel).collect(Collectors.toList());
	}

	public void copyToDomainObject(ProdutoDTO produtoDTO, Produto produto) {
		mapper.map(produtoDTO, produto);
	}
}
