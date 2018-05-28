package com.devllop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devllop.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
