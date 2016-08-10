package br.com.controle.aluguel.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.aluguel.model.Casa;
import br.com.controle.aluguel.model.Endereco;
import br.com.controle.aluguel.service.CasaService;

@RestController
public class CasaResource {
	
	@Autowired
	private CasaService casaService;

	@RequestMapping("/casa")
	public ResponseEntity<Casa> saveCasa() {
		
		Casa c = new Casa();
		c.setComodos("2 quartos, 1 cozinha");
		c.setObservacao("reformar");
		
		Endereco e = new Endereco();
		e.setRua("Rua do povo");
		e.setNumero("46B");
		e.setBairro("Nova");
		c.setEndereco(e);
		
		Casa cSaved = casaService.saveCasa(c);
		
		return new ResponseEntity<Casa>(cSaved, HttpStatus.OK);
	}
}
