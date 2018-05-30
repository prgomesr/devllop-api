package com.devllop.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.Cliente;
import com.devllop.api.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente atualizar(Long id, Cliente cliente) {
		Cliente clienteSalvo = findObjectByID(id);
		BeanUtils.copyProperties(cliente, clienteSalvo, "id");
		return clienteRepository.save(clienteSalvo);
	}


	public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
		Cliente clienteSalvo = findObjectByID(id);
		clienteSalvo.setAtivo(ativo);
		clienteRepository.save(clienteSalvo);
	}
	
	private Cliente findObjectByID(Long id) {
		Cliente clienteSalvo = clienteRepository.findOne(id);
		if (clienteSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return clienteSalvo;
	}

}
