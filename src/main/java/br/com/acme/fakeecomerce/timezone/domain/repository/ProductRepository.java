package br.com.acme.fakeecomerce.timezone.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.acme.fakeecomerce.timezone.domain.model.Produto;

public interface ProductRepository extends JpaRepository<Produto, Long> {
    
    @Query(value = "SELECT * FROM PRODUTOS  p  ORDER BY p.PRECO ASC", nativeQuery = true)
    List<Produto> ordenadoPorPreco();

}
