package com.devllop.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ParcelaPagamento.class)
public abstract class ParcelaPagamento_ {

	public static volatile SingularAttribute<ParcelaPagamento, ParcelaPagar> parcelaPagar;
	public static volatile SingularAttribute<ParcelaPagamento, LocalDate> dataPagamento;
	public static volatile SingularAttribute<ParcelaPagamento, TipoLancamento> tipoLancamento;
	public static volatile SingularAttribute<ParcelaPagamento, BigDecimal> valorPago;
	public static volatile SingularAttribute<ParcelaPagamento, Long> id;
	public static volatile SingularAttribute<ParcelaPagamento, Conta> contaId;

}

