package br.com.acme.fakeecomerce.timezone.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.acme.fakeecomerce.timezone.api.dto.CartDTO;
import br.com.acme.fakeecomerce.timezone.domain.model.Cart;

@Component
public class CartAssembler {
	
	@Autowired
    private ModelMapper mapper;

    public CartDTO toDTO(Cart cart) {
        return mapper.map(cart, CartDTO.class);
    }

//    public List<ProdutoDTO> toCollectionDTO(List<Produto> list) {
//        return list.stream().map(this::toDTO).collect(Collectors.toList());
//    }
}
