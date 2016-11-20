package br.com.controle.aluguel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.aluguel.enums.TipoPessoa;
import br.com.controle.aluguel.exception.CustomException;
import br.com.controle.aluguel.model.Aluguel;
import br.com.controle.aluguel.model.Casa;
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
		
		if (aluguel.getDataInicio().getTime() >= aluguel.getDataTermino().getTime()) {
			throw new CustomException("Data de término é menor ou igual a data de início");
		}
		
		if (aluguel.getAluguelId() != null) {
			
			Aluguel aluguelOld = aluguelRepository.findOne(aluguel.getAluguelId());
			
			if (aluguel.getDataInicio().getTime() != aluguelOld.getDataInicio().getTime()) {
				throw new CustomException("A data de início do aluguel não pode ser alterada");
			}
			
			if (aluguel.getDataTermino().getTime() < aluguelOld.getDataTermino().getTime()) {
				throw new CustomException("A data de término do aluguel não pode ser alterada para uma data de término menor do que a anterior");
			}
			
			
			
//			List<PessoaAluguel> pessoaAluguelsNew = new ArrayList<>();
//			boolean found = false;
//			for (PessoaAluguel pa : aluguel.getPessoaAluguels()) {
//				found = false;
//				for (PessoaAluguel paOld : aluguelOld.getPessoaAluguels()) {
//					
//					if (pa.getPessoa().getPessoaId() == paOld.getPessoa().getPessoaId()) {
//						paOld.setAluguel(aluguel);
//						pessoaAluguelsNew.add(paOld);
//						found = true;
//						break;
//					}
//				}
//				if (!found) {
//					pa.setAluguel(aluguel);
//					pessoaAluguelsNew.add(pa);
//				}
//			}
//			aluguel.setPessoaAluguels(pessoaAluguelsNew);
//			PessoaAluguel pa = aluguel.getPessoaAluguels().get(1);
//			pa.setPessoa(pessoaRepository.findOne(pa.getPessoa().getPessoaId()));
//			pa.setAluguel(aluguelOld);
//			pa.getPessoa().getPessoaAluguels().add(pa);
			//aluguelOld.getPessoaAluguels().add(pa);
			
			PessoaAluguel pa2 = new PessoaAluguel();
			pa2.setPessoa(pessoaRepository.findOne(2L));
			pa2.setAluguel(aluguelOld);
			pa2.getPessoa().getPessoaAluguels().add(pa2);
			aluguelOld.getPessoaAluguels().add(pa2);
			
			
			aluguelRepository.save(aluguelOld);
			if (1 == 1) return null;
		}
		
		
		
		boolean hasLocador = false;
		boolean hasLocatario = false;
		for (PessoaAluguel pa : aluguel.getPessoaAluguels()) {
			
			if (pa.getTipo() == TipoPessoa.LOCADOR.getId()) {
				hasLocador = true;
			}
			
			if (pa.getTipo() == TipoPessoa.LOCATARIO.getId()) {
				hasLocatario = true;
			}
		}
		
		if (!hasLocador) {
			throw new CustomException("Aluguel deve possuir pelo menos um locador");
		}
		
		if (!hasLocatario) {
			throw new CustomException("Aluguel deve possuir pelo menos um locatário");
		}
		
		Casa casa = casaRepository.findOne(aluguel.getCasa().getCasaId());
		
		if (casa == null) {
			throw new CustomException("Casa não encontrada");
		}
		
//		for (PessoaAluguel p : aluguel.getPessoaAluguels()) {
//			Pessoa pFetched = pessoaRepository.findOne(p.getPessoa().getPessoaId());
//			
//			if (pFetched == null) {
//				throw new CustomException("Pessoa " + p.getPessoa().getNome() + " não encontrada");
//			}
//			
//			p.setPessoa(pFetched);
//		}
		
		
		
		aluguel.setCasa(casa);
		
		Aluguel a = aluguelRepository.save(aluguel);
		
		return a;
	}
	
	public Aluguel getAluguelByID(Long aluguelId) throws CustomException {
		
		if (aluguelId == null || aluguelId == 0L) {
			throw new CustomException("Aluguel não encontrada.");
		}
		
		return aluguelRepository.findOne(aluguelId);
	}
	
	public List<Aluguel> getAluguels() {
		
		List<Aluguel> aluguels = aluguelRepository.findAll();
		
		return aluguels;
	}
}
