package com.devllop.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.TipoLancamento;
import com.devllop.api.repository.TipoLancamentoRepository;

@Service
public class TipoLancamentoService {

	
	@Autowired
	private TipoLancamentoRepository tipoLancamentoRepository;
	
	public TipoLancamento atualizar(Long id, TipoLancamento tipo) {
		TipoLancamento tipoSalvo = buscarPorId(id);
		if (tipoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(tipo, tipoSalvo, "id");
		return tipoLancamentoRepository.save(tipoSalvo);
	}

	public TipoLancamento buscarPorId(Long id) {
		Optional<TipoLancamento> optional = tipoLancamentoRepository.findById(id);
		if (!optional.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return optional.get();
	}
		
}
