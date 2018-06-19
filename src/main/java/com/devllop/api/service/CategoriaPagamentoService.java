package com.devllop.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.CategoriaPagamento;
import com.devllop.api.repository.CategoriaPagamentoRepository;

@Service
public class CategoriaPagamentoService {

	@Autowired
	private CategoriaPagamentoRepository categoriaRepository;
	
	public CategoriaPagamento atualizar(Long id, CategoriaPagamento categoria) {
		CategoriaPagamento categoriaSalva = categoriaRepository.findOne(id);
		if (categoriaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(categoria, categoriaSalva, "id");
		return categoriaRepository.save(categoriaSalva);
	}
}
