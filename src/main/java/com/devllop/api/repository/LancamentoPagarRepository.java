package com.devllop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devllop.api.model.ParcelaPagar;
import com.devllop.api.repository.lancamentopagar.LancamentoPagarRepositoryQuery;

public interface LancamentoPagarRepository extends JpaRepository<ParcelaPagar, Long>, LancamentoPagarRepositoryQuery {

}
