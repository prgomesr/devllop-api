package com.devllop.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.Conta;
import com.devllop.api.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public Conta atualizar(Long id, Conta conta) {
		Conta contaSalva = contaRepository.findOne(id);
		if (contaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		atualizarSaldo(conta);
		BeanUtils.copyProperties(conta, contaSalva, "id");
		return contaRepository.save(contaSalva);
	}

	public Conta salvar(Conta conta) {
		if (conta.getCarteira() == true) {
			conta.setAgencia(null);
		}
		atualizarSaldo(conta);
		return contaRepository.save(conta);
	}
	
	private void atualizarSaldo(Conta conta) {
		conta.setSaldoAtual(conta.getSaldoInicial());
	}
}
