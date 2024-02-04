package br.com.acme.fakeecomerce.timezone.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.acme.fakeecomerce.timezone.api.dto.UserDTO;
import br.com.acme.fakeecomerce.timezone.api.mapper.UserDisassembler;
import br.com.acme.fakeecomerce.timezone.domain.model.Cart;
import br.com.acme.fakeecomerce.timezone.domain.model.User;
import br.com.acme.fakeecomerce.timezone.domain.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@Data
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;
	private final UserDisassembler userDisassembler;

	/*
	 * Obtem o usuario com id 1 caso exista, apenas para fins de teste de funcionalidade de carrinhho
	 * a implementação correta é que cada usuário possua seu carrinhho
	 * */
	public User obtemUsuario() {
	    
	    Optional<User> usuario = findById(1L);
	    
	    if(usuario.isEmpty()) {
	        User userPersisted = new User();
	        userPersisted.setCart(new Cart(userPersisted));
	        return repository.save(userPersisted);
	    }
	    
		return usuario.get();

	}
	
	public Optional<User> findById(Long id) {
		return repository.findById(id);
	}

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public void limparCart(Cart cart) {
		cart.getCartItens().removeAll(null);
	}
	
	public void save(User user) {
        repository.save(user);
    }

	public void updateDadosUsuario(UserDTO userDTO) {
		User user = obtemUsuario();
		userDisassembler.copyToDomainObject(userDTO, user);
		repository.save(user);
	}
}
