package com.devllop.api.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Convenio.class)
public abstract class Convenio_ {

	public static volatile SingularAttribute<Convenio, BigDecimal> txMulta;
	public static volatile SingularAttribute<Convenio, String> numero;
	public static volatile SingularAttribute<Convenio, BigDecimal> txJuros;
	public static volatile SingularAttribute<Convenio, Conta> conta;
	public static volatile SingularAttribute<Convenio, Long> id;

}

