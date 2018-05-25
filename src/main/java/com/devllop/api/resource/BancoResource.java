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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devllop.api.event.RecursoCriadoEvent;
import com.devllop.api.model.Banco;
import com.devllop.api.repository.BancoRepository;

@RestController
@RequestMapping("/bancos")
public class BancoResource {
	
	@Autowired
	private BancoRepository bancoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Banco> listar() {
		return bancoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Banco> criar(@Valid @RequestBody Banco banco, HttpServletResponse response ) {
		Banco bancoSalvo = bancoRepository.save(banco);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, bancoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bancoSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Banco> buscarPeloId(@PathVariable Long id) {
		Banco banco  = bancoRepository.findOne(id);
		return banco != null ? ResponseEntity.ok(banco) : ResponseEntity.notFound().build();
	}

}
