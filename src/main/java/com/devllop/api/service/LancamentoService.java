package com.devllop.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.Lancamento;
import com.devllop.api.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Lancamento atualizar(Long id, Lancamento lancamento) {
		Lancamento lancamentoSalvo = lancamentoRepository.findOne(id);
		if (lancamentoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");
		return lancamentoRepository.save(lancamentoSalvo);
	}
	
}
