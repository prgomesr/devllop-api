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
import com.devllop.api.model.Conta;
import com.devllop.api.repository.ContaRepository;
import com.devllop.api.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaResource {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping
	public List<Conta> listar() {
		return contaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Conta> criar(@Valid @RequestBody Conta conta, HttpServletResponse response ) {
		Conta contaSalva = contaService.salvar(conta);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, contaSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(contaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> buscarPeloId(@PathVariable Long id) {
		Conta conta  = contaService.buscarPorId(id);
		return conta != null ? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Conta> atualizar(@PathVariable Long id, @Valid @RequestBody Conta conta) {
		Conta contaSalva = contaService.atualizar(id, conta);
		return ResponseEntity.ok(contaSalva);
	}

}
