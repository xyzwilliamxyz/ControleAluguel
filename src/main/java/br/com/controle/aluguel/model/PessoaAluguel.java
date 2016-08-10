package br.com.controle.aluguel.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="pessoa_aluguel")
public class PessoaAluguel implements Serializable {

	private static final long serialVersionUID = -5487983339799700294L;
	
	private Integer tipo;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "aluguel_id")
	private Aluguel aluguel;

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
}
