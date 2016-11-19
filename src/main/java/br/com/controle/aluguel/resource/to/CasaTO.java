package br.com.controle.aluguel.resource.to;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CasaTO {
	
	private Long casaId;
	
	@Size(max=200)
	@NotNull
	private String comodos;
	
	@Size(max=2000)
	private String observacao;
	
	@NotNull
	@Valid
	@JsonProperty("endereco")
	private EnderecoTO enderecoTO;

	public Long getCasaId() {
		return casaId;
	}

	public void setCasaId(Long casaId) {
		this.casaId = casaId;
	}

	public String getComodos() {
		return comodos;
	}

	public void setComodos(String comodos) {
		this.comodos = comodos;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public EnderecoTO getEnderecoTO() {
		return enderecoTO;
	}

	public void setEnderecoTO(EnderecoTO enderecoTO) {
		this.enderecoTO = enderecoTO;
	}
	
	
}
