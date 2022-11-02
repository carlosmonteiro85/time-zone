package br.com.acme.fakeecomerce.timezone.domain.model;
//package br.com.acme.fakeecomerce.timezone.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//@Entity
//public class Cart {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<ItemCart> cartItens = new ArrayList<>();
//	
//	@OneToOne (mappedBy = "cart")
//	private User user;
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public List<ItemCart> getCartItens() {
//		return cartItens;
//	}
//
//	public void setCartItens(List<ItemCart> cartItens) {
//		this.cartItens = cartItens;
//	}
//	
//	public void cleanCart() {
//		user.getCart().cartItens.removeAll(cartItens);
//	}
//
//}
