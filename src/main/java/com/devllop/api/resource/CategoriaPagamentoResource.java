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
import com.devllop.api.model.CategoriaPagamento;
import com.devllop.api.repository.CategoriaPagamentoRepository;
import com.devllop.api.service.CategoriaPagamentoService;

@RestController
@RequestMapping("/categoriasPagamentos")
public class CategoriaPagamentoResource {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private CategoriaPagamentoRepository categoriaRepository;
	
	@Autowired
	private CategoriaPagamentoService categoriaService;
	
	@GetMapping
	public List<CategoriaPagamento> listar() {
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<CategoriaPagamento> criar(@Valid @RequestBody CategoriaPagamento categoria, HttpServletResponse response ) {
		CategoriaPagamento categoriaSalva = categoriaRepository.save(categoria);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaPagamento> buscarPeloId(@PathVariable Long id) {
		CategoriaPagamento categoria  = categoriaService.buscarPorId(id);
		return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaPagamento> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaPagamento categoria) {
		CategoriaPagamento categoriaSalva = categoriaService.atualizar(id, categoria);
		return ResponseEntity.ok(categoriaSalva);
	}
	
}
