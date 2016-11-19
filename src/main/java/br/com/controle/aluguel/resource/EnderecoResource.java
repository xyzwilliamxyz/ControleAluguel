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

import br.com.controle.aluguel.model.Endereco;
import br.com.controle.aluguel.resource.to.EnderecoTO;
import br.com.controle.aluguel.service.EnderecoService;

@RestController
@RequestMapping("/api")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService enderecoService;

	@RequestMapping(value = "/endereco", method = RequestMethod.PUT)
	public ResponseEntity<EnderecoTO> saveEndereco(@Valid @RequestBody EnderecoTO enderecoTO) {
		
		Endereco endereco = convert(enderecoTO);
		
		enderecoTO = convert(enderecoService.saveEndereco(endereco));
		
		return new ResponseEntity<EnderecoTO>(enderecoTO, HttpStatus.OK);
	}
	
	@RequestMapping("/endereco")
	public ResponseEntity<List<EnderecoTO>> getEnderecos() throws Exception {
		
		List<Endereco> enderecos = enderecoService.getEnderecos();
		List<EnderecoTO> enderecoTOs = convert(enderecos);
		
		return new ResponseEntity<List<EnderecoTO>>(enderecoTOs, HttpStatus.OK);
	}
	
	public List<EnderecoTO> convert(List<Endereco> enderecos) {
		
		List<EnderecoTO> enderecoTOs = new ArrayList<>();
		
		for (Endereco e : enderecos) {
			enderecoTOs.add(convert(e));
		}
		
		return enderecoTOs;
	}
	
	public static Endereco convert(EnderecoTO enderecoTO) {
		
		Endereco e = new Endereco();
		e.setEnderecoId(enderecoTO.getEnderecoId());
		e.setBairro(enderecoTO.getBairro());
		e.setRua(enderecoTO.getRua());
		e.setNumero(enderecoTO.getNumero());
		
		return e;
	}
	
	public static EnderecoTO convert(Endereco endereco) {
		
		EnderecoTO enderecoTO = new EnderecoTO();
		enderecoTO.setEnderecoId(endereco.getEnderecoId());
		enderecoTO.setBairro(endereco.getBairro());
		enderecoTO.setRua(endereco.getRua());
		enderecoTO.setNumero(endereco.getNumero());
		
		return enderecoTO;
	}
}
