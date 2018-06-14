package com.devllop.api.repository.projection;

public class ResumoCliente {
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String telefonePrincipal;
	
	private String email;
	
	private String situacao;
	
	private Boolean ativo;
	
	public ResumoCliente(Long id, String nome, String cpf, String telefonePrincipal, String email, String situacao,
			Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefonePrincipal = telefonePrincipal;
		this.email = email;
		this.situacao = situacao;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
}
