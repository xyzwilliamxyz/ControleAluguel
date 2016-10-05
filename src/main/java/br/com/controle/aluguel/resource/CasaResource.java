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
import br.com.controle.aluguel.model.Casa;
import br.com.controle.aluguel.model.Endereco;
import br.com.controle.aluguel.resource.to.CasaTO;
import br.com.controle.aluguel.resource.to.EnderecoTO;
import br.com.controle.aluguel.service.CasaService;

@RestController
public class CasaResource {
	
	@Autowired
	private CasaService casaService;

	@RequestMapping(value = "/casa", method = RequestMethod.POST)
	public ResponseEntity<CasaTO> saveCasa(@Valid @RequestBody CasaTO casaTO) throws CustomException {
		
		Casa casa = convert(casaTO);
		
		casaTO = convert(casaService.saveCasa(casa));
		
		return new ResponseEntity<CasaTO>(casaTO, HttpStatus.OK);
	}
	
	@RequestMapping("/casa")
	public ResponseEntity<List<CasaTO>> getCasas() throws Exception {
		
		List<Casa> casas = casaService.getCasas();
		List<CasaTO> casaTOs = convert(casas); 
		
		return new ResponseEntity<List<CasaTO>>(casaTOs, HttpStatus.OK);
	}
	
	public List<CasaTO> convert(List<Casa> casas) {
		
		List<CasaTO> casaTOs = new ArrayList<>();
		
		for (Casa c : casas) {
			casaTOs.add(convert(c));
		}
		
		return casaTOs;
	}
	
	public static CasaTO convert(Casa casa) {
		
		CasaTO casaTO = new CasaTO();
		casaTO.setCasaId(casa.getCasaId());
		casaTO.setComodos(casa.getComodos());
		casaTO.setObservacao(casa.getObservacao());
		
		EnderecoTO enderecoTO = EnderecoResource.convert(casa.getEndereco());
		
		casaTO.setEnderecoTO(enderecoTO);
		
		return casaTO;
	}
	
	public static Casa convert(CasaTO casaTO) {
		
		Casa c = new Casa();
		c.setCasaId(casaTO.getCasaId());
		c.setComodos(casaTO.getComodos());
		c.setObservacao(casaTO.getObservacao());
		
		Endereco e = EnderecoResource.convert(casaTO.getEnderecoTO());
		
		c.setEndereco(e);
		
		return c;
	}
}
