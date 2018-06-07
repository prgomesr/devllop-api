package com.devllop.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empresa.class)
public abstract class Empresa_ {

	public static volatile SingularAttribute<Empresa, String> inscEstadual;
	public static volatile SingularAttribute<Empresa, String> fantasia;
	public static volatile SingularAttribute<Empresa, Long> id;
	public static volatile SingularAttribute<Empresa, String> cnpj;
	public static volatile SingularAttribute<Empresa, String> razaoSocial;
	public static volatile SingularAttribute<Empresa, String> inscMunicipal;
	public static volatile SingularAttribute<Empresa, Boolean> isento;
	public static volatile SingularAttribute<Empresa, String> email;
	public static volatile SingularAttribute<Empresa, LocalDate> dataFundacao;

}

