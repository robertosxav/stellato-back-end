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
@Table(name = "etapas_funil") 
public class EtapasFunil implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "etapas_funil_id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "funil_vendas_id",referencedColumnName = "funil_vendas_id")
	private FunilVendas funilVendas;

	@Column(name = "etapas_funil_etapa")
	private String etapa;

	@Column(name = "etapas_funil_status")
	private Integer status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "etapas_funil_criado_em")
	private LocalDate criadoEm;

	@Column(name = "etapas_funil_criado_por")
	private Integer criadoPor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FunilVendas getFunilVendas() {
		return funilVendas;
	}

	public void setFunilVendas(FunilVendas funilVendas) {
		this.funilVendas = funilVendas;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
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
