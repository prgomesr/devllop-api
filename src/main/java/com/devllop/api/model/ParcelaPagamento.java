package com.devllop.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="parcela_pagamento")
public class ParcelaPagamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	@NotNull
	private LocalDate dataPagamento;
	
	@NotNull
	private BigDecimal valorPago;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="parcela_pagar_id")
	private ParcelaPagar parcelaPagar;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="conta_id")
	private Conta contaId;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="tipo_lancamento_id")
	private TipoLancamento tipoLancamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public ParcelaPagar getParcelaPagar() {
		return parcelaPagar;
	}

	public void setParcelaPagar(ParcelaPagar parcelaPagar) {
		this.parcelaPagar = parcelaPagar;
	}

	public Conta getContaId() {
		return contaId;
	}

	public void setContaId(Conta contaId) {
		this.contaId = contaId;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
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
		ParcelaPagamento other = (ParcelaPagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}
