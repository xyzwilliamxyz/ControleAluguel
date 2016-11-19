package br.com.controle.aluguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.aluguel.exception.CustomException;
import br.com.controle.aluguel.model.Pessoa;
import br.com.controle.aluguel.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa getPessoaByID(Long pessoaId) throws CustomException {
		
		if (pessoaId == null || pessoaId == 0L) {
			throw new CustomException("Casa não encontrada.");
		}
		
		return pessoaRepository.findOne(pessoaId);
	}
	
	public List<Pessoa> getPessoas() {
		
		List<Pessoa> pessoas = pessoaRepository.findAll();
		
		return pessoas;
	}
	
	public Pessoa savePessoa(Pessoa pessoa) {
		
		Pessoa p = pessoaRepository.save(pessoa);
		
		return p;
	}
}
