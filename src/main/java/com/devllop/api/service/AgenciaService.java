package com.devllop.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.Agencia;
import com.devllop.api.repository.AgenciaRepository;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	public Agencia atualizar(Long id, Agencia agencia) {
		Agencia agenciaSalva = buscarPorId(id);
		if (agenciaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(agencia, agenciaSalva, "id");
		return agenciaRepository.save(agenciaSalva);
	}

	public Agencia buscarPorId(Long id) {
		Optional<Agencia> optional = agenciaRepository.findById(id);
		if (!optional.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return optional.get();
	}

}
