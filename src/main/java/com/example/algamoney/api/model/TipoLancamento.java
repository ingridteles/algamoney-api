package com.example.algamoney.api.model;

public enum TipoLancamento {

	RECEITA(1, "Receita"),
	DESPESA(2, "Despesa");
	
	private int cod;
	private String nome;
	
	private TipoLancamento(int cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
	}

	

	public static TipoLancamento toNome(String nome) {
		if (nome == null) {
			return null;
		}

		for (TipoLancamento dominio : TipoLancamento.values()) {
			if (nome.equalsIgnoreCase(dominio.nome)) {
				return dominio;
			}
		}

		throw new IllegalArgumentException("Nome do domínio inválido: " + nome);
	}

	public static TipoLancamento toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoLancamento dominio : TipoLancamento.values()) {
			if (cod.equals(dominio.cod)) {
				return dominio;
			}
		}

		throw new IllegalArgumentException("Código do Tipo de Lançamento inválido: " + cod);
	}
}