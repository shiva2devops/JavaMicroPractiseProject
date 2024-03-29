package com.shiva.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "My controller for rest") })
@SpringBootApplication
public class SpringStudentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudentAppApplication.class, args);
	}

}
