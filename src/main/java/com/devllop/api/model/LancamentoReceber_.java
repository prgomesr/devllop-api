package com.devllop.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LancamentoReceber.class)
public abstract class LancamentoReceber_ {

	public static volatile SingularAttribute<LancamentoReceber, String> numDocumento;
	public static volatile SingularAttribute<LancamentoReceber, Cliente> cliente;
	public static volatile SingularAttribute<LancamentoReceber, BigDecimal> valorAReceber;
	public static volatile SingularAttribute<LancamentoReceber, CategoriaReceber> categoriaReceber;
	public static volatile SingularAttribute<LancamentoReceber, BigDecimal> valorTotal;
	public static volatile SingularAttribute<LancamentoReceber, Long> id;
	public static volatile SingularAttribute<LancamentoReceber, LocalDate> dataLancamento;

}

