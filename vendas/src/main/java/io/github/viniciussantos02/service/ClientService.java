package io.github.viniciussantos02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.viniciussantos02.model.Client;
import io.github.viniciussantos02.repository.ClientRepository;

@Service
public class ClientService {
	
	private ClientRepository repository;
	
	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}

	public void saveClient(Client client) {
		if (clientValidate(client)) {
			this.repository.saveClient(client);			
		}
	}
	
	private boolean clientValidate(Client client) {
		
		return true;
	}
}
