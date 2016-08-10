package br.com.controle.aluguel.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.aluguel.model.Casa;
import br.com.controle.aluguel.model.Endereco;
import br.com.controle.aluguel.resource.to.CasaTO;
import br.com.controle.aluguel.service.CasaService;

@RestController
public class CasaResource {
	
	@Autowired
	private CasaService casaService;

	@RequestMapping("/casa")
	public ResponseEntity<Casa> saveCasa(@Valid @RequestBody CasaTO casaTO) {
		
		Casa casa = convert(casaTO);
		
		try {
			casa = casaService.saveCasa(casa);
		} catch (Exception e) {
			return new ResponseEntity<Casa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Casa>(casa, HttpStatus.OK);
	}
	
	public Casa convert(CasaTO casaTO) {
		
		Casa c = new Casa();
		c.setComodos(casaTO.getComodos());
		c.setObservacao(casaTO.getObservacao());
		
		Endereco e = new Endereco();
		e.setEnderecoId(casaTO.getEnderecoTO().getEnderecoId());
		e.setBairro(casaTO.getEnderecoTO().getBairro());
		e.setRua(casaTO.getEnderecoTO().getRua());
		e.setNumero(casaTO.getEnderecoTO().getNumero());
		
		c.setEndereco(e);
		
		return c;
	}
}
