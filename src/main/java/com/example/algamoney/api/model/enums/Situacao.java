package com.example.algamoney.api.model.enums;

public enum Situacao {
    RASCUNHO(1, "Rascunho", "Rascunho de um sequencial."),
    SOLICITADO(2, "Solicitado", "Sequencial solicitado."),
    APROVADO(3, "Aprovado", "Sequencial aprovado."),
    CONTESTADO(4, "Contestado", "Sequencial contestado."),
    REJEITADO(5, "Rejeitado", "Sequencial rejeitado."),
    EXCLUIDO(6, "Excluido", "Sequencial excluido.");

    private int cod;
    private String nome;
    private String descricao;

    private Situacao(int cod, String nome, String descricao) {
        this.cod = cod;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Situacao toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (Situacao tipo : Situacao.values()) {
            if (cod.equals(tipo.cod)) {
                return tipo;
            }
        }

        throw new IllegalArgumentException("Código da situação inválido: " + cod);
    }
}