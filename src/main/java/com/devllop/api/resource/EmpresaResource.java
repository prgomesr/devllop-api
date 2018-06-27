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
import com.devllop.api.model.Empresa;
import com.devllop.api.repository.EmpresaRepository;
import com.devllop.api.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaResource {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	public List<Empresa> listar() {
		return empresaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Empresa> criar(@Valid @RequestBody Empresa empresa, HttpServletResponse response ) {
		Empresa empresaSalva = empresaRepository.save(empresa);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, empresaSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> buscarPeloId(@PathVariable Long id) {
		Empresa empresa  = empresaService.buscarPorId(id);
		return empresa != null ? ResponseEntity.ok(empresa) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @Valid @RequestBody Empresa empresa) {
		Empresa empresaSalva = empresaService.atualizar(id, empresa);
		return ResponseEntity.ok(empresaSalva);
	}
	
}
