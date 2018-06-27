package com.devllop.api.service;

import java.util.Optional;

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
		Fornecedor fornecedorSalvo = buscarPorId(id);
		if (fornecedorSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(fornecedor, fornecedorSalvo, "id");
		return fornecedorRepository.save(fornecedorSalvo);
	}

	public Fornecedor buscarPorId(Long id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		if (fornecedor.get().getEndereco() == null) {
			fornecedor.get().setEndereco(new Endereco());
			// evita que o cep seja preenchido ao clicar para editar um cadastro com
			// cep preenchido e depois em outro com cep vazio
			fornecedor.get().getEndereco().setCep("");
		}
		return fornecedor.get();
	}

	public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
		Fornecedor fornecedorSalvo = buscarPorId(id);
		fornecedorSalvo.setAtivo(ativo);
		fornecedorRepository.save(fornecedorSalvo);
	}
	
}
