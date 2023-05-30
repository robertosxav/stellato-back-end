package com.stellato.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "public.dimensionamento") 
public class Dimensionamento implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "dimensionamentoid")
	private Long dimensionamentoid;

	@Column(name = "orcamentoeletricoid")
	private Integer orcamentoeletricoid;

	@Column(name = "dimensionamentopotmodulo")
	private String dimensionamentopotmodulo;

	@Column(name = "dimensionamentopercperda")
	private String dimensionamentopercperda;

	@Column(name = "dimensionamentoareamodu")
	private String dimensionamentoareamodu;

	@Column(name = "dimensionamentostatus")
	private Integer dimensionamentostatus;

	public Long getDimensionamentoid() {
		return dimensionamentoid;
	}
	 
	public void setDimensionamentoid(Long dimensionamentoid) {
		this.dimensionamentoid = dimensionamentoid;
	}
	 
	public Integer getOrcamentoeletricoid() {
		return orcamentoeletricoid;
	}
	 
	public void setOrcamentoeletricoid(Integer orcamentoeletricoid) {
		this.orcamentoeletricoid = orcamentoeletricoid;
	}
	 
	public String getDimensionamentopotmodulo() {
		return dimensionamentopotmodulo;
	}
	 
	public void setDimensionamentopotmodulo(String dimensionamentopotmodulo) {
		this.dimensionamentopotmodulo = dimensionamentopotmodulo;
	}
	 
	public String getDimensionamentopercperda() {
		return dimensionamentopercperda;
	}
	 
	public void setDimensionamentopercperda(String dimensionamentopercperda) {
		this.dimensionamentopercperda = dimensionamentopercperda;
	}
	 
	public String getDimensionamentoareamodu() {
		return dimensionamentoareamodu;
	}
	 
	public void setDimensionamentoareamodu(String dimensionamentoareamodu) {
		this.dimensionamentoareamodu = dimensionamentoareamodu;
	}
	 
	public Integer getDimensionamentostatus() {
		return dimensionamentostatus;
	}
	 
	public void setDimensionamentostatus(Integer dimensionamentostatus) {
		this.dimensionamentostatus = dimensionamentostatus;
	}
	 

} 
