package com.devllop.api.repository.lancamentopagar;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devllop.api.model.ParcelaPagar;
import com.devllop.api.repository.filter.LancamentoPagarFilter;
import com.devllop.api.repository.projection.ResumoLancamentoPagar;

public interface LancamentoPagarRepositoryQuery {
	
	public Page<ParcelaPagar> filtrar(LancamentoPagarFilter filter, Pageable pageble );
	public Page<ResumoLancamentoPagar> resumir(LancamentoPagarFilter filter, Pageable pageble);
	
}
