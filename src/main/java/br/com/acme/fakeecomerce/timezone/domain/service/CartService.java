package br.com.acme.fakeecomerce.timezone.domain.service;
//package br.com.acme.fakeecomerce.timezone.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//import br.com.acme.fakeecomerce.timezone.model.Cart;
//import br.com.acme.fakeecomerce.timezone.repository.CartRepository;
//
//@Service
//public class CartService {
//
//	private CartRepository cartRepository;
//
//	private CartService(CartRepository cartRepository) {
//		this.cartRepository = cartRepository;
//	}
//
//	public Cart save(Cart cart) {
//		return cartRepository.save(cart);
//	}
//
//	public Optional<Cart> findById(Long id) {
//		return cartRepository.findById(id);
//	}
//
//	public List<Cart> findAll() {
//		return cartRepository.findAll();
//	}
//
//	public void deleteById(long id) {
//		cartRepository.deleteById(id);
//	}
//
//}
