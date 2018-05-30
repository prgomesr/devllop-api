package com.devllop.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.Empresa;
import com.devllop.api.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	public Empresa atualizar(Long id, Empresa empresa) {
		Empresa empresaSalva = repository.findOne(id);
		if (empresaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(empresa, empresaSalva, "id");
		return repository.save(empresaSalva);
	}
	
}
