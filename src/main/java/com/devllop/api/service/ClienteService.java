package com.devllop.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devllop.api.model.Cliente;
import com.devllop.api.model.Endereco;
import com.devllop.api.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente atualizar(Long id, Cliente cliente) {
		Cliente clienteSalvo = buscarPorId(id);
		BeanUtils.copyProperties(cliente, clienteSalvo, "id");
		return clienteRepository.save(clienteSalvo);
	}


	public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
		Cliente clienteSalvo = buscarPorId(id);
		clienteSalvo.setAtivo(ativo);
		clienteRepository.save(clienteSalvo);
	}
	

	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.get().getEndereco() == null) {
			cliente.get().setEndereco(new Endereco());
//			evita que o cep seja preenchido ao clicar para editar um cadastro com
//			 cep preenchido e depois em outro com cep vazio
			cliente.get().getEndereco().setCep("");
		}
		if (!cliente.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return cliente.get();
	}

}
