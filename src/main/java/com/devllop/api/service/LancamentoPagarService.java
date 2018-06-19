package com.devllop.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.ParcelaPagar;
import com.devllop.api.repository.LancamentoPagarRepository;

@Service
public class LancamentoPagarService {
	@Autowired
	private LancamentoPagarRepository repository;
	
	public ParcelaPagar atualizar(Long id, ParcelaPagar lancamento) {
		ParcelaPagar lancamentoSalvo = repository.findOne(id);
		if (lancamentoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");
		return repository.save(lancamentoSalvo);
	}
	
	public ParcelaPagar buscarPorId(Long id) {
		ParcelaPagar lancamento = repository.findOne(id);
		return lancamento;
	}

}
