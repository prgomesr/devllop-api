package com.devllop.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="lancamento")
public class Lancamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max=25)
	private String tipo;
	
	@NotNull
	@Size(max=100)
	private String descricao;
	
	@NotNull
	private BigDecimal valor;
	
	@Column(name="valor_recebido")
	private BigDecimal valorRecebido;
	
	@NotNull
	@Column(name="data_vencimento")
	private LocalDate dataVencimento;
	
	@Column(name="data_pagamento")
	private LocalDate dataPagamento;
	
	@Column(name="data_balanco")
	private LocalDate dataBalanco;
	
	@Size(max=255)
	private String observacao;
	
	@NotNull
	@Column(name="conta_fixa")
	private Boolean contaFixa;
	
	@Size(max=45)
	@Column(name="num_documento")
	private String numDocumento;
	
	@Size(max=45)
	@Column(name="num_nf")
	private String numNf;
	
	@Size(max=45)
	@Column(name="nosso_numero")
	private String nossoNumero;
	
	@Column(name="valor_juros")
	private BigDecimal valorJuros;
	
	@Column(name="valor_multa")
	private BigDecimal valorMulta;
	
	@NotNull
	@Size(max=25)
	private String situacao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="conta_id")
	private Conta conta;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="tipo_lancamento_id")
	private TipoLancamento tipoLancamento;
	
	@ManyToOne
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
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

	public LocalDate getDataBalanco() {
		return dataBalanco;
	}

	public void setDataBalanco(LocalDate dataBalanco) {
		this.dataBalanco = dataBalanco;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getContaFixa() {
		return contaFixa;
	}

	public void setContaFixa(Boolean contaFixa) {
		this.contaFixa = contaFixa;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getNumNf() {
		return numNf;
	}

	public void setNumNf(String numNf) {
		this.numNf = numNf;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public BigDecimal getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(BigDecimal valorJuros) {
		this.valorJuros = valorJuros;
	}

	public BigDecimal getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(BigDecimal valorMulta) {
		this.valorMulta = valorMulta;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
