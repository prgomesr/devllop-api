package com.devllop.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ParcelaPagar.class)
public abstract class ParcelaPagar_ {

	public static volatile SingularAttribute<ParcelaPagar, String> numDocumento;
	public static volatile SingularAttribute<ParcelaPagar, String> situacao;
	public static volatile SingularAttribute<ParcelaPagar, LocalDate> dataVencimento;
	public static volatile SingularAttribute<ParcelaPagar, CategoriaPagamento> categoria;
	public static volatile SingularAttribute<ParcelaPagar, BigDecimal> valor;
	public static volatile SingularAttribute<ParcelaPagar, Conta> conta;
	public static volatile SingularAttribute<ParcelaPagar, String> numNf;
	public static volatile SingularAttribute<ParcelaPagar, Long> id;
	public static volatile SingularAttribute<ParcelaPagar, Fornecedor> fornecedor;
	public static volatile SingularAttribute<ParcelaPagar, LocalDate> dataEmissao;
	public static volatile SingularAttribute<ParcelaPagar, String> descricao;

}

