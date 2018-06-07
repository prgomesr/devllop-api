package com.devllop.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Agencia.class)
public abstract class Agencia_ {

	public static volatile SingularAttribute<Agencia, String> telefone;
	public static volatile SingularAttribute<Agencia, String> numero;
	public static volatile SingularAttribute<Agencia, Banco> banco;
	public static volatile SingularAttribute<Agencia, Long> id;
	public static volatile SingularAttribute<Agencia, String> digito;
	public static volatile SingularAttribute<Agencia, String> gerente;

}

