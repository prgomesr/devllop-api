package com.devllop.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.Banco;
import com.devllop.api.repository.BancoRepository;

@Service
public class BancoService {

	@Autowired
	private BancoRepository bancoRepository;
	
	public Banco atualizar(Long id, Banco banco) {
		Banco bancoSalvo = buscarPorId(id);
		if (bancoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(banco, bancoSalvo, "id");
		return bancoRepository.save(bancoSalvo);
	}

	public Banco buscarPorId(Long id) {
		Optional<Banco> banco = bancoRepository.findById(id);
		if (!banco.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return banco.get();
	}
}
