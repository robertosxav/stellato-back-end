package com.stellato.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "public.fornecedor") 
public class Fornecedor implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "fornecedorid")
	private Long fornecedorid;

	@Column(name = "fornecedornome")
	private String fornecedornome;

	@Column(name = "fornecedor")
	private Integer fornecedor;

	public Long getFornecedorid() {
		return fornecedorid;
	}
	 
	public void setFornecedorid(Long fornecedorid) {
		this.fornecedorid = fornecedorid;
	}
	 
	public String getFornecedornome() {
		return fornecedornome;
	}
	 
	public void setFornecedornome(String fornecedornome) {
		this.fornecedornome = fornecedornome;
	}
	 
	public Integer getFornecedor() {
		return fornecedor;
	}
	 
	public void setFornecedor(Integer fornecedor) {
		this.fornecedor = fornecedor;
	}
	 

} 
