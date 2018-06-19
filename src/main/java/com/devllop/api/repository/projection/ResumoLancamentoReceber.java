package com.devllop.api.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoLancamentoReceber {
	private Long id;
	private String cliente;
	private String descricao;
	private BigDecimal valor;
	private LocalDate dataEmissao;
	private LocalDate dataVencimento;
	private String situacao;
	
	public ResumoLancamentoReceber(Long id, String cliente, String descricao, BigDecimal valor, LocalDate dataEmissao,
			LocalDate dataVencimento, String situacao) {
		super();
		this.id = id;
		this.cliente = cliente;
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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
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
