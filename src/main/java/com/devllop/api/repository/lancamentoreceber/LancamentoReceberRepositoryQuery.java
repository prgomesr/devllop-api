package com.devllop.api.repository.lancamentoreceber;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devllop.api.model.ParcelaReceber;
import com.devllop.api.repository.filter.LancamentoReceberFilter;
import com.devllop.api.repository.projection.ResumoLancamentoReceber;

public interface LancamentoReceberRepositoryQuery {

	public Page<ParcelaReceber> filtrar(LancamentoReceberFilter filter, Pageable pageable);
	public Page<ResumoLancamentoReceber> resumir(LancamentoReceberFilter filter, Pageable pageable);
	
}
