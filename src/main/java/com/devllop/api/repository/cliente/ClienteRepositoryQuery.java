package com.devllop.api.repository.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devllop.api.model.Cliente;
import com.devllop.api.repository.filter.ClienteFilter;
import com.devllop.api.repository.projection.ResumoCliente;

public interface ClienteRepositoryQuery {

	public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
	public Page<ResumoCliente> resumir(ClienteFilter clienteFilter, Pageable pageable);
	
}
