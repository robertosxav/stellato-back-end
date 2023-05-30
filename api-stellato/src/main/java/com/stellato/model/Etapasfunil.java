package com.stellato.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "public.etapasfunil") 
public class Etapasfunil implements Serializable{ 
	
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
