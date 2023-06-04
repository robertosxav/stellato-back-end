package com.stellato.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.distribuidora") 
public class Distribuidora implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "distribuidoraid")
	private Long distribuidoraid;

	@Column(name = "distribuidoranome")
	private String distribuidoranome;

	@Column(name = "distribuidorasigla")
	private String distribuidorasigla;

	@Column(name = "distribuidorastatus")
	private Integer distribuidorastatus;

	@Column(name = "distribuidoracriadopor")
	private Integer distribuidoracriadopor;

	@Column(name = "distribuidoracriadoem")
	private String distribuidoracriadoem;

	@Column(name = "distribuidoracriardoporn")
	private String distribuidoracriardoporn;

	@Column(name = "distribuidoraalteradoem")
	private String distribuidoraalteradoem;

	@Column(name = "distribuidoraalteradopor")
	private Integer distribuidoraalteradopor;

	@Column(name = "distribuidoraalteradoporn")
	private String distribuidoraalteradoporn;

	public Long getDistribuidoraid() {
		return distribuidoraid;
	}
	 
	public void setDistribuidoraid(Long distribuidoraid) {
		this.distribuidoraid = distribuidoraid;
	}
	 
	public String getDistribuidoranome() {
		return distribuidoranome;
	}
	 
	public void setDistribuidoranome(String distribuidoranome) {
		this.distribuidoranome = distribuidoranome;
	}
	 
	public String getDistribuidorasigla() {
		return distribuidorasigla;
	}
	 
	public void setDistribuidorasigla(String distribuidorasigla) {
		this.distribuidorasigla = distribuidorasigla;
	}
	 
	public Integer getDistribuidorastatus() {
		return distribuidorastatus;
	}
	 
	public void setDistribuidorastatus(Integer distribuidorastatus) {
		this.distribuidorastatus = distribuidorastatus;
	}
	 
	public Integer getDistribuidoracriadopor() {
		return distribuidoracriadopor;
	}
	 
	public void setDistribuidoracriadopor(Integer distribuidoracriadopor) {
		this.distribuidoracriadopor = distribuidoracriadopor;
	}
	 
	public String getDistribuidoracriadoem() {
		return distribuidoracriadoem;
	}
	 
	public void setDistribuidoracriadoem(String distribuidoracriadoem) {
		this.distribuidoracriadoem = distribuidoracriadoem;
	}
	 
	public String getDistribuidoracriardoporn() {
		return distribuidoracriardoporn;
	}
	 
	public void setDistribuidoracriardoporn(String distribuidoracriardoporn) {
		this.distribuidoracriardoporn = distribuidoracriardoporn;
	}
	 
	public String getDistribuidoraalteradoem() {
		return distribuidoraalteradoem;
	}
	 
	public void setDistribuidoraalteradoem(String distribuidoraalteradoem) {
		this.distribuidoraalteradoem = distribuidoraalteradoem;
	}
	 
	public Integer getDistribuidoraalteradopor() {
		return distribuidoraalteradopor;
	}
	 
	public void setDistribuidoraalteradopor(Integer distribuidoraalteradopor) {
		this.distribuidoraalteradopor = distribuidoraalteradopor;
	}
	 
	public String getDistribuidoraalteradoporn() {
		return distribuidoraalteradoporn;
	}
	 
	public void setDistribuidoraalteradoporn(String distribuidoraalteradoporn) {
		this.distribuidoraalteradoporn = distribuidoraalteradoporn;
	}
	 

} 
