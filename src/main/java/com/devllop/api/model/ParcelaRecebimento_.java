package com.devllop.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ParcelaRecebimento.class)
public abstract class ParcelaRecebimento_ {

	public static volatile SingularAttribute<ParcelaRecebimento, TipoLancamento> tipoLancamento;
	public static volatile SingularAttribute<ParcelaRecebimento, Conta> conta;
	public static volatile SingularAttribute<ParcelaRecebimento, Long> id;
	public static volatile SingularAttribute<ParcelaRecebimento, ParcelaReceber> parcelaReceber;
	public static volatile SingularAttribute<ParcelaRecebimento, LocalDate> dataRecebimento;
	public static volatile SingularAttribute<ParcelaRecebimento, BigDecimal> valorRecebido;

}

