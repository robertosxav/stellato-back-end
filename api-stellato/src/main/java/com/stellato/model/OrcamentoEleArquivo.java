package com.stellato.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.orcamentoelearquivo") 
public class OrcamentoEleArquivo implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "orcamentoelearquivoid")
	private Long orcamentoelearquivoid;

	@Column(name = "orcamentoeletricoid")
	private Integer orcamentoeletricoid;

	@Column(name = "arquivoid")
	private Integer arquivoid;

	@Column(name = "orcamentoelearquivostatus")
	private Integer orcamentoelearquivostatus;

	public Long getOrcamentoelearquivoid() {
		return orcamentoelearquivoid;
	}
	 
	public void setOrcamentoelearquivoid(Long orcamentoelearquivoid) {
		this.orcamentoelearquivoid = orcamentoelearquivoid;
	}
	 
	public Integer getOrcamentoeletricoid() {
		return orcamentoeletricoid;
	}
	 
	public void setOrcamentoeletricoid(Integer orcamentoeletricoid) {
		this.orcamentoeletricoid = orcamentoeletricoid;
	}
	 
	public Integer getArquivoid() {
		return arquivoid;
	}
	 
	public void setArquivoid(Integer arquivoid) {
		this.arquivoid = arquivoid;
	}
	 
	public Integer getOrcamentoelearquivostatus() {
		return orcamentoelearquivostatus;
	}
	 
	public void setOrcamentoelearquivostatus(Integer orcamentoelearquivostatus) {
		this.orcamentoelearquivostatus = orcamentoelearquivostatus;
	}
	 

} 
