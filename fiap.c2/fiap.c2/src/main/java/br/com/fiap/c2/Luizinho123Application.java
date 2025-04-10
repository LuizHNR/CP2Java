package br.com.fiap.c2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.fiap.c2.model")
public class Luizinho123Application {

	public static void main(String[] args) {
		SpringApplication.run(Luizinho123Application.class, args);
	}

}
