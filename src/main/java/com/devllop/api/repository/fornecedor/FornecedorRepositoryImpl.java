package com.devllop.api.repository.fornecedor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.devllop.api.model.Fornecedor;
import com.devllop.api.model.Fornecedor_;
import com.devllop.api.repository.filter.FornecedorFilter;
import com.devllop.api.repository.projection.ResumoFornecedor;

public class FornecedorRepositoryImpl implements FornecedorRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Fornecedor> filtrar(FornecedorFilter fornecedorFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Fornecedor> criteria = builder.createQuery(Fornecedor.class);
		Root<Fornecedor> root = criteria.from(Fornecedor.class);
		
		//criar restricoes
		Predicate[] predicates = criarRestricoes(fornecedorFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Fornecedor> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacaoQuery(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(fornecedorFilter));
	}
	
	@Override
	public Page<ResumoFornecedor> resumir(FornecedorFilter fornecedorFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoFornecedor> criteria = builder.createQuery(ResumoFornecedor.class);
		Root<Fornecedor> root = criteria.from(Fornecedor.class);

		criteria.select(builder.construct(ResumoFornecedor.class, root.get(Fornecedor_.id), root.get(Fornecedor_.razaoSocial),
				root.get(Fornecedor_.fantasia), root.get(Fornecedor_.cnpj), root.get(Fornecedor_.telefonePrincipal),
				root.get(Fornecedor_.email)));

		// criar restricoes
		Predicate[] predicates = criarRestricoes(fornecedorFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<ResumoFornecedor> query = manager.createQuery(criteria);

		adicionarRestricoesPaginacaoQuery(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(fornecedorFilter));
	}

	private Predicate[] criarRestricoes(FornecedorFilter fornecedorFilter, CriteriaBuilder builder,
			Root<Fornecedor> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(fornecedorFilter.getCnpj())) {
			predicates.add(builder
					.like(builder.lower(root.get(Fornecedor_.cnpj)), "%" + 
			fornecedorFilter.getCnpj().toLowerCase() + "%"));
		}
		if (!StringUtils.isEmpty(fornecedorFilter.getFantasia())) {
			predicates.add(builder
					.like(builder.lower(root.get(Fornecedor_.fantasia)), "%" + 
			fornecedorFilter.getFantasia().toLowerCase() + "%"));
		}
		if (!StringUtils.isEmpty(fornecedorFilter.getRazaoSocial())) {
			predicates.add(builder
					.like(builder.lower(root.get(Fornecedor_.razaoSocial)), "%" + 
			fornecedorFilter.getRazaoSocial().toLowerCase() + "%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesPaginacaoQuery(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(FornecedorFilter fornecedorFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Fornecedor> root = criteria.from(Fornecedor.class);
		
		Predicate[] predicates = criarRestricoes(fornecedorFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
