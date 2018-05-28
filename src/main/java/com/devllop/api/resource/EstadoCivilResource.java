package com.devllop.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devllop.api.model.EstadoCivil;
import com.devllop.api.repository.EstadoCivilRepository;

@RestController
@RequestMapping("/estadosCivis")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EstadoCivilResource {

	@Autowired
	private EstadoCivilRepository repository;
	
	@GetMapping
	public List<EstadoCivil> listar() {
		return repository.findAll();
	}

}
