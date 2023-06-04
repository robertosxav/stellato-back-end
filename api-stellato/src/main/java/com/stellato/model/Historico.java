package com.stellato.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.historico") 
public class Historico implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "historicoid")
	private Long historicoid;

	public Long getHistoricoid() {
		return historicoid;
	}
	 
	public void setHistoricoid(Long historicoid) {
		this.historicoid = historicoid;
	}
	 

} 
