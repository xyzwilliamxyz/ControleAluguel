package br.com.controle.aluguel.enums;

public enum TipoPessoa {

	LOCADOR(1, "Locador"),
	LOCATARIO(2, "Locatário"),
	FIADOR(3, "Fiador"),
	FILHO(4, "Filho");
	
	private int id;
	private String descricao;
	
	private TipoPessoa(int id, String descricao) {
		
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
