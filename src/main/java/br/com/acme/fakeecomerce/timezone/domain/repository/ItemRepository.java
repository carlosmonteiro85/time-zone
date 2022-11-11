package br.com.acme.fakeecomerce.timezone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.fakeecomerce.timezone.domain.model.ItemCart;

public interface ItemRepository extends JpaRepository<ItemCart, Long>{
}
