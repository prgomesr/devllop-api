package com.devllop.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.ParcelaReceber;
import com.devllop.api.repository.LancamentoReceberRepository;

@Service
public class LancamentoReceberService {
	
	@Autowired
	private LancamentoReceberRepository repository;
	
	public ParcelaReceber atualizar(Long id, ParcelaReceber lancamento) {
		ParcelaReceber lancamentoSalvo = buscarPorId(id);
		if (lancamentoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");
		return repository.save(lancamentoSalvo);
	}
	
	public ParcelaReceber buscarPorId(Long id) {
		Optional<ParcelaReceber> lancamento = repository.findById(id);
		if (!lancamento.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return lancamento.get();
	}

//	public ParcelaReceber emitirBoleto(Long id, ParcelaReceber lancamento) {
//		ParcelaReceber lancamentoSalvo = repository.getOne(id);
//		Empresa empresa = empresaRepository.getOne(1L); 
//		if (lancamentoSalvo == null) {
//			throw new EmptyResultDataAccessException(1);
//		}
//		if (empresa == null) {
//			throw new EmptyResultDataAccessException(1);
//		}
//		byte [] pdf = emissorBoleto.gerarBoleto(empresa, lancamentoSalvo);
//		enviarBoleto(pdf);
//		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");
//		return repository.save(lancamentoSalvo);
//	}
//
//	private void enviarBoleto(byte[] pdf) {
//		HttpServletResponse response;
//		
//	}

}
