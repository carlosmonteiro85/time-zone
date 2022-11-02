package br.com.acme.fakeecomerce.timezone.domain.model;
//package br.com.acme.fakeecomerce.timezone.model;
//
//import java.util.Objects;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Transient;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//@Entity
//public class ItemCart {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@ManyToOne
//	@JoinColumn(name = "id_product", nullable = false)
//	@JsonIgnore // Para evitar referências ciclicas ao serializar para json
//	private Product product;
//
//	@ManyToOne
//	@JoinColumn(name = "id_cart", nullable = false)
//	@JsonIgnore // Para evitar referências ciclicas ao serializar para json
//	private Cart cart;
//
//	private Integer quantity;
//	
//	public ItemCart() {
//	}
//
//	public ItemCart(Product product, Cart cart, Integer quantity) {
//		this.product = product;
//		this.cart = cart;
//		this.quantity = quantity;
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
//	public Product getProduct() {
//		return product;
//	}
//	
//	@Transient
//	private Long productId;
//	
//	public Long getProductId() {
//		if (product != null) {
//			return product.getId();
//		}
//		return null; 
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//	
//	public void setProductId(Long productId) {
//		this.productId = productId;
//		this.product = new Product();
//		this.product.setId(productId);
//	}
//
//	public Cart getCart() {
//		return cart;
//	}
//	
//	@JsonProperty
//	public Long getCartId() {
//		if (cart != null) {
//			return cart.getId();
//		}
//		return null;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
//
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ItemCart other = (ItemCart) obj;
//		return Objects.equals(id, other.id);
//	}
//
//}
