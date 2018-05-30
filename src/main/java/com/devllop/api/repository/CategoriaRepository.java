package com.devllop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devllop.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
