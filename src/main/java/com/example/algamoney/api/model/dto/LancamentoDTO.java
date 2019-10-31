package com.example.algamoney.api.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.algamoney.api.model.Lancamento;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LancamentoDTO {

	private Long codigo;

	private String descricao;

	
	@JsonFormat(pattern = "dd/MM/yyyy")
	//@Temporal(TemporalType.DATE)
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private LocalDate dataVencimento;

	@JsonFormat(pattern = "dd/MM/yyyy")
	//@Temporal(TemporalType.DATE)
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private LocalDate dataPagamento;
	
	private BigDecimal valor;

	private String observacao;

	private Integer tipo;

	private Integer situacao;

	private Long categoriaId;

	private Long pessoaId;

	public LancamentoDTO(Lancamento obj) {
		codigo = obj.getCodigo();
		descricao = obj.getDescricao();
		dataVencimento = obj.getDataVencimento();
		dataPagamento = obj.getDataPagamento();
		valor = obj.getValor();
		observacao = obj.getObservacao();
		tipo = obj.getTipo().getCod();
		situacao = obj.getSituacao().getCod();
		categoriaId = obj.getCategoria() != null ? obj.getCategoria().getCodigo() : null;
		pessoaId = obj.getPessoa() != null ? obj.getPessoa().getCodigo() : null;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

}
