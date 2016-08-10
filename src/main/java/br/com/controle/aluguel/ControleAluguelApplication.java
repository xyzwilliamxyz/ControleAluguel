package br.com.controle.aluguel;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class ControleAluguelApplication {

	@Bean
	public LocaleResolver localeResolver() {
		
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("pt", "BR"));
		return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(ControleAluguelApplication.class, args);
	}
}
