package br.com.acme.fakeecomerce.timezone.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.acme.fakeecomerce.timezone.api.dto.ProdutoDTO;
import br.com.acme.fakeecomerce.timezone.domain.model.Produto;

@Component
public class ProdutoAssembler {
	
	@Autowired
    private ModelMapper mapper;

    public ProdutoDTO toDTO(Produto produto) {
        return mapper.map(produto, ProdutoDTO.class);
    }

    public List<ProdutoDTO> toCollectionDTO(List<Produto> list) {
        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
