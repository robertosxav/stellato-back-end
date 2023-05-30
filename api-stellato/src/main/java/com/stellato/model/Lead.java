package com.stellato.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "public.lead") 
public class Lead implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "leadid")
	private Long leadid;

	@Column(name = "leadnome")
	private String leadnome;

	@Column(name = "leadtelefone")
	private String leadtelefone;

	@Column(name = "pessoaid")
	private Integer pessoaid;

	@Column(name = "leadwhatsapp")
	private String leadwhatsapp;

	@Column(name = "leademail")
	private String leademail;

	@Column(name = "leadcidade")
	private String leadcidade;

	@Column(name = "leadorigem")
	private Integer leadorigem;

	@Column(name = "leadtipo")
	private Integer leadtipo;

	public Long getLeadid() {
		return leadid;
	}
	 
	public void setLeadid(Long leadid) {
		this.leadid = leadid;
	}
	 
	public String getLeadnome() {
		return leadnome;
	}
	 
	public void setLeadnome(String leadnome) {
		this.leadnome = leadnome;
	}
	 
	public String getLeadtelefone() {
		return leadtelefone;
	}
	 
	public void setLeadtelefone(String leadtelefone) {
		this.leadtelefone = leadtelefone;
	}
	 
	public Integer getPessoaid() {
		return pessoaid;
	}
	 
	public void setPessoaid(Integer pessoaid) {
		this.pessoaid = pessoaid;
	}
	 
	public String getLeadwhatsapp() {
		return leadwhatsapp;
	}
	 
	public void setLeadwhatsapp(String leadwhatsapp) {
		this.leadwhatsapp = leadwhatsapp;
	}
	 
	public String getLeademail() {
		return leademail;
	}
	 
	public void setLeademail(String leademail) {
		this.leademail = leademail;
	}
	 
	public String getLeadcidade() {
		return leadcidade;
	}
	 
	public void setLeadcidade(String leadcidade) {
		this.leadcidade = leadcidade;
	}
	 
	public Integer getLeadorigem() {
		return leadorigem;
	}
	 
	public void setLeadorigem(Integer leadorigem) {
		this.leadorigem = leadorigem;
	}
	 
	public Integer getLeadtipo() {
		return leadtipo;
	}
	 
	public void setLeadtipo(Integer leadtipo) {
		this.leadtipo = leadtipo;
	}
	 

} 
