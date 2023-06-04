package com.stellato.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.material") 
public class Material implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "materialid")
	private Long materialid;

	@Column(name = "materialdescricao")
	private String materialdescricao;

	@Column(name = "materialtipo")
	private Integer materialtipo;

	@Column(name = "materialunidademedida")
	private Integer materialunidademedida;

	public Long getMaterialid() {
		return materialid;
	}
	 
	public void setMaterialid(Long materialid) {
		this.materialid = materialid;
	}
	 
	public String getMaterialdescricao() {
		return materialdescricao;
	}
	 
	public void setMaterialdescricao(String materialdescricao) {
		this.materialdescricao = materialdescricao;
	}
	 
	public Integer getMaterialtipo() {
		return materialtipo;
	}
	 
	public void setMaterialtipo(Integer materialtipo) {
		this.materialtipo = materialtipo;
	}
	 
	public Integer getMaterialunidademedida() {
		return materialunidademedida;
	}
	 
	public void setMaterialunidademedida(Integer materialunidademedida) {
		this.materialunidademedida = materialunidademedida;
	}
	 

} 
