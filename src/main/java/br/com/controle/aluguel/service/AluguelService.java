package br.com.controle.aluguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.aluguel.exception.CustomException;
import br.com.controle.aluguel.model.Aluguel;
import br.com.controle.aluguel.model.Casa;
import br.com.controle.aluguel.model.Pessoa;
import br.com.controle.aluguel.model.PessoaAluguel;
import br.com.controle.aluguel.repository.AluguelRepository;
import br.com.controle.aluguel.repository.CasaRepository;
import br.com.controle.aluguel.repository.PessoaRepository;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepository aluguelRepository;
	
	@Autowired
	private CasaRepository casaRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Aluguel saveAluguel(Aluguel aluguel) throws CustomException {
		
		Casa casa = casaRepository.findOne(aluguel.getCasa().getCasaId());
		
		if (casa == null) {
			throw new CustomException("Casa não encontrada");
		}
		
		for (PessoaAluguel p : aluguel.getPessoaAluguels()) {
			Pessoa pFetched = pessoaRepository.findOne(p.getPessoa().getPessoaId());
			
			if (pFetched == null) {
				throw new CustomException("Pessoa " + p.getPessoa().getNome() + " não encontrada");
			}
			
			p.setPessoa(pFetched);
		}
		
		aluguel.setCasa(casa);
		
		Aluguel a = aluguelRepository.save(aluguel);
		
		return a;
	}
	
	public List<Aluguel> getAluguels() {
		
		List<Aluguel> aluguels = aluguelRepository.findAll();
		
		return aluguels;
	}
}
