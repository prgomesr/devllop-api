package com.devllop.api.repository.lancamentopagar;

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

import com.devllop.api.model.Cliente_;
import com.devllop.api.model.Fornecedor_;
import com.devllop.api.model.ParcelaPagar;
import com.devllop.api.model.ParcelaPagar_;
import com.devllop.api.model.ParcelaPagar;
import com.devllop.api.model.ParcelaPagar_;
import com.devllop.api.repository.filter.LancamentoPagarFilter;
import com.devllop.api.repository.projection.ResumoLancamentoPagar;

public class LancamentoPagarRepositoryImpl implements LancamentoPagarRepositoryQuery{
    
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ParcelaPagar> filtrar(LancamentoPagarFilter filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ParcelaPagar> criteria = builder.createQuery(ParcelaPagar.class);
		Root<ParcelaPagar> root = criteria.from(ParcelaPagar.class);
		
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ParcelaPagar> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(filter));
	}

	@Override
	public Page<ResumoLancamentoPagar> resumir(LancamentoPagarFilter filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoLancamentoPagar> criteria = builder.createQuery(ResumoLancamentoPagar.class);
		Root<ParcelaPagar> root = criteria.from(ParcelaPagar.class);
		
		criteria.select(builder.construct(ResumoLancamentoPagar.class
				, root.get(ParcelaPagar_.id), root.get(ParcelaPagar_.fornecedor).get(Fornecedor_.razaoSocial)
				, root.get(ParcelaPagar_.descricao), root.get(ParcelaPagar_.valor)
				, root.get(ParcelaPagar_.dataEmissao), root.get(ParcelaPagar_.dataVencimento)
				, root.get(ParcelaPagar_.situacao)));
		
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoLancamentoPagar> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(filter));
	}
	
	
	private Predicate[] criarRestricoes(LancamentoPagarFilter lancamentoFilter, CriteriaBuilder builder,
			Root<ParcelaPagar> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(lancamentoFilter.getDescricao())) {
			predicates.add(builder.like(
					builder.lower(root.get(ParcelaPagar_.descricao)), "%" + lancamentoFilter.getDescricao().toLowerCase() + "%"));
		}
		
		if (lancamentoFilter.getDataVencimentoDe() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get(ParcelaPagar_.dataVencimento), lancamentoFilter.getDataVencimentoDe()));
		}
		
		if (lancamentoFilter.getDataVencimentoAte() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get(ParcelaPagar_.dataVencimento), lancamentoFilter.getDataVencimentoAte()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(LancamentoPagarFilter lancamentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ParcelaPagar> root = criteria.from(ParcelaPagar.class);
		
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}
