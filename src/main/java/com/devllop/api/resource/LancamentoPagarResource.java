package com.devllop.api.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.devllop.api.model.ParcelaPagar;
import com.devllop.api.repository.LancamentoPagarRepository;
import com.devllop.api.repository.filter.LancamentoPagarFilter;
import com.devllop.api.repository.projection.ResumoLancamentoPagar;
import com.devllop.api.service.LancamentoPagarService;

@RestController
@RequestMapping("/lancamentosPagar")
public class LancamentoPagarResource {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private LancamentoPagarRepository repository;
	
	@Autowired
	private LancamentoPagarService service;
	
	@GetMapping
	public Page<ParcelaPagar> pesquisar(LancamentoPagarFilter filter, Pageable pageable) {
		return repository.filtrar(filter, pageable);
	}

	@GetMapping(params = "resumo")
	public Page<ResumoLancamentoPagar> resumir(LancamentoPagarFilter filter, Pageable pageable) {
		return repository.resumir(filter, pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ParcelaPagar> buscarPeloId(@PathVariable Long id) {
		ParcelaPagar lancamento  = service.buscarPorId(id);
		
		return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<ParcelaPagar> criar(@Valid @RequestBody ParcelaPagar lancamento, HttpServletResponse response ) {
		ParcelaPagar lancamentoSalvo = repository.save(lancamento);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ParcelaPagar> atualizar(@PathVariable Long id, @Valid @RequestBody ParcelaPagar lancamento) {
		ParcelaPagar lancamentoSalvo = service.atualizar(id, lancamento);
		return ResponseEntity.ok(lancamentoSalvo);
	}

		
	
}
