package com.devllop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devllop.api.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
