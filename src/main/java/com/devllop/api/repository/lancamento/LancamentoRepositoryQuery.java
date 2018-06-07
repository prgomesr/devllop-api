package com.devllop.api.repository.lancamento;

import java.util.List;

import com.devllop.api.model.Lancamento;
import com.devllop.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
	
}

