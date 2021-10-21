package br.com.acme.fakeecomerce.timezone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.acme.fakeecomerce.timezone.model.Product;
import br.com.acme.fakeecomerce.timezone.repository.ProductRepository;



@Service
public class ProductService {

	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public void deleteById(long id) {
		productRepository.deleteById(id);
	}

	public List<Product> findAll(Sort sort) {
		return productRepository.findAll(sort);
	}

	public void deleteAll() {
		productRepository.deleteAll();
	}

}