package br.com.acme.fakeecomerce.timezone.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.acme.fakeecomerce.timezone.api.dto.UserDTO;
import br.com.acme.fakeecomerce.timezone.domain.model.User;

@Component
public class UserDisassembler {

	@Autowired
	private ModelMapper mapper;

	public User toModel(UserDTO usuario) {
		return mapper.map(usuario, User.class);
	}
	
   public void copyToDomainObject(UserDTO userDTO, User user) {
        mapper.map(userDTO, user);
    }
}
