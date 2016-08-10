package br.com.controle.aluguel.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.aluguel.model.Pessoa;
import br.com.controle.aluguel.service.PessoaService;

@RestController
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping("/pessoa")
	public ResponseEntity<List<Pessoa>> getPessoas() {
		
		List<Pessoa> pessoas = pessoaService.getPessoas();
		
		return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK);
	}
	
}
