package com.stellato.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.orcamentoelematcotado") 
public class OrcamentoEleMatCotado implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "orcamentoelematcotadoid")
	private Long orcamentoelematcotadoid;

	@Column(name = "materialcotadoid")
	private Integer materialcotadoid;

	@Column(name = "orcamentoeletricoid")
	private Integer orcamentoeletricoid;

	@Column(name = "orcamentoelematcotadoqtd")
	private Integer orcamentoelematcotadoqtd;

	@Column(name = "orcamentoelematcotadovalor")
	private String orcamentoelematcotadovalor;

	public Long getOrcamentoelematcotadoid() {
		return orcamentoelematcotadoid;
	}
	 
	public void setOrcamentoelematcotadoid(Long orcamentoelematcotadoid) {
		this.orcamentoelematcotadoid = orcamentoelematcotadoid;
	}
	 
	public Integer getMaterialcotadoid() {
		return materialcotadoid;
	}
	 
	public void setMaterialcotadoid(Integer materialcotadoid) {
		this.materialcotadoid = materialcotadoid;
	}
	 
	public Integer getOrcamentoeletricoid() {
		return orcamentoeletricoid;
	}
	 
	public void setOrcamentoeletricoid(Integer orcamentoeletricoid) {
		this.orcamentoeletricoid = orcamentoeletricoid;
	}
	 
	public Integer getOrcamentoelematcotadoqtd() {
		return orcamentoelematcotadoqtd;
	}
	 
	public void setOrcamentoelematcotadoqtd(Integer orcamentoelematcotadoqtd) {
		this.orcamentoelematcotadoqtd = orcamentoelematcotadoqtd;
	}
	 
	public String getOrcamentoelematcotadovalor() {
		return orcamentoelematcotadovalor;
	}
	 
	public void setOrcamentoelematcotadovalor(String orcamentoelematcotadovalor) {
		this.orcamentoelematcotadovalor = orcamentoelematcotadovalor;
	}
	 

} 
