package com.stellato.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "fornecedor") 
public class Fornecedor implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "fornecedor_id")
	private Long id;

	@Column(name = "fornecedor_nome")
	private String nome;

	
	@Column(name = "fornecedor_status")
	private Integer status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "fornecedor_criado_em")
	private LocalDate criadoEm;

	@Column(name = "fornecedor_criado_por")
	private Integer criadoPor;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDate getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Integer getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Integer criadoPor) {
		this.criadoPor = criadoPor;
	}

} 