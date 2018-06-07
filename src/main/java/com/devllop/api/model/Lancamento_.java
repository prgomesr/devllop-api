package com.devllop.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lancamento.class)
public abstract class Lancamento_ {

	public static volatile SingularAttribute<Lancamento, String> numDocumento;
	public static volatile SingularAttribute<Lancamento, String> tipo;
	public static volatile SingularAttribute<Lancamento, String> observacao;
	public static volatile SingularAttribute<Lancamento, String> situacao;
	public static volatile SingularAttribute<Lancamento, LocalDate> dataPagamento;
	public static volatile SingularAttribute<Lancamento, LocalDate> dataBalanco;
	public static volatile SingularAttribute<Lancamento, Categoria> categoria;
	public static volatile SingularAttribute<Lancamento, BigDecimal> valor;
	public static volatile SingularAttribute<Lancamento, Conta> conta;
	public static volatile SingularAttribute<Lancamento, Boolean> contaFixa;
	public static volatile SingularAttribute<Lancamento, BigDecimal> valorJuros;
	public static volatile SingularAttribute<Lancamento, String> descricao;
	public static volatile SingularAttribute<Lancamento, BigDecimal> valorRecebido;
	public static volatile SingularAttribute<Lancamento, Cliente> cliente;
	public static volatile SingularAttribute<Lancamento, TipoLancamento> tipoLancamento;
	public static volatile SingularAttribute<Lancamento, LocalDate> dataVencimento;
	public static volatile SingularAttribute<Lancamento, String> nossoNumero;
	public static volatile SingularAttribute<Lancamento, String> numNf;
	public static volatile SingularAttribute<Lancamento, BigDecimal> valorMulta;
	public static volatile SingularAttribute<Lancamento, Long> id;
	public static volatile SingularAttribute<Lancamento, Fornecedor> fornecedor;

}

