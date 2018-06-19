package com.devllop.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LancamentoPagar.class)
public abstract class LancamentoPagar_ {

	public static volatile SingularAttribute<LancamentoPagar, String> numDocumento;
	public static volatile SingularAttribute<LancamentoPagar, CategoriaPagamento> categoriaPagamento;
	public static volatile SingularAttribute<LancamentoPagar, BigDecimal> valorTotal;
	public static volatile SingularAttribute<LancamentoPagar, Long> id;
	public static volatile SingularAttribute<LancamentoPagar, Fornecedor> fornecedor;
	public static volatile SingularAttribute<LancamentoPagar, LocalDate> dataLancamento;

}

