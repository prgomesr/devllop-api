package com.devllop.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="fornecedor")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max=70)
	@Column(name="razao_social")
	private String razaoSocial;
	
	@NotNull
	@Size(max=45)
	private String fantasia;
	
	@Size(max=45)
	private String cnpj;
	
	@Size(max=45)
	@Column(name="insc_estadual")
	private String inscEstadual;
	
	@Size(max=45)
	@Column(name="insc_municipal")
	private String inscMunicipal;
	
	private Boolean isento;
	
	@Size(max=20)
	@Column(name="telefone_principal")
	private String telefonePrincipal;
	
	@Size(max=20)
	@Column(name="telefone_secundario")
	private String telefoneSecundario;
	
	@Size(max=45)
	private String contato;
	
	@Size(max=70)
	private String email;
	
	@Size(max=255)
	private String observacao;
	
	@OneToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getFantasia() {
		return fantasia;
	}
	
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getInscEstadual() {
		return inscEstadual;
	}
	
	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}
	
	public String getInscMunicipal() {
		return inscMunicipal;
	}
	
	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}
	
	public Boolean getIsento() {
		return isento;
	}
	
	public void setIsento(Boolean isento) {
		this.isento = isento;
	}
	
	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}
	
	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}
	
	public String getTelefoneSecundario() {
		return telefoneSecundario;
	}
	
	public void setTelefoneSecundario(String telefoneSecundario) {
		this.telefoneSecundario = telefoneSecundario;
	}
	
	public String getContato() {
		return contato;
	}
	
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
