package io.github.viniciussantos02.clientes.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.viniciussantos02.clientes.model.entity.ServiceProvided;

public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Integer> {
	
	@Query("SELECT s FROM ServiceProvided s JOIN s.client c WHERE upper( c.name ) LIKE upper( :name ) AND MONTH( s.date ) =:month")
	List<ServiceProvided> findByNameAndMonth(@Param("name") String name, @Param("month") Integer month);

}
