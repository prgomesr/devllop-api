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
import com.devllop.api.model.Convenio;
import com.devllop.api.repository.ConvenioRepository;
import com.devllop.api.service.ConvenioService;

@RestController
@RequestMapping("/convenios")
public class ConvenioResource {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ConvenioRepository convenioRepository;
	
	@Autowired
	private ConvenioService convenioService;
	
	@GetMapping
	public List<Convenio> listar() {
		return convenioRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Convenio> criar(@Valid @RequestBody Convenio banco, HttpServletResponse response ) {
		Convenio convenioSalvo = convenioRepository.save(banco);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, convenioSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(convenioSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Convenio> buscarPeloId(@PathVariable Long id) {
		Convenio banco  = convenioRepository.findOne(id);
		return banco != null ? ResponseEntity.ok(banco) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Convenio> atualizar(@PathVariable Long id, @Valid @RequestBody Convenio banco) {
		Convenio convenioSalvo = convenioService.atualizar(id, banco);
		return ResponseEntity.ok(convenioSalvo);
	}
}
