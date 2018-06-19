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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devllop.api.event.RecursoCriadoEvent;
import com.devllop.api.model.Cliente;
import com.devllop.api.repository.ClienteRepository;
import com.devllop.api.repository.filter.ClienteFilter;
import com.devllop.api.repository.projection.ResumoCliente;
import com.devllop.api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public Page<Cliente> pesquisar(ClienteFilter clienteFilter, Pageable pageable) {
		return clienteRepository.filtrar(clienteFilter, pageable);
	}

	@GetMapping(params = "resumo")
	public Page<ResumoCliente> resumir(ClienteFilter clienteFilter, Pageable pageable) {
		return clienteRepository.resumir(clienteFilter, pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPeloId(@PathVariable Long id) {
		Cliente cliente  = clienteService.buscarPorId(id);
		
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente, HttpServletResponse response ) {
		Cliente clienteSalvo = clienteRepository.save(cliente);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, clienteSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(clienteSalvo);
	}
	
	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean ativo) {
		clienteService.atualizarPropriedadeAtivo(id, ativo);
	}
	
}
