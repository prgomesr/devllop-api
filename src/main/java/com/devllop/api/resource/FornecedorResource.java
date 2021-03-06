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
import com.devllop.api.model.Fornecedor;
import com.devllop.api.repository.FornecedorRepository;
import com.devllop.api.repository.filter.FornecedorFilter;
import com.devllop.api.repository.projection.ResumoFornecedor;
import com.devllop.api.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorResource {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping
	public Page<Fornecedor> pesquisar(FornecedorFilter fornecedorFilter, Pageable pageable) {
		return fornecedorRepository.filtrar(fornecedorFilter, pageable);
	}
	
	@GetMapping(params = "resumo")
	public Page<ResumoFornecedor> resumir(FornecedorFilter fornecedorFilter, Pageable pageable) {
		return fornecedorRepository.resumir(fornecedorFilter, pageable);
	}
	
	@PostMapping
	public ResponseEntity<Fornecedor> criar(@Valid @RequestBody Fornecedor fornecedor, HttpServletResponse response ) {
		Fornecedor fornecedorSalvo = fornecedorRepository.save(fornecedor);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, fornecedorSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> buscarPeloId(@PathVariable Long id) {
		Fornecedor fornecedor  = fornecedorService.buscarPorId(id);
		return fornecedor != null ? ResponseEntity.ok(fornecedor) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id, @Valid @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorSalvo = fornecedorService.atualizar(id, fornecedor);
		return ResponseEntity.ok(fornecedorSalvo);
	}
	
	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean ativo) {
		fornecedorService.atualizarPropriedadeAtivo(id, ativo);
	}
	
}
