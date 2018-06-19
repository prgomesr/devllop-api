package com.devllop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devllop.api.model.ParcelaReceber;
import com.devllop.api.repository.lancamentoreceber.LancamentoReceberRepositoryQuery;

public interface LancamentoReceberRepository extends JpaRepository<ParcelaReceber, Long>, LancamentoReceberRepositoryQuery{

}
