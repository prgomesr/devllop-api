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
import com.devllop.api.model.CategoriaRecebimento;
import com.devllop.api.repository.CategoriaRecebimentoRepository;
import com.devllop.api.service.CategoriaRecebimentoService;

@RestController
@RequestMapping("/categoriasRecebimentos")
public class CategoriaRecebimentoResource {
	
	@Autowired
	private CategoriaRecebimentoRepository repository;
	
	@Autowired
	private CategoriaRecebimentoService service;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<CategoriaRecebimento> listar() {
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<CategoriaRecebimento> criar(@Valid @RequestBody CategoriaRecebimento categoria, HttpServletResponse response ) {
		CategoriaRecebimento categoriaSalva = repository.save(categoria);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaRecebimento> buscarPeloId(@PathVariable Long id) {
		CategoriaRecebimento categoria  = service.buscarPorId(id);
		return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaRecebimento> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaRecebimento categoria) {
		CategoriaRecebimento categoriaSalva = service.atualizar(id, categoria);
		return ResponseEntity.ok(categoriaSalva);
	}

}
