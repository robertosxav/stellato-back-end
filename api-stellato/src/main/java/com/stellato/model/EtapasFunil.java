package com.stellato.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.etapasfunil") 
public class EtapasFunil implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "etapasfunilid")
	private Long etapasfunilid;

	@Column(name = "funilvendasid")
	private Integer funilvendasid;

	@Column(name = "etapasfuniletapa")
	private String etapasfuniletapa;

	@Column(name = "etapasfunilstatus")
	private Integer etapasfunilstatus;

	public Long getEtapasfunilid() {
		return etapasfunilid;
	}
	 
	public void setEtapasfunilid(Long etapasfunilid) {
		this.etapasfunilid = etapasfunilid;
	}
	 
	public Integer getFunilvendasid() {
		return funilvendasid;
	}
	 
	public void setFunilvendasid(Integer funilvendasid) {
		this.funilvendasid = funilvendasid;
	}
	 
	public String getEtapasfuniletapa() {
		return etapasfuniletapa;
	}
	 
	public void setEtapasfuniletapa(String etapasfuniletapa) {
		this.etapasfuniletapa = etapasfuniletapa;
	}
	 
	public Integer getEtapasfunilstatus() {
		return etapasfunilstatus;
	}
	 
	public void setEtapasfunilstatus(Integer etapasfunilstatus) {
		this.etapasfunilstatus = etapasfunilstatus;
	}
	 

} 
