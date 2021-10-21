package br.com.acme.fakeecomerce.timezone.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import br.com.acme.fakeecomerce.timezone.TimeZoneApplicationTests;
import br.com.acme.fakeecomerce.timezone.model.Product;


public class ProductServiceTest extends TimeZoneApplicationTests{
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void insertProduct() {
		// Cenário
		Product product = getProductForTest();
		
		// Ação
		productService.save(product);
		
		//Verificação
		assertNotNull(product.getId());
	}
	
	@Test
	public void updateProduct() {
		// Cenário
		Product product = getProductForTest();
		productService.save(product);
		
		product.setName(faker.commerce().productName() + " [ATUALIZADO]");
		
		// Ação
		productService.save(product);
		
		//Verificação
		Product productPersisted = productService.findById(product.getId()).orElse(new Product());
		assertNotNull(productPersisted);
		assertTrue(productPersisted.getName().endsWith("[ATUALIZADO]"));
	}
	
	@Test
	public void listAllProducts() {
		
		// Cenário
		Product product1 = getProductForTest();
		Product product2 = getProductForTest();
		Product product3 = getProductForTest();
		productService.save(product1);
		productService.save(product2);
		productService.save(product3);
		
		// Ação
		List<Product> allProducts = productService.findAll();
		
		//Verificação
		assertTrue(allProducts.size() >= 3);
	}
	
	@Test
	public void findProductById() {
		
		// Cenário
		Product product = getProductForTest();
		productService.save(product);
		
		// Ação
		Product productPersisted = productService.findById(product.getId()).orElse(null);
		
		//Verificação
		assertNotNull(productPersisted);
		assertEquals(product.getId(), productPersisted.getId());
	}
	
	@Test
	public void orderByName() {
		
		// Cenario
		Product product1 = getProductForTest();
		product1.setName("AAA Product");
		Product product2 = getProductForTest();
		product2.setName("BBB Product");
		Product product3 = getProductForTest();
		product3.setName("ZZZ Product");
		
		productService.save(product1);
		productService.save(product2);
		productService.save(product3);
		
		// Teste
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(Sort.Direction.DESC, "name"));
		List<Product> produtos = productService.findAll(Sort.by(orders));

		// Validação
		assertEquals("ZZZ Product", produtos.get(0).getName());

	}

	public void orderByPrice() {

		productService.deleteAll();

		// Cenario
		Product product1 = getProductForTest();
		product1.setPrice(new BigDecimal(1));
		Product product2 = getProductForTest();
		product2.setPrice(new BigDecimal(5));
		Product product3 = getProductForTest();
		product3.setPrice(new BigDecimal(10));
		
		productService.save(product1);
		productService.save(product2);
		productService.save(product3);
		
		// Teste
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(Sort.Direction.DESC, "price"));
		List<Product> produtos = productService.findAll(Sort.by(orders));

		// Validação
		assertEquals(new BigDecimal(10), produtos.get(0).getPrice());

	}

	public void orderByScore() {


		// Cenario
		Product product1 = getProductForTest();
		product1.setScore(1);
		Product product2 = getProductForTest();
		product2.setScore(5);
		Product product3 = getProductForTest();
		product3.setScore(10);
		
		productService.save(product1);
		productService.save(product2);
		productService.save(product3);
		
		// Teste
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(Sort.Direction.DESC, "price"));
		List<Product> produtos = productService.findAll(Sort.by(orders));

		// Validação
		assertEquals(10, produtos.get(0).getScore());

	}

	private Product getProductForTest() {
		Product product = new Product();
		product.setImage(faker.avatar().image());
		product.setName(faker.commerce().productName());
		product.setPrice(new BigDecimal(faker.number().randomDouble(2, 10, 10000)));
		product.setScore(faker.random().nextInt(0, 1000));
		return product;
	}

}
