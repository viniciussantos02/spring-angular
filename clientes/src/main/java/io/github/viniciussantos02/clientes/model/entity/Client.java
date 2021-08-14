package io.github.viniciussantos02.clientes.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 150)
	@NotEmpty(message = "{name.cant.beempty}")
	private String name;
	
	@Column(nullable = false, length = 150)
	@NotNull(message = "{cpf.cant.beempty}")
	@CPF(message = "{cpf.invalidated}")
	private String cpf;
	
	@Column(name = "register_data", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate registerDate;
	
	@PrePersist
	public void prePersist() {
		setRegisterDate(LocalDate.now());
	}
}
