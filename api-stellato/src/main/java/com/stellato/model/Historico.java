package com.stellato.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historico") 
public class Historico implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "historico_id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
} 