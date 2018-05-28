package com.devllop.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devllop.api.event.RecursoCriadoEvent;
import com.devllop.api.model.Cliente;
import com.devllop.api.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente, HttpServletResponse response ) {
		Cliente clienteSalvo = clienteRepository.save(cliente);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, clienteSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
	}
}
