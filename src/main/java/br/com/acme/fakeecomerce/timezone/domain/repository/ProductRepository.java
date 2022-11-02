package br.com.acme.fakeecomerce.timezone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.fakeecomerce.timezone.domain.model.Produto;

public interface ProductRepository extends JpaRepository<Produto, Long> {

}
