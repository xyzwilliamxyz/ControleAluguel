package br.com.controle.aluguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.aluguel.exception.CustomException;
import br.com.controle.aluguel.model.Casa;
import br.com.controle.aluguel.model.Endereco;
import br.com.controle.aluguel.repository.CasaRepository;
import br.com.controle.aluguel.repository.EnderecoRepository;

@Service
public class CasaService {

	@Autowired
	private CasaRepository casaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Casa saveCasa(Casa casa) throws CustomException {
		
		Endereco endereco = enderecoRepository.findByEnderecoId(casa.getEndereco().getEnderecoId());
		
		if (endereco == null) {
			throw new CustomException("Endereço não encontrado");
		}
		casa.setEndereco(endereco);
		
		Casa c = casaRepository.save(casa);
		
		return c;
	}
	
	public List<Casa> getCasas() {
		
		List<Casa> casas = casaRepository.findAll();
		
		return casas;
	}
}
