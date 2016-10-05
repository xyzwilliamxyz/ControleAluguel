package br.com.controle.aluguel.resource;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.aluguel.model.Pagamento;
import br.com.controle.aluguel.resource.to.PagamentoTO;
import br.com.controle.aluguel.service.PagamentoService;

@RestController
public class PagamentoResource {
	
	@Autowired
	private PagamentoService pagamentoService;

	@RequestMapping(value = "/pagamento", method = RequestMethod.POST)
	public ResponseEntity<PagamentoTO> savePagamento(@Valid @RequestBody PagamentoTO pagamentoTO) {
		
		Pagamento pagamento = convert(pagamentoTO);
		
		pagamentoTO = convert(pagamentoService.savePagamento(pagamento));
		
		return new ResponseEntity<PagamentoTO>(pagamentoTO, HttpStatus.OK);
	}
	
	@RequestMapping("/pagamento")
	public ResponseEntity<List<PagamentoTO>> getPagamento() throws Exception {
		
		List<Pagamento> pagamentos = pagamentoService.getPagamentos();
		List<PagamentoTO> pagamentoTOs = convert(pagamentos);
		
		return new ResponseEntity<List<PagamentoTO>>(pagamentoTOs, HttpStatus.OK);
	}
	
	public List<PagamentoTO> convert(List<Pagamento> pagamentos) {
		
		List<PagamentoTO> pagamentoTOs = new ArrayList<>();
		
		for (Pagamento p : pagamentos) {
			pagamentoTOs.add(convert(p));
		}
		
		return pagamentoTOs;
	}
	
	public static PagamentoTO convert(Pagamento pagamento) {
		
		PagamentoTO pagamentoTO = new PagamentoTO();
		pagamentoTO.setPagamentoId(pagamento.getPagamentoId());
		pagamentoTO.setValor(pagamento.getValor());
		pagamentoTO.setValorPago(pagamento.getValorPago());
		pagamentoTO.setDataPagamento(pagamento.getDataPagamento());
		pagamentoTO.setDataPagamentoRealizado(pagamento.getDataPagamentoRealizado());
		pagamentoTO.setContaAgua(pagamento.getContaAgua());
		pagamentoTO.setContaEnergia(pagamento.getContaEnergia());
		pagamentoTO.setObservacao(pagamento.getObservacao());
		
		return pagamentoTO;
	}
	
	public static Pagamento convert(PagamentoTO pagamentoTO) {
		
		Pagamento p = new Pagamento();
		p.setPagamentoId(pagamentoTO.getPagamentoId());
		p.setValor(pagamentoTO.getValor());
		p.setValorPago(pagamentoTO.getValorPago());
		p.setDataPagamento(pagamentoTO.getDataPagamento());
		p.setDataPagamentoRealizado(pagamentoTO.getDataPagamentoRealizado());
		p.setContaAgua(pagamentoTO.getContaAgua());
		p.setContaEnergia(pagamentoTO.getContaEnergia());
		p.setObservacao(pagamentoTO.getObservacao());
		
		return p;
	}
	

}
