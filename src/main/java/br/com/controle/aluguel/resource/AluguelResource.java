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

import br.com.controle.aluguel.exception.CustomException;
import br.com.controle.aluguel.model.Aluguel;
import br.com.controle.aluguel.model.Casa;
import br.com.controle.aluguel.model.Pagamento;
import br.com.controle.aluguel.model.Pessoa;
import br.com.controle.aluguel.model.PessoaAluguel;
import br.com.controle.aluguel.resource.to.AluguelTO;
import br.com.controle.aluguel.resource.to.CasaTO;
import br.com.controle.aluguel.resource.to.PagamentoTO;
import br.com.controle.aluguel.resource.to.PessoaTO;
import br.com.controle.aluguel.service.AluguelService;

@RestController
public class AluguelResource {
	
	@Autowired
	private AluguelService aluguelService;

	@RequestMapping(value = "/aluguel", method = RequestMethod.POST)
	public ResponseEntity<AluguelTO> saveAluguel(@Valid @RequestBody AluguelTO aluguelTO) throws CustomException {
		
		Aluguel aluguel = convert(aluguelTO);
		aluguelTO = convert(aluguelService.saveAluguel(aluguel));
		
		return new ResponseEntity<AluguelTO>(aluguelTO, HttpStatus.OK);
	}
	
	@RequestMapping("/aluguel")
	public ResponseEntity<List<AluguelTO>> getAluguels() throws Exception {
		
		List<Aluguel> aluguels = aluguelService.getAluguels();
		List<AluguelTO> aluguelTOs = convert(aluguels);
		
		return new ResponseEntity<List<AluguelTO>>(aluguelTOs, HttpStatus.OK);
	}
	
	public List<AluguelTO> convert(List<Aluguel> aluguels) {
		
		List<AluguelTO> aluguelTOs = new ArrayList<>();
		
		for (Aluguel a : aluguels) {
			aluguelTOs.add(convert(a));
		}
		
		return aluguelTOs;
	}
	
	public static AluguelTO convert(Aluguel aluguel) {
		
		AluguelTO aluguelTO = new AluguelTO();
		aluguelTO.setAluguelId(aluguel.getAluguelId());
		aluguelTO.setValor(aluguel.getValor());
		aluguelTO.setDiaPagamento(aluguel.getDiaPagamento());
		aluguelTO.setDataInicio(aluguel.getDataInicio());
		aluguelTO.setDataTermino(aluguel.getDataTermino());
		aluguelTO.setObservacao(aluguel.getObservacao());
		
		if (aluguel.getPagamentos() != null) {
			List<PagamentoTO> pagamentoTOs = new ArrayList<>();
			
			for (Pagamento p : aluguel.getPagamentos()) {
				PagamentoTO pTO = PagamentoResource.convert(p);
				pagamentoTOs.add(pTO);
			}
			
			aluguelTO.setPagamentos(pagamentoTOs);
		}
		
		if (aluguel.getPessoaAluguels() != null) {
			
			List<PessoaTO> pessoaTOs = new ArrayList<>();
			for (PessoaAluguel p : aluguel.getPessoaAluguels()) {
				PessoaTO pTO = PessoaResource.convert(p.getPessoa());
				pTO.setTipo(p.getTipo());
				pessoaTOs.add(pTO);
			}
			aluguelTO.setPessoas(pessoaTOs);
		}
		
		CasaTO cTO = CasaResource.convert(aluguel.getCasa());
		aluguelTO.setCasa(cTO);
		
		return aluguelTO;
	}
	
	public static Aluguel convert(AluguelTO aluguelTO) {
		
		Aluguel a = new Aluguel();
		a.setAluguelId(aluguelTO.getAluguelId());
		a.setValor(aluguelTO.getValor());
		a.setDiaPagamento(aluguelTO.getDiaPagamento());
		a.setDataInicio(aluguelTO.getDataInicio());
		a.setDataTermino(aluguelTO.getDataTermino());
		a.setObservacao(aluguelTO.getObservacao());
		
		if (aluguelTO.getPagamentos() != null) {
			List<Pagamento> pagamentos = new ArrayList<>();
			
			for (PagamentoTO pTO : aluguelTO.getPagamentos()) {
				Pagamento p = PagamentoResource.convert(pTO);
				p.setAluguel(a);
				pagamentos.add(p);
			}
			
			a.setPagamentos(pagamentos);
		}
		
		if (aluguelTO.getPessoas() != null) {
			
			List<PessoaAluguel> pessoaAluguels = new ArrayList<>();
			for (PessoaTO pTO : aluguelTO.getPessoas()) {
				Pessoa p = PessoaResource.convert(pTO);
				PessoaAluguel pa = new PessoaAluguel();
				pa.setAluguel(a);
				pa.setPessoa(p);
				pa.setTipo(pTO.getTipo());
				pessoaAluguels.add(pa);
			}
			a.setPessoaAluguels(pessoaAluguels);
		}
		
		Casa c = CasaResource.convert(aluguelTO.getCasa());
		a.setCasa(c);
		
		return a;
	}
	

}
