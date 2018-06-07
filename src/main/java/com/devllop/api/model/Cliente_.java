package com.devllop.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, LocalDate> nascimento;
	public static volatile SingularAttribute<Cliente, String> observacao;
	public static volatile SingularAttribute<Cliente, Boolean> ativo;
	public static volatile SingularAttribute<Cliente, String> situacao;
	public static volatile SingularAttribute<Cliente, String> telefoneSecundario;
	public static volatile SingularAttribute<Cliente, String> telefonePrincipal;
	public static volatile SingularAttribute<Cliente, Endereco> endereco;
	public static volatile SingularAttribute<Cliente, String> nome;
	public static volatile SingularAttribute<Cliente, EstadoCivil> estadoCivil;
	public static volatile SingularAttribute<Cliente, String> rg;
	public static volatile SingularAttribute<Cliente, String> cpf;
	public static volatile SingularAttribute<Cliente, Long> id;
	public static volatile SingularAttribute<Cliente, String> sexo;
	public static volatile SingularAttribute<Cliente, String> email;

}

