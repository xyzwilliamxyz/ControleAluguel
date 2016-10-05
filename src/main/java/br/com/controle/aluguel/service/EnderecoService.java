package br.com.controle.aluguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.aluguel.model.Endereco;
import br.com.controle.aluguel.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco saveEndereco(Endereco endereco) {
		
		Endereco e = enderecoRepository.save(endereco);
		
		return e;
	}
	
	public List<Endereco> getEnderecos() {
		
		List<Endereco> enderecos = enderecoRepository.findAll();
		
		return enderecos;
	}
}
