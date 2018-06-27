package com.devllop.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.Convenio;
import com.devllop.api.repository.ConvenioRepository;

@Service
public class ConvenioService {

	@Autowired
	private ConvenioRepository repository;
	
	public Convenio atualizar(Long id, Convenio convenio) {
		Convenio convenioSalvo = buscarPorId(id);
		if (convenioSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(convenio, convenioSalvo, "id");
		return repository.save(convenioSalvo);
	}

	public Convenio buscarPorId(Long id) {
		Optional<Convenio> optional = repository.findById(id);
		if (!optional.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return optional.get();
	}
	
}
