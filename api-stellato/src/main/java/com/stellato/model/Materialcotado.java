package com.stellato.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "public.materialcotado") 
public class Materialcotado implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "materialcotadoid")
	private Long materialcotadoid;

	@Column(name = "materialcotadoobservacao")
	private String materialcotadoobservacao;

	@Column(name = "materialcotadovalor")
	private String materialcotadovalor;

	@Column(name = "fornecedorid")
	private Integer fornecedorid;

	@Column(name = "materialid")
	private Integer materialid;

	@Column(name = "materialcotadodescricao")
	private String materialcotadodescricao;

	public Long getMaterialcotadoid() {
		return materialcotadoid;
	}
	 
	public void setMaterialcotadoid(Long materialcotadoid) {
		this.materialcotadoid = materialcotadoid;
	}
	 
	public String getMaterialcotadoobservacao() {
		return materialcotadoobservacao;
	}
	 
	public void setMaterialcotadoobservacao(String materialcotadoobservacao) {
		this.materialcotadoobservacao = materialcotadoobservacao;
	}
	 
	public String getMaterialcotadovalor() {
		return materialcotadovalor;
	}
	 
	public void setMaterialcotadovalor(String materialcotadovalor) {
		this.materialcotadovalor = materialcotadovalor;
	}
	 
	public Integer getFornecedorid() {
		return fornecedorid;
	}
	 
	public void setFornecedorid(Integer fornecedorid) {
		this.fornecedorid = fornecedorid;
	}
	 
	public Integer getMaterialid() {
		return materialid;
	}
	 
	public void setMaterialid(Integer materialid) {
		this.materialid = materialid;
	}
	 
	public String getMaterialcotadodescricao() {
		return materialcotadodescricao;
	}
	 
	public void setMaterialcotadodescricao(String materialcotadodescricao) {
		this.materialcotadodescricao = materialcotadodescricao;
	}
	 

} 
