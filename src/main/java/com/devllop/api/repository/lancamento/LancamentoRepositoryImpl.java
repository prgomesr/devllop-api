package com.devllop.api.repository.lancamento;

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
import com.devllop.api.model.Lancamento;
import com.devllop.api.model.Lancamento_;
import com.devllop.api.repository.filter.LancamentoFilter;
import com.devllop.api.repository.projection.ResumoLancamento;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);
		
		//criar restricoes
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Lancamento> query = manager.createQuery(criteria);
		
		adicionarRestricoesPaginacaoQuery(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
	}
	
	@Override
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoLancamento> criteria = builder.createQuery(ResumoLancamento.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);
		if (!StringUtils.isEmpty(root.get(Lancamento_.fornecedor).get(Fornecedor_.razaoSocial))) {
			System.out.println("entrou");
			criteria.select(builder.construct(ResumoLancamento.class, 
					root.get(Lancamento_.id), 
					root.get(Lancamento_.cliente).get(Cliente_.nome),
					root.get(Lancamento_.fornecedor).get(Fornecedor_.razaoSocial),
					root.get(Lancamento_.descricao), 
					root.get(Lancamento_.valor), 
					root.get(Lancamento_.dataVencimento),
					root.get(Lancamento_.dataPagamento), 
					root.get(Lancamento_.situacao), 
					root.get(Lancamento_.tipo)));
		}
		
		
		//criar restricoes
				Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
				criteria.where(predicates);
				
				TypedQuery<ResumoLancamento> query = manager.createQuery(criteria);
				
				adicionarRestricoesPaginacaoQuery(query, pageable);
				
		return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
	}

	private Predicate[] criarRestricoes(LancamentoFilter lancamentoFilter, CriteriaBuilder builder,
			Root<Lancamento> root) {
		List<Predicate> predicates = new ArrayList<>();
		if (!StringUtils.isEmpty(lancamentoFilter.getDescricao())) {
			predicates.add(builder.like(builder
					.lower(root.get(Lancamento_.descricao)), "%" + lancamentoFilter.getDescricao().toLowerCase() + "%"));
		} if (!StringUtils.isEmpty(lancamentoFilter.getDataVencimentoDe())) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(Lancamento_.dataVencimento), lancamentoFilter.getDataVencimentoDe()));
		} if (!StringUtils.isEmpty(lancamentoFilter.getDataVencimentoAte())) {
			predicates.add(builder.lessThanOrEqualTo(root.get(Lancamento_.dataVencimento), lancamentoFilter.getDataVencimentoAte()));
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
	
	private Long total(LancamentoFilter lancamentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);
		
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
