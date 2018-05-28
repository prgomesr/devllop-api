package com.devllop.api.service;

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
		Banco bancoSalvo = bancoRepository.findOne(id);
		if (bancoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(banco, bancoSalvo, "id");
		return bancoRepository.save(bancoSalvo);
	}
}
