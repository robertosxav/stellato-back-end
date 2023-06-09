package com.stellato.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.model.enumerated.StatusEnum;

@Entity
@Table(name = "fornecedor") 
public class Fornecedor implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_FORNECEDOR")
	@SequenceGenerator(name = "SEQUENCE_FORNECEDOR",sequenceName = "seq_fornecedor",allocationSize = 1)
	@Column(name = "fornecedor_id")
	private Long id;

	@Column(name = "fornecedor_nome")
	private String nome;
	
	@Column(name = "fornecedor_status")
	private StatusEnum status;

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

	public StatusEnum getStatus() {
		return status;
	}

	public LocalDate getCriadoEm() {
		return criadoEm;
	}


	public Integer getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Integer criadoPor) {
		this.criadoPor = criadoPor;
	}
	
	public void ativar() {
		this.status = StatusEnum.ATIVO;
		this.criadoEm = LocalDate.now();
	}
	
	public void inativar() {
		this.status = StatusEnum.INATIVO;
	}
} 