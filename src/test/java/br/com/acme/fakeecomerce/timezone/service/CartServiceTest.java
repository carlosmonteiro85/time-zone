//package br.com.acme.fakeecomerce.timezone.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.math.BigDecimal;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import br.com.acme.fakeecomerce.timezone.TimeZoneApplicationTests;
//import br.com.acme.fakeecomerce.timezone.model.Cart;
//import br.com.acme.fakeecomerce.timezone.model.ItemCart;
//import br.com.acme.fakeecomerce.timezone.model.Product;
//import br.com.acme.fakeecomerce.timezone.model.User;
//
//public class CartServiceTest extends TimeZoneApplicationTests {
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private ProductService productService;
//
//	@Test
//	public void insertCart() {
//
//		User user = createUserTest();
//
//		// Cenário
//		Product product1 = generateProductForTest();
//		Product product2 = generateProductForTest();
//
//		Cart cart = new Cart();
//		cart.getCartItens().add(new ItemCart(product1, cart, 3));
//		cart.getCartItens().add(new ItemCart(product2, cart, 5));
//
//		user.setCart(cart);
//		cart.setUser(user);
//
//		// Ação
//		userService.save(user);
//
//		// Verificações
//		assertNotNull(cart.getId());
//
//		User userPersisted = userService.findById(user.getId()).orElse(null);
//
//		Cart cartPersited = userPersisted.getCart();
//
//		assertNotNull(cartPersited);
//		assertEquals(2, cartPersited.getCartItens().size());
//	}
//
//	@Test
//	public void addItemCart() {
//
//		// Cenário
//		Product product1 = generateProductForTest();
//		Product product2 = generateProductForTest();
//
//		User user = createUserTest();
//		Cart cart = new Cart();
//		cart.getCartItens().add(new ItemCart(product1, cart, 3));
//		cart.getCartItens().add(new ItemCart(product2, cart, 5));
//
//		user.setCart(cart);
//		cart.setUser(user);
//
//		// Ação
//		userService.save(user);
//		Product product3 = generateProductForTest();
//		
//		cart.getCartItens().add(new ItemCart(product3, cart, 10));
//		userService.save(user);
//
//		// Verificações
//		Cart cartPersisted = user.getCart();
//		assertEquals(3, cartPersisted.getCartItens().size());
//	}
////	
//	@Test
//	public void removeItemCart() {
//
//		// Cenário
//		Product product1 = generateProductForTest();
//		Product product2 = generateProductForTest();
//
//		User user = createUserTest();
//		Cart cart = new Cart();
//		cart.getCartItens().add(new ItemCart(product1, cart, 3));
//		cart.getCartItens().add(new ItemCart(product2, cart, 5));
//
//		user.setCart(cart);
//		cart.setUser(user);
//		
//		Cart cartWithRemovedItem = user.getCart();
//		cartWithRemovedItem.getCartItens().remove(0);
//		userService.save(user);
//
//		// Verificações
//		Cart cartPersisted = userService.findById(user.getId()).get().getCart();
//		assertEquals(1, cartPersisted.getCartItens().size());
//	}
//	
//	@Test
//	public void limparCart() {
//
//		// Cenário
//		Product product1 = generateProductForTest();
//		Product product2 = generateProductForTest();
//
//		User user = createUserTest();
//		Cart cart = new Cart();
//		cart.getCartItens().add(new ItemCart(product1, cart, 3));
//		cart.getCartItens().add(new ItemCart(product2, cart, 5));
//
//		user.setCart(cart);
//		cart.setUser(user);
//
//		// Ação
//		user.getCart().cleanCart();
//		userService.save(user);
//
//		// Verificações		
//		assertEquals(user.getCart().getCartItens().size() , 0);
//	}
//
//	private Product generateProductForTest() {
//		Product product = new Product();
////		product.setImage(faker.avatar().image());
//		product.setName(faker.commerce().productName());
//		product.setPrice(new BigDecimal(faker.number().randomDouble(2, 10, 10000)));
//		return productService.save(product);
//	}
//
//	private User createUserTest() {
//		User user = new User();
//		user.setName(faker.name().name());
//		user.setAddress(faker.address().cityName());
//		user.setMail(String.valueOf(System.currentTimeMillis() + 1) + "@.com");
//		user.setPassword(faker.expression("asdf"));
//		return user;
//	}
//
//}
