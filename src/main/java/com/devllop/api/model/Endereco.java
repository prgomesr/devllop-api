package com.devllop.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Endereco {

	@Size(max=70)
	@Column(name="end_logradouro")
	private String logradouro;
	
	@Size(max=10)
	@Column(name="end_numero")
	private String numero;
	
	@Size(max=45)
	@Column(name="end_complemento")
	private String complemento;
	
	@Size(max=70)
	@Column(name="end_bairro")
	private String bairro;
	
	@Size(max=70)
	@Column(name="end_cidade")
	private String cidade;
	
	@Size(max=2)
	@Column(name="end_uf")
	private String uf;
	
	@Size(max=20)
	@Column(name="end_cep")
	private String cep;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
