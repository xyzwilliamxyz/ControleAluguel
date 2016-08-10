package br.com.controle.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.aluguel.model.Casa;
import br.com.controle.aluguel.repository.CasaRepository;

@Service
public class CasaService {

	@Autowired
	private CasaRepository casaRepository;
	
	public Casa saveCasa(Casa casa) {
		
		Casa c = casaRepository.save(casa);
		
		return c;
	}
}
