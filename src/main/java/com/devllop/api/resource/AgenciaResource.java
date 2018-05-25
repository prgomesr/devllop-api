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
import com.devllop.api.model.Agencia;
import com.devllop.api.model.Empresa;
import com.devllop.api.repository.AgenciaRepository;

@RestController
@RequestMapping("/agencias")
public class AgenciaResource {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@GetMapping
	public List<Agencia> listar() {
		return agenciaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Agencia> criar(@Valid @RequestBody Agencia agencia, HttpServletResponse response ) {
		Agencia agenciaSalva = agenciaRepository.save(agencia);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, agenciaSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(agenciaSalva);
	}
}
