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
import com.devllop.api.model.TipoLancamento;
import com.devllop.api.repository.TipoLancamentoRepository;
import com.devllop.api.service.TipoLancamentoService;


@RestController
@RequestMapping("/tiposLancamentos")
public class TipoLancamentoResource {
	
	@Autowired
	private TipoLancamentoRepository tipoLancamentoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private TipoLancamentoService tipoLancamentoService;
	
	@GetMapping
	public List<TipoLancamento> listar() {
		return tipoLancamentoRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<TipoLancamento> criar(@Valid @RequestBody TipoLancamento tipo, HttpServletResponse response ) {
		TipoLancamento tipoSalvo = tipoLancamentoRepository.save(tipo);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoLancamento> buscarPeloId(@PathVariable Long id) {
		TipoLancamento tipo  = tipoLancamentoRepository.findOne(id);
		return tipo != null ? ResponseEntity.ok(tipo) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoLancamento> atualizar(@PathVariable Long id, @Valid @RequestBody TipoLancamento tipo) {
		TipoLancamento tipoSalvo = tipoLancamentoService.atualizar(id, tipo);
		return ResponseEntity.ok(tipoSalvo);
	}
		
	
}
