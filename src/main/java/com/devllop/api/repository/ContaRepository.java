package com.devllop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devllop.api.model.Conta;


public interface ContaRepository extends JpaRepository<Conta, Long>{

}
