package io.github.viniciussantos02.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.viniciussantos02.clientes.model.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
