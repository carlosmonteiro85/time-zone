package br.com.acme.fakeecomerce.timezone.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.acme.fakeecomerce.timezone.api.dto.ProdutoDTO;
import br.com.acme.fakeecomerce.timezone.api.mapper.ProdutoAssembler;
import br.com.acme.fakeecomerce.timezone.core.exception.ProdutoNaoEncontradoException;
import br.com.acme.fakeecomerce.timezone.domain.model.Produto;
import br.com.acme.fakeecomerce.timezone.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository repository;
	private final ProdutoAssembler mapper;

	public Produto save(Produto product) {
		return repository.save(product);
	}

	public List<ProdutoDTO> findProdutos() {
		return mapper.toCollectionDTO(repository.findAll());
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public Produto findById(Long id){
		return repository.findById(id).orElseThrow( () -> new ProdutoNaoEncontradoException("Produto não Encontrado."));
	}
	
	   public List<ProdutoDTO> ordenadoPormenoresPrecos() {
	        return mapper.toCollectionDTO(repository.ordenadoPorPreco());
	    }
	
//
//	public List<Product> findAll() {
//		return productRepository.findAll();
//	}
//
//	public void deleteById(long id) {
//		productRepository.deleteById(id);
//	}
//
//	public List<Product> findAll(Sort sort) {
//		return productRepository.findAll(sort);
//	}
//
//	public void deleteAll() {
//		productRepository.deleteAll();
//	}
}