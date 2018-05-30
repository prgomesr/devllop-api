package com.devllop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devllop.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
