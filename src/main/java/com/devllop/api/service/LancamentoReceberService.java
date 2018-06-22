package com.devllop.api.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.Empresa;
import com.devllop.api.model.ParcelaReceber;
import com.devllop.api.repository.EmpresaRepository;
import com.devllop.api.repository.LancamentoReceberRepository;
import com.devllop.api.util.boleto.EmissorBoleto;

@Service
public class LancamentoReceberService {
	
	@Autowired
	private LancamentoReceberRepository repository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
//	@Autowired
//	private EmissorBoleto emissorBoleto;
	
	public ParcelaReceber atualizar(Long id, ParcelaReceber lancamento) {
		ParcelaReceber lancamentoSalvo = repository.findOne(id);
		if (lancamentoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");
		return repository.save(lancamentoSalvo);
	}
	
	public ParcelaReceber buscarPorId(Long id) {
		ParcelaReceber lancamento = repository.findOne(id);
		return lancamento;
	}

//	public ParcelaReceber emitirBoleto(Long id, ParcelaReceber lancamento) {
//		ParcelaReceber lancamentoSalvo = repository.findOne(id);
//		Empresa empresa = empresaRepository.findOne(1L); 
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
