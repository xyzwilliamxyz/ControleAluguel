package br.com.controle.aluguel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pagamento")
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 2621128432845062143L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pagamento_id")
	private Long pagamentoId;
	
	private Double valor;
	
	@Column(name="valor_pago")
	private Double valorPago;
	
	@Column(name="data_pagamento")
	private Date dataPagamento;
	
	@Column(name="data_pagamento_realizado")
	private Date dataPagamentoRealizado;
	
	@Column(name="conta_agua")
	private Double contaAgua;
	
	@Column(name="conta_energia")
	private Double contaEnergia;
	
	private String observacao;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="aluguel_id")
	private Aluguel aluguel;

	public Long getPagamentoId() {
		return pagamentoId;
	}

	public void setPagamentoId(Long pagamentoId) {
		this.pagamentoId = pagamentoId;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataPagamentoRealizado() {
		return dataPagamentoRealizado;
	}

	public void setDataPagamentoRealizado(Date dataPagamentoRealizado) {
		this.dataPagamentoRealizado = dataPagamentoRealizado;
	}

	public Double getContaAgua() {
		return contaAgua;
	}

	public void setContaAgua(Double contaAgua) {
		this.contaAgua = contaAgua;
	}

	public Double getContaEnergia() {
		return contaEnergia;
	}

	public void setContaEnergia(Double contaEnergia) {
		this.contaEnergia = contaEnergia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
}
