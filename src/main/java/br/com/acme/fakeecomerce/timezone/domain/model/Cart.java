package br.com.acme.fakeecomerce.timezone.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Cart {

    @Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<ItemCart> cartItens = new ArrayList<>();

	@Getter
	@OneToOne (mappedBy = "cart")
	private User user;

	public void addItemCart(ItemCart itens) {
	    getCartItens().add(itens);
	}
	
	public void removeItemCart(ItemCart itens) {
        getCartItens().remove(itens);
    }
	
	public void cleanCart() {
		user.getCart().cartItens.removeAll(cartItens);
	}
	
	public Cart(User usuario) {
	    this.user = usuario;
	}
}
