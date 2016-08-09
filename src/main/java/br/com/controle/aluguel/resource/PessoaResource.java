package br.com.controle.aluguel.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.aluguel.service.PessoaService;

@RestController
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	
}
