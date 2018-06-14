package com.devllop.api.repository.fornecedor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devllop.api.model.Fornecedor;
import com.devllop.api.repository.filter.FornecedorFilter;
import com.devllop.api.repository.projection.ResumoFornecedor;

public interface FornecedorRepositoryQuery {
	
	public Page<Fornecedor> filtrar(FornecedorFilter fornecedorFilter, Pageable pageable);
	public Page<ResumoFornecedor> resumir(FornecedorFilter fornecedorFilter, Pageable pageable);
	
}
