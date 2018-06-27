package com.devllop.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.CategoriaRecebimento;
import com.devllop.api.repository.CategoriaRecebimentoRepository;

@Service
public class CategoriaRecebimentoService {

	@Autowired
	private CategoriaRecebimentoRepository repository;

	public CategoriaRecebimento atualizar(Long id, CategoriaRecebimento categoria) {
		CategoriaRecebimento categoriaSalva = buscarPorId(id);
		if (categoriaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(categoria, categoriaSalva, "id");
		return repository.save(categoriaSalva);
	}

	public CategoriaRecebimento buscarPorId(Long id) {
		Optional<CategoriaRecebimento> recebimento = repository.findById(id);
		if (!recebimento.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return recebimento.get();
	}
}
