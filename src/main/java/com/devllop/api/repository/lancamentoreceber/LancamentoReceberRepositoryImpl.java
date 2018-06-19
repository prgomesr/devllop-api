package com.devllop.api.repository.lancamentoreceber;

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
import com.devllop.api.model.ParcelaReceber;
import com.devllop.api.model.ParcelaReceber_;
import com.devllop.api.repository.filter.LancamentoReceberFilter;
import com.devllop.api.repository.projection.ResumoLancamentoReceber;

public class LancamentoReceberRepositoryImpl implements LancamentoReceberRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ParcelaReceber> filtrar(LancamentoReceberFilter filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ParcelaReceber> criteria = builder.createQuery(ParcelaReceber.class);
		Root<ParcelaReceber> root = criteria.from(ParcelaReceber.class);
		
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ParcelaReceber> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(filter));
	}

	@Override
	public Page<ResumoLancamentoReceber> resumir(LancamentoReceberFilter filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoLancamentoReceber> criteria = builder.createQuery(ResumoLancamentoReceber.class);
		Root<ParcelaReceber> root = criteria.from(ParcelaReceber.class);
		
		criteria.select(builder.construct(ResumoLancamentoReceber.class
				, root.get(ParcelaReceber_.id), root.get(ParcelaReceber_.cliente).get(Cliente_.nome)
				, root.get(ParcelaReceber_.descricao), root.get(ParcelaReceber_.valor)
				, root.get(ParcelaReceber_.dataEmissao), root.get(ParcelaReceber_.dataVencimento)
				, root.get(ParcelaReceber_.situacao)));
		
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoLancamentoReceber> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(filter));
	}
	
	private Predicate[] criarRestricoes(LancamentoReceberFilter lancamentoFilter, CriteriaBuilder builder,
			Root<ParcelaReceber> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(lancamentoFilter.getDescricao())) {
			predicates.add(builder.like(
					builder.lower(root.get(ParcelaReceber_.descricao)), "%" + lancamentoFilter.getDescricao().toLowerCase() + "%"));
		}
		
		if (lancamentoFilter.getDataVencimentoDe() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get(ParcelaReceber_.dataVencimento), lancamentoFilter.getDataVencimentoDe()));
		}
		
		if (lancamentoFilter.getDataVencimentoAte() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get(ParcelaReceber_.dataVencimento), lancamentoFilter.getDataVencimentoAte()));
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
	
	private Long total(LancamentoReceberFilter lancamentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ParcelaReceber> root = criteria.from(ParcelaReceber.class);
		
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}
