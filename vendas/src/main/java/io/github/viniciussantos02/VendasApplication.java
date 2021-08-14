package io.github.viniciussantos02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication {
	
	@Value("${applicaton.name}")
	private String applicationName;
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String helloWorld() {
		return applicationName;
	}
}
