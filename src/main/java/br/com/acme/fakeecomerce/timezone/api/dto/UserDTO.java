package br.com.acme.fakeecomerce.timezone.api.dto;

import br.com.acme.fakeecomerce.timezone.domain.model.RegiaoEnum;
import lombok.Data;

@Data
public class UserDTO {
	private RegiaoEnum regiao;
}
