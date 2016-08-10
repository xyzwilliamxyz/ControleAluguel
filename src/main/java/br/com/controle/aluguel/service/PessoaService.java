package br.com.controle.aluguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.aluguel.model.Pessoa;
import br.com.controle.aluguel.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> getPessoas() {
		
		List<Pessoa> pessoas = pessoaRepository.findAll();
		
		return pessoas;
	}
}
