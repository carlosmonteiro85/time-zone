package br.com.acme.fakeecomerce.timezone.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.acme.fakeecomerce.timezone.api.dto.ItemCartDTO;
import br.com.acme.fakeecomerce.timezone.domain.model.ItemCart;

@Component
public class CartDisassembler {

	@Autowired
	private ModelMapper mapper;

	public ItemCart toModel(ItemCartDTO item) {
		return mapper.map(item, ItemCart.class);
	}

//	public List<Produto> toCollectionDTO(List<ProdutoDTO> list) {
//		return list.stream().map(this::toModel).collect(Collectors.toList());
//	}
//
//	public void copyToDomainObject(ProdutoDTO produtoDTO, Produto produto) {
//		mapper.map(produtoDTO, produto);
//	}
}
