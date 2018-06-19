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
import com.devllop.api.model.CategoriaReceber;
import com.devllop.api.repository.CategoriaRepository;
import com.devllop.api.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<CategoriaReceber> listar() {
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<CategoriaReceber> criar(@Valid @RequestBody CategoriaReceber banco, HttpServletResponse response ) {
		CategoriaReceber categoriaSalva = categoriaRepository.save(banco);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaReceber> buscarPeloId(@PathVariable Long id) {
		CategoriaReceber banco  = categoriaRepository.findOne(id);
		return banco != null ? ResponseEntity.ok(banco) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaReceber> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaReceber banco) {
		CategoriaReceber categoriaSalva = categoriaService.atualizar(id, banco);
		return ResponseEntity.ok(categoriaSalva);
	}
	
}
