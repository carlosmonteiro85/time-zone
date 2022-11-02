package br.com.acme.fakeecomerce.timezone.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.acme.fakeecomerce.timezone.TimeZoneApplicationTests;
import br.com.acme.fakeecomerce.timezone.api.dto.ProdutoDTO;
import br.com.acme.fakeecomerce.timezone.domain.model.Imagem;
import br.com.acme.fakeecomerce.timezone.domain.model.Produto;
import br.com.acme.fakeecomerce.timezone.domain.service.ProductService;
import br.com.acme.fakeecomerce.timezone.util.AppConstantes;

public class ProductServiceTest extends TimeZoneApplicationTests {
	
	@Autowired
	private ProductService service;
	private Produto produto;
	
	@BeforeEach
	public void cenarioAntesDosTestes() {
		produto = criarProdutoParaTeste(); 
	}
	
	@AfterEach
	public void cenarioDepoisDosTestes() {
		//service.deleteAll();
	}
	
	@Test
	public void insertProduct() {
		service.save(produto);
		assertNotNull(produto.getId());
	}
	
	@Test
	public void listProdutos() {
		service.save(produto);
		List<ProdutoDTO> produtos = service.findProdutos();
		assertTrue(produtos.size() > 0);
	}
	
	@Test
	public void findProductById() throws Exception {
		service.save(produto);
		Produto productPersisted = service.findById(produto.getId());
		assertNotNull(productPersisted.getId());
		assertEquals(productPersisted.getId() , produto.getId());
	}
//	
//	@Test
//	public void orderByName() {
//		
//		// Cenario
//		Product product1 = getProductForTest();
//		product1.setName("AAA Product");
//		Product product2 = getProductForTest();
//		product2.setName("BBB Product");
//		Product product3 = getProductForTest();
//		product3.setName("ZZZ Product");
//		
//		productService.save(product1);
//		productService.save(product2);
//		productService.save(product3);
//		
//		// Teste
//		List<Order> orders = new ArrayList<>();
//		orders.add(new Order(Sort.Direction.DESC, "name"));
//		List<Product> produtos = productService.findAll(Sort.by(orders));
//
//		// Validação
//		assertEquals("ZZZ Product", produtos.get(0).getName());
//
//	}
//
//	public void orderByPrice() {
//
//		productService.deleteAll();
//
//		// Cenario
//		Product product1 = getProductForTest();
//		product1.setPrice(new BigDecimal(1));
//		Product product2 = getProductForTest();
//		product2.setPrice(new BigDecimal(5));
//		Product product3 = getProductForTest();
//		product3.setPrice(new BigDecimal(10));
//		
//		productService.save(product1);
//		productService.save(product2);
//		productService.save(product3);
//		
//		// Teste
//		List<Order> orders = new ArrayList<>();
//		orders.add(new Order(Sort.Direction.DESC, "price"));
//		List<Product> produtos = productService.findAll(Sort.by(orders));
//
//		// Validação
//		assertEquals(new BigDecimal(10), produtos.get(0).getPrice());
//
//	}

	public Produto criarProdutoParaTeste() {
		return Produto.builder()
					.nome("Relógio rolex gold")
					.preco(new BigDecimal(10000.00))
					.descricao("Este relógio de ouro amarelo de 18k de 40 mm"
							+ " apresenta uma caixa de ouro amarelo de 18k "
							+ "sólido com uma luneta de ouro amarelo de 18k "
							+ "sólido com um taquímetro. É equipado com uma "
							+ "pulseira Oyster em ouro amarelo polido escovado."
							+ " O impressionante mostrador verde tem ponteiros "
							+ "luminescentes e marcadores de horas de índice, "
							+ "detalhes em vermelho e um recurso de cronógrafo. ")
				.imagens(anexarImagens())
				.build();
	}
	
	private List<Imagem> anexarImagens(){
		List<Imagem> imagens = new ArrayList<>();
		Imagem imagem = new Imagem(AppConstantes.PATH_IMAGES + "popular1.png");
		imagens.add(imagem);
		return imagens;
	}
}
