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

@Entity
@Table(name="lancamento_receber")
public class LancamentoReceber {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="valor_total")
	private BigDecimal valorTotal;
	
	@NotNull
	@Column(name="valor_a_receber")
	private BigDecimal valorAReceber;
	
	@Column(name="num_documento")
	private String numDocumento;
	
	@NotNull
	@Column(name="data_lancamento")
	private LocalDate dataLancamento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="categoria_receber_id")
	private CategoriaReceber categoriaReceber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorAReceber() {
		return valorAReceber;
	}

	public void setValorAReceber(BigDecimal valorAReceber) {
		this.valorAReceber = valorAReceber;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public CategoriaReceber getCategoriaReceber() {
		return categoriaReceber;
	}

	public void setCategoriaReceber(CategoriaReceber categoriaReceber) {
		this.categoriaReceber = categoriaReceber;
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
		LancamentoReceber other = (LancamentoReceber) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
