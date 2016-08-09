package br.com.controle.aluguel.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pessoaId;
	
	private String nome;
	private String rg;
	private String cpf;
	private String observacao;
	
	public Integer getPessoaId() {
		return pessoaId;
	}


	public void setPessoaId(Integer pessoaId) {
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

	private static final long serialVersionUID = 1L;
}
