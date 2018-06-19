package com.devllop.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.CategoriaReceber;
import com.devllop.api.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public CategoriaReceber atualizar(Long id, CategoriaReceber banco) {
		CategoriaReceber categoriaSalva = categoriaRepository.findOne(id);
		if (categoriaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(banco, categoriaSalva, "id");
		return categoriaRepository.save(categoriaSalva);
	}
}
