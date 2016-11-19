package br.com.controle.aluguel.resource.to;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EnderecoTO {

	private Long enderecoId;
	
	@NotNull
	@Size(max=200)
	private String rua;
	
	@NotNull
	@Size(max=20)
	private String numero;
	
	@NotNull
	@Size(max=200)
	private String bairro;
	
	public Long getEnderecoId() {
		return enderecoId;
	}
	public void setEnderecoId(Long enderecoId) {
		this.enderecoId = enderecoId;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}
