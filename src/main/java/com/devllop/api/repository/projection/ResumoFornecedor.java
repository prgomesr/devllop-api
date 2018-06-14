package com.devllop.api.repository.projection;

public class ResumoFornecedor {

	private Long id;
	private String razaoSocial;
	private String fantasia;
	private String cnpj;
	private String telefonePrincipal;
	private String email;
	
	public ResumoFornecedor(Long id, String razaoSocial, String fantasia, String cnpj, String telefonePrincipal,
			String email) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.fantasia = fantasia;
		this.cnpj = cnpj;
		this.telefonePrincipal = telefonePrincipal;
		this.email = email;
	}

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
	
}
