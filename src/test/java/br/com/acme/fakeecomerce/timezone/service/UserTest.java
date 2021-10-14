package br.com.acme.fakeecomerce.timezone.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.acme.fakeecomerce.timezone.TimeZoneApplicationTests;
import br.com.acme.fakeecomerce.timezone.model.Cart;
import br.com.acme.fakeecomerce.timezone.model.User;

public class UserTest extends TimeZoneApplicationTests {

	@Autowired
	private UserService service;

	@Test
	public void createUser() {
		// Cenario
		User user = createUserTest();

		Cart cart = new Cart();
		cart.setUser(user);

		user.setCart(cart);

		// Teste
		service.save(user);

		// Validação
		assertTrue(user.getId() != null);

	}

	@Test
	public void updateProduct() {

		// Cenario
		User user = createUserTest();
		Cart cart = new Cart();
		cart.setUser(user);
		user.setCart(cart);
		service.save(user);

		// Teste
		user.setName(faker.name().name() + " [ATUALIZADO]");
		service.save(user);

		User userUpdate = service.findById(user.getId()).orElse(new User());

		// Validação
		assertNotNull(userUpdate);
		assertEquals(userUpdate.getName(), user.getName());

	}

	@Test
	public void ListAll() {
		
		//Cenario
		User user = createUserTest();
		Cart cart = new Cart();
		cart.setUser(user);
		user.setCart(cart);
		service.save(user);

		//Teste
		List<User> users = service.findAll();

		//Validação
		assertTrue(users.size() >= 1);
	}
	
	@Test
	public void deleteUser() {
		
		//Cenario
		User user = createUserTest();
		Cart cart = new Cart();
		cart.setUser(user);
		user.setCart(cart);
		service.save(user);
		
		//Teste
		service.deleteById(user.getId());
		User userDeleted = service.findById(user.getId()).orElse(null);
		
		//Validation
		assertTrue(userDeleted == null);
		
	}

	private User createUserTest() {
		User user = new User();
		user.setName(faker.name().name());
		user.setAddress(faker.address().cityName());
		user.setMail(String.valueOf(System.currentTimeMillis() + 1) + "@.com");
		user.setPassword(faker.expression("asdf"));
		return user;
	}

}
