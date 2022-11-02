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
//import br.com.acme.fakeecomerce.timezone.model.Checkout;
//import br.com.acme.fakeecomerce.timezone.model.ItemCart;
//import br.com.acme.fakeecomerce.timezone.model.Product;
//
//public class CheckoutServiceTest extends TimeZoneApplicationTests {
//	
//	@Autowired
//	private CheckoutService checkoutService; 
//	
//	@Autowired
//	private CartService cartService;
//	
//	@Autowired
//	private ProductService productService;
//	
////	@Test
//	public void insertCheckout() {
//		
//		// Cenário
//		Checkout checkout = new Checkout();
//		checkout.setCart(generateCartForTest());
//		
//		// Ação
//		checkoutService.save(checkout);
//		
//		// Verificação
//		assertNotNull(checkout.getId());
//	}
//	
//	@Test
//	public void insertCheckoutWithFrete() {
//		
//		// Cenário
//		Product product1 = new Product();
////		product1.setImage(faker.avatar().image());
//		product1.setName(faker.commerce().productName());
//		product1.setPrice(new BigDecimal(10));
//		productService.save(product1);
//		
//		Product product2 = new Product();
////		product2.setImage(faker.avatar().image());
//		product2.setName(faker.commerce().productName());
//		product2.setPrice(new BigDecimal(5));
//		productService.save(product2);
//		
//		Cart cart = new Cart();
//		cart.getCartItens().add(new ItemCart(product1, cart, 10));
//		cart.getCartItens().add(new ItemCart(product2, cart, 3));
//		cartService.save(cart);
//		
//		Checkout checkout = new Checkout();
//		checkout.setCart(cart);
//		
//		// Ação
//		checkoutService.save(checkout);
//		
//		// Verificação
//		assertEquals(new BigDecimal(130), checkout.getFrete(), "Valor do frete deve ser de R$ 130,00");
//		assertEquals(new BigDecimal(115), checkout.getSubtotal(), "Valor do subtotal dos produtos deve ser de R$ 150,00");
//		assertEquals(new BigDecimal(245), checkout.getTotal(), "Valor do total do checkout deve ser de R$ 245,00");
//		
//	}
//	
//	private Cart generateCartForTest() {
//		
//		Product product1 = generateProductForTest();
//		Product product2 = generateProductForTest();
//		Product product3 = generateProductForTest();
//		
//		Cart cart = new Cart();
//		
//		cart.getCartItens().add(new ItemCart(product1, cart, faker.number().numberBetween(1, 100)));
//		cart.getCartItens().add(new ItemCart(product2, cart, faker.number().numberBetween(1, 100)));
//		cart.getCartItens().add(new ItemCart(product3, cart, faker.number().numberBetween(1, 100)));
//		
//		return cartService.save(cart);
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
//}
