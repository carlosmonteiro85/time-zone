package br.com.acme.fakeecomerce.timezone.api.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CartDTO {
	private List<ItemCartDTO> cartItens = new ArrayList<>();
}
