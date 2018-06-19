package com.devllop.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.Endereco;
import com.devllop.api.model.Fornecedor;
import com.devllop.api.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public Fornecedor atualizar(Long id, Fornecedor fornecedor) {
		Fornecedor fornecedorSalvo = fornecedorRepository.findOne(id);
		if (fornecedorSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(fornecedor, fornecedorSalvo, "id");
		return fornecedorRepository.save(fornecedorSalvo);
	}

	public Fornecedor buscarPorId(Long id) {
		Fornecedor fornecedor = fornecedorRepository.findOne(id);
		if (fornecedor.getEndereco() == null) {
			fornecedor.setEndereco(new Endereco());
		}
		return fornecedor;
	}
}
