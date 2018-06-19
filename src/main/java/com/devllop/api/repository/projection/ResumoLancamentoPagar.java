package com.devllop.api.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoLancamentoPagar {
	
	private Long id;
	private String fornecedor;
	private String descricao;
	private BigDecimal valor;
	private LocalDate dataEmissao;
	private LocalDate dataVencimento;
	private String situacao;
	
	public ResumoLancamentoPagar(Long id, String fornecedor, String descricao, BigDecimal valor, LocalDate dataEmissao,
			LocalDate dataVencimento, String situacao) {
		super();
		this.id = id;
		this.fornecedor = fornecedor;
		this.descricao = descricao;
		this.valor = valor;
		this.dataEmissao = dataEmissao;
		this.dataVencimento = dataVencimento;
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
}
