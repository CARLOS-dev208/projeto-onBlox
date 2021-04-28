package com.sistemacontroler.dto;


import javax.validation.constraints.NotBlank;

public class ClienteNewDTO {
	
	private Long codigo;
	
	@NotBlank(message = "Preenchimento obrigatório!")
	private String nome;
	

	private Long vendedorCodigo;
	
	
	public ClienteNewDTO() {}


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Long getVendedorCodigo() {
		return vendedorCodigo;
	}


	public void setVendedorCodigo(Long vendedorCodigo) {
		this.vendedorCodigo = vendedorCodigo;
	}
	
	
	
}
