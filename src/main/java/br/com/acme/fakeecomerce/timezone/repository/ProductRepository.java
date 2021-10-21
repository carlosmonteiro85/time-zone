package br.com.acme.fakeecomerce.timezone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.fakeecomerce.timezone.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
