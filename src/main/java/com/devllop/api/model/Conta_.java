package com.devllop.api.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Conta.class)
public abstract class Conta_ {

	public static volatile SingularAttribute<Conta, String> numero;
	public static volatile SingularAttribute<Conta, Boolean> carteira;
	public static volatile SingularAttribute<Conta, BigDecimal> saldoAtual;
	public static volatile SingularAttribute<Conta, Long> id;
	public static volatile SingularAttribute<Conta, BigDecimal> saldoInicial;
	public static volatile SingularAttribute<Conta, Empresa> empresa;
	public static volatile SingularAttribute<Conta, String> digito;
	public static volatile SingularAttribute<Conta, Agencia> agencia;
	public static volatile SingularAttribute<Conta, String> descricao;

}

