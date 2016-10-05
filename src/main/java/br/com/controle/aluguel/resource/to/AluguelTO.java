package br.com.controle.aluguel.resource.to;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class AluguelTO {

	private Long aluguelId;
	
	@NotNull
	private Double valor;
	
	@NotNull
	@DateTimeFormat
	private Date dataInicio;
	
	@NotNull
	@DateTimeFormat
	private Date dataTermino;
	
	@NotNull
	private Integer diaPagamento;
	
	@Size(max=2000)
	private String observacao;
	
	@NotNull
	private List<PagamentoTO> pagamentos;
	
	@NotNull
	private CasaTO casa;
	
	@NotNull
	private List<PessoaTO> pessoas;

	public Long getAluguelId() {
		return aluguelId;
	}

	public void setAluguelId(Long aluguelId) {
		this.aluguelId = aluguelId;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Integer getDiaPagamento() {
		return diaPagamento;
	}

	public void setDiaPagamento(Integer diaPagamento) {
		this.diaPagamento = diaPagamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<PagamentoTO> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<PagamentoTO> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public CasaTO getCasa() {
		return casa;
	}

	public void setCasa(CasaTO casa) {
		this.casa = casa;
	}

	public List<PessoaTO> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<PessoaTO> pessoas) {
		this.pessoas = pessoas;
	}
	
	
}
