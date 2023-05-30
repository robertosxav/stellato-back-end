package com.stellato.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
