package com.devllop.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ParcelaPagar.class)
public abstract class ParcelaPagar_ {

	public static volatile SingularAttribute<ParcelaPagar, LancamentoPagar> lancamentoPagar;
	public static volatile SingularAttribute<ParcelaPagar, LocalDate> dataVencimento;
	public static volatile SingularAttribute<ParcelaPagar, BigDecimal> valor;
	public static volatile SingularAttribute<ParcelaPagar, Conta> conta;
	public static volatile SingularAttribute<ParcelaPagar, Long> id;
	public static volatile SingularAttribute<ParcelaPagar, LocalDate> dataEmissao;

}

