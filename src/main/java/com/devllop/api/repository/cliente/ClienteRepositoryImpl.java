package com.devllop.api.repository.cliente;

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

import com.devllop.api.model.Cliente;
import com.devllop.api.model.Cliente_;
import com.devllop.api.repository.filter.ClienteFilter;
import com.devllop.api.repository.projection.ResumoCliente;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
		Root<Cliente> root = criteria.from(Cliente.class);

		// criar restricoes
		Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Cliente> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacaoQuery(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(clienteFilter));
	}

	@Override
	public Page<ResumoCliente> resumir(ClienteFilter clienteFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoCliente> criteria = builder.createQuery(ResumoCliente.class);
		Root<Cliente> root = criteria.from(Cliente.class);

		criteria.select(builder.construct(ResumoCliente.class, root.get(Cliente_.id), root.get(Cliente_.nome),
				root.get(Cliente_.cpf), root.get(Cliente_.telefonePrincipal), root.get(Cliente_.email),
				root.get(Cliente_.situacao), root.get(Cliente_.ativo)));

		// criar restricoes
		Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<ResumoCliente> query = manager.createQuery(criteria);

		adicionarRestricoesPaginacaoQuery(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(clienteFilter));
	}

	private Predicate[] criarRestricoes(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(clienteFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get(Cliente_.nome)),
					"%" + clienteFilter.getNome().toLowerCase() + "%"));
		}
		if (!StringUtils.isEmpty(clienteFilter.getCpf())) {
			predicates.add(builder.like(builder.lower(root.get(Cliente_.cpf)),
					"%" + clienteFilter.getCpf().toLowerCase() + "%"));
		}
		if (!StringUtils.isEmpty(clienteFilter.getSexo())) {
			predicates.add(builder.like(builder.lower(root.get(Cliente_.sexo)),
					"%" + clienteFilter.getSexo().toLowerCase() + "%"));
		}
		if (!StringUtils.isEmpty(clienteFilter.getSituacao())) {
			predicates.add(builder.like(builder.lower(root.get(Cliente_.situacao)),
					"%" + clienteFilter.getSituacao().toLowerCase() + "%"));
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

	private Long total(ClienteFilter clienteFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Cliente> root = criteria.from(Cliente.class);

		Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
