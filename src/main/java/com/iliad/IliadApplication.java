package com.iliad;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title = "Iliad Api",description = "parsing numbers list",version="1.0") )
public class IliadApplication {

	public static void main(String[] args) {
		SpringApplication.run(IliadApplication.class, args);
	}

}
