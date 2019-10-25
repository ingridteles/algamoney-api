package com.example.algamoney.api.model.dto;

import javax.validation.constraints.NotNull;

import com.example.algamoney.api.model.Endereco;

public class PessoaDTO {

	private Long codigo;

	@NotNull
	private String nome;
	
	private Endereco endereco;

	@NotNull
	private Boolean ativo;

	@NotNull
	private Integer tipoAcesso;
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(Integer tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}
}