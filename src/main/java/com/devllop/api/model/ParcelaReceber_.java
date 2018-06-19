package com.devllop.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ParcelaReceber.class)
public abstract class ParcelaReceber_ {

	public static volatile SingularAttribute<ParcelaReceber, String> numDocumento;
	public static volatile SingularAttribute<ParcelaReceber, Cliente> cliente;
	public static volatile SingularAttribute<ParcelaReceber, String> situacao;
	public static volatile SingularAttribute<ParcelaReceber, LocalDate> dataVencimento;
	public static volatile SingularAttribute<ParcelaReceber, CategoriaRecebimento> categoria;
	public static volatile SingularAttribute<ParcelaReceber, BigDecimal> valor;
	public static volatile SingularAttribute<ParcelaReceber, Conta> conta;
	public static volatile SingularAttribute<ParcelaReceber, String> nossoNumero;
	public static volatile SingularAttribute<ParcelaReceber, Long> id;
	public static volatile SingularAttribute<ParcelaReceber, LocalDate> dataEmissao;
	public static volatile SingularAttribute<ParcelaReceber, String> descricao;

}

