package br.com.controle.aluguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.aluguel.model.Pagamento;
import br.com.controle.aluguel.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public Pagamento savePagamento(Pagamento pagamento) {
		
		Pagamento p = pagamentoRepository.save(pagamento);
		
		return p;
	}
	
	public List<Pagamento> getPagamentos() {
		
		List<Pagamento> enderecos = pagamentoRepository.findAll();
		
		return enderecos;
	}
}
