package io.github.viniciussantos02.clientes.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.viniciussantos02.clientes.model.entity.Client;
import io.github.viniciussantos02.clientes.model.entity.ServiceProvided;
import io.github.viniciussantos02.clientes.model.repository.ClientRepository;
import io.github.viniciussantos02.clientes.model.repository.ServiceProvidedRepository;
import io.github.viniciussantos02.clientes.rest.dto.ServiceProvidedDTO;
import io.github.viniciussantos02.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/services-provided")
@RequiredArgsConstructor
public class ServiceProvidedController {
	private final ClientRepository clientRepository;
	private final ServiceProvidedRepository serviceProvidedRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceProvided saveService(@RequestBody ServiceProvidedDTO dto) {
		LocalDate date = LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer clientId = dto.getClientId();
		
		Client client = clientRepository.findById(clientId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
		
		ServiceProvided serviceProvided = new ServiceProvided();
		serviceProvided.setDescription(dto.getDescription());
		serviceProvided.setDate(date);
		serviceProvided.setClient(client);
		serviceProvided.setPrice(BigDecimalConverter.convert(dto.getPrice()));
		
		return serviceProvidedRepository.save(serviceProvided);
	}
	
	@GetMapping
	public List<ServiceProvided> searchService(@RequestParam(value = "name", required = false, defaultValue = "") String name, 
			@RequestParam(value = "month", required = false) Integer month){
		return serviceProvidedRepository.findByNameAndMonth("%" + name + "%", month);
	}
}
