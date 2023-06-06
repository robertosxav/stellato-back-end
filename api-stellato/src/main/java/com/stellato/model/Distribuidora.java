package com.stellato.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distribuidora") 
public class Distribuidora implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "distribuidora_id")
	private Long id;

	@Column(name = "distribuidora_nome")
	private String nome;

	@Column(name = "distribuidora_sigla")
	private String sigla;

	@Column(name = "distribuidora_status")
	private Integer status;

	@Column(name = "distribuidora_criado_por")
	private Integer criadoPor;

	@Column(name = "distribuidora_criado_em")
	private LocalDate criadoEm;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Integer criadoPor) {
		this.criadoPor = criadoPor;
	}

	public LocalDate getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}

} 
