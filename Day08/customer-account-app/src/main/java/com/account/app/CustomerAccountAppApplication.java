package com.account.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "Descrption for api URL") })
@SpringBootApplication
public class CustomerAccountAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAccountAppApplication.class, args);
	}

}
