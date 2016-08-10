package br.com.controle.aluguel.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="casa")
public class Casa implements Serializable {
	
	private static final long serialVersionUID = -6159939792668478122L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="casa_id")
	private Long casaId;
	
	private String comodos;
	private String observacao;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
