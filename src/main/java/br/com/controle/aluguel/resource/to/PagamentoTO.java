package br.com.controle.aluguel.resource.to;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PagamentoTO {
	
	private Long pagamentoId;
	
	@NotNull
	private Double valor;
	
	private Double valorPago;
	
	@NotNull
	private Date dataPagamento;
	
	private Date dataPagamentoRealizado;
	
	private Double contaAgua;
	
	private Double contaEnergia;
	
	@Size(max=2000)
	private String observacao;
	
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
}
