package br.com.controle.aluguel.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"br.com.controle.aluguel"})
public class ControleAluguelApplication {

	public static void main(String[] args) {
		System.out.println("XYZ");
		SpringApplication.run(ControleAluguelApplication.class, args);
	}
}
