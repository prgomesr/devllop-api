package com.devllop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devllop.api.model.Fornecedor;
import com.devllop.api.repository.fornecedor.FornecedorRepositoryQuery;

public interface FornecedorRepository  extends JpaRepository<Fornecedor, Long>, FornecedorRepositoryQuery {
	

}
