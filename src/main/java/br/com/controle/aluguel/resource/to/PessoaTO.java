package br.com.controle.aluguel.resource.to;

import javax.validation.constraints.Size;

public class PessoaTO {

	private Long pessoaId;
	
	@Size(max=200)
	private String nome;

	@Size(max=20)
	private String rg;
	
	@Size(max=20)
	private String cpf;
	
	@Size(max=2000)
	private String observacao;
	
	private Integer tipo;
	
	public Long getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
}
