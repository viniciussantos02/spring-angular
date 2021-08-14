package io.github.viniciussantos02.clientes.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvidedDTO {
	private String description;
	private String price;
	private String date;
	private Integer clientId;
}
