package br.com.acme.fakeecomerce.timezone.domain.service;

import org.springframework.stereotype.Service;

import br.com.acme.fakeecomerce.timezone.domain.model.ItemCart;
import br.com.acme.fakeecomerce.timezone.domain.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public ItemCart findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Carrinho não encontrado."));
    }
}
