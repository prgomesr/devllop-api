package com.devllop.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.ParcelaReceber;
import com.devllop.api.repository.LancamentoReceberRepository;

@Service
public class LancamentoReceberService {
	
	@Autowired
	private LancamentoReceberRepository repository;
	
	public ParcelaReceber atualizar(Long id, ParcelaReceber lancamento) {
		ParcelaReceber lancamentoSalvo = repository.findOne(id);
		if (lancamentoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");
		return repository.save(lancamentoSalvo);
	}
	
	public ParcelaReceber buscarPorId(Long id) {
		ParcelaReceber lancamento = repository.findOne(id);
		return lancamento;
	}
}
