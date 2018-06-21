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
import com.devllop.api.model.ParcelaReceber;
import com.devllop.api.repository.LancamentoReceberRepository;
import com.devllop.api.repository.filter.LancamentoReceberFilter;
import com.devllop.api.repository.projection.ResumoLancamentoReceber;
import com.devllop.api.service.LancamentoReceberService;

@RestController
@RequestMapping("/lancamentosReceber")
public class LancamentoReceberResource {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private LancamentoReceberRepository repository;
	
	@Autowired
	private LancamentoReceberService service;
	
	@GetMapping
	public Page<ParcelaReceber> pesquisar(LancamentoReceberFilter filter, Pageable pageable) {
		return repository.filtrar(filter, pageable);
	}

	@GetMapping(params = "resumo")
	public Page<ResumoLancamentoReceber> resumir(LancamentoReceberFilter filter, Pageable pageable) {
		return repository.resumir(filter, pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ParcelaReceber> buscarPeloId(@PathVariable Long id) {
		ParcelaReceber lancamento  = service.buscarPorId(id);
		
		return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<ParcelaReceber> criar(@Valid @RequestBody ParcelaReceber lancamento, HttpServletResponse response ) {
		ParcelaReceber lancamentoSalvo = repository.save(lancamento);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ParcelaReceber> atualizar(@PathVariable Long id, @Valid @RequestBody ParcelaReceber lancamento) {
		ParcelaReceber lancamentoSalvo = service.atualizar(id, lancamento);
		return ResponseEntity.ok(lancamentoSalvo);
	}
	
	@PutMapping("/{id}/gerarBoletos")
	public ResponseEntity<ParcelaReceber> gerarBoleto(@PathVariable Long id, @Valid @RequestBody ParcelaReceber lancamento) {
		ParcelaReceber lancamentoSalvo = service.emitirBoleto(id, lancamento);
		return ResponseEntity.ok(lancamentoSalvo);
	}

}
