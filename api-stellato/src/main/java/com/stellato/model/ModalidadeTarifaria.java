package com.stellato.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "modalidade_tarifaria") 
public class ModalidadeTarifaria implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "modalidade_tarifaria_id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "distribuidora_id",referencedColumnName = "distribuidora_id")
	private Distribuidora distribuidora;

	@Column(name = "modalidade_tarifaria_valor")
	private String valor;

	@Column(name = "modalidade_tarifaria_status")
	private Integer status;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "modalidade_tarifaria_criado_em")
	private LocalDate criadoEm;

	@Column(name = "modalidade_tarifaria_criado_por")
	private Integer criadoPor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Distribuidora getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
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