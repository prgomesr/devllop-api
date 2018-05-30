package com.devllop.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devllop.api.event.RecursoCriadoEvent;
import com.devllop.api.model.Agencia;
import com.devllop.api.repository.AgenciaRepository;
import com.devllop.api.service.AgenciaService;

@RestController
@RequestMapping("/agencias")
public class AgenciaResource {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@Autowired
	private AgenciaService agenciaService;
	
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Agencia> buscarPeloId(@PathVariable Long id) {
		Agencia agencia  = agenciaRepository.findOne(id);
		return agencia != null ? ResponseEntity.ok(agencia) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Agencia> atualizar(@PathVariable Long id, @Valid @RequestBody Agencia agencia) {
		Agencia agenciaSalva = agenciaService.atualizar(id, agencia);
		return ResponseEntity.ok(agenciaSalva);
	}
	
}
