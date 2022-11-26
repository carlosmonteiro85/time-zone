package br.com.acme.fakeecomerce.timezone.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.acme.fakeecomerce.timezone.api.dto.CheckoutDTO;
import br.com.acme.fakeecomerce.timezone.domain.model.Checkout;

@Component
public class CheckoutAssembler {
	
	@Autowired
    private ModelMapper mapper;

    public CheckoutDTO toDTO(Checkout check) {
        return mapper.map(check, CheckoutDTO.class);
    }
}
