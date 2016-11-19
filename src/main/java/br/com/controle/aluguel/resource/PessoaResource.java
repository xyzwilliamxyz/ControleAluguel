package br.com.controle.aluguel.resource;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.aluguel.exception.CustomException;
import br.com.controle.aluguel.model.Pessoa;
import br.com.controle.aluguel.resource.to.PessoaTO;
import br.com.controle.aluguel.service.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping("/pessoa/{pessoaId}")
	public ResponseEntity<PessoaTO> getPessoaByID(@PathVariable("pessoaId") Long pessoaId) throws CustomException {
		
		PessoaTO pessoaTO = convert(pessoaService.getPessoaByID(pessoaId));
		
		return new ResponseEntity<PessoaTO>(pessoaTO, HttpStatus.OK);
	}
	
	@RequestMapping("/pessoa")
	public ResponseEntity<List<PessoaTO>> getPessoas() {
		
		List<Pessoa> pessoas = pessoaService.getPessoas();
		List<PessoaTO> pessoaTOs = convert(pessoas);
		
		return new ResponseEntity<List<PessoaTO>>(pessoaTOs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pessoa", method = RequestMethod.PUT)
	public ResponseEntity<PessoaTO> savePessoa(@Valid @RequestBody PessoaTO pessoaTO) {
		
		Pessoa pessoa = convert(pessoaTO);
		
		pessoaTO = convert(pessoaService.savePessoa(pessoa));
			
		return new ResponseEntity<PessoaTO>(pessoaTO, HttpStatus.OK);
	}
	
	public List<PessoaTO> convert(List<Pessoa> pessoas) {
		
		List<PessoaTO> pessoaTOs = new ArrayList<>();
		
		for (Pessoa e : pessoas) {
			pessoaTOs.add(convert(e));
		}
		
		return pessoaTOs;
	}
	
	public static PessoaTO convert(Pessoa pessoa) {
		
		PessoaTO pessoaTO = new PessoaTO();
		pessoaTO.setPessoaId(pessoa.getPessoaId());
		pessoaTO.setNome(pessoa.getNome());
		pessoaTO.setRg(pessoa.getRg());
		pessoaTO.setCpf(pessoa.getCpf());
		pessoaTO.setObservacao(pessoa.getObservacao());
		
		return pessoaTO;
	}
	
	public static Pessoa convert(PessoaTO pessoaTO) {
		
		Pessoa p = new Pessoa();
		p.setPessoaId(pessoaTO.getPessoaId());
		p.setNome(pessoaTO.getNome());
		p.setRg(pessoaTO.getRg());
		p.setCpf(pessoaTO.getCpf());
		p.setObservacao(pessoaTO.getObservacao());
		
		return p;
	}
}
