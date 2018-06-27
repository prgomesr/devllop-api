package com.devllop.api.service;

import java.util.Optional;

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
		CategoriaPagamento categoriaSalva = buscarPorId(id);
		if (categoriaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(categoria, categoriaSalva, "id");
		return categoriaRepository.save(categoriaSalva);
	}

	public CategoriaPagamento buscarPorId(Long id) {
		Optional<CategoriaPagamento> categoria = categoriaRepository.findById(id);
		if (!categoria.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoria.get();
	}
}
