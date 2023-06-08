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
@Table(name = "distribuidora") 
public class Distribuidora implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_DISTRIBUIDORA")
	@SequenceGenerator(name = "SEQUENCE_DISTRIBUIDORA",sequenceName = "seq_distribuidora",allocationSize = 1)
	@Column(name = "distribuidora_id")
	private Long id;

	@Column(name = "distribuidora_nome")
	private String nome;

	@Column(name = "distribuidora_sigla")
	private String sigla;

	@Column(name = "distribuidora_status")
	private StatusEnum status;

	@Column(name = "distribuidora_criado_por")
	private Integer criadoPor;

	@JsonFormat(pattern = "dd/MM/yyyy")
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


	public StatusEnum getStatus() {
		return status;
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
	
	public void ativar() {
		this.status = StatusEnum.ATIVO;
		this.criadoEm = LocalDate.now();
	}
	
	public void inativar() {
		this.status = StatusEnum.INATIVO;
	}

} 
