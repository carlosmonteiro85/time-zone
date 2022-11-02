package br.com.acme.fakeecomerce.timezone.domain.service;
//package br.com.acme.fakeecomerce.timezone.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//import br.com.acme.fakeecomerce.timezone.model.Cart;
//import br.com.acme.fakeecomerce.timezone.model.User;
//import br.com.acme.fakeecomerce.timezone.repository.UserRepository;
//
//@Service
//public class UserService {
//
//	private UserRepository repository;
//
//	public UserService(UserRepository repository) {
//		this.repository = repository;
//	}
//
//	public User save(User user) {
//		return repository.save(user);
//
//	}
//	
//	public Optional<User> findById(Long id) {
//		return repository.findById(id);
//	}
//
//	public List<User> findAll() {
//		return repository.findAll();
//	}
//	
//	public void deleteById(long id) {
//		repository.deleteById(id);
//	}
//	
//	public void limparCart(Cart cart) {
//		cart.getCartItens().removeAll(null);
//		
//	}
//
//}
