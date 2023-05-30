package com.stellato.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "public.modalidadetarifaria") 
public class Modalidadetarifaria implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "modalidadetarifariaid")
	private Long modalidadetarifariaid;

	@Column(name = "distribuidoraid")
	private Integer distribuidoraid;

	@Column(name = "modalidadetarifariavalor")
	private String modalidadetarifariavalor;

	@Column(name = "modalidadetarifariastatus")
	private Integer modalidadetarifariastatus;

	public Long getModalidadetarifariaid() {
		return modalidadetarifariaid;
	}
	 
	public void setModalidadetarifariaid(Long modalidadetarifariaid) {
		this.modalidadetarifariaid = modalidadetarifariaid;
	}
	 
	public Integer getDistribuidoraid() {
		return distribuidoraid;
	}
	 
	public void setDistribuidoraid(Integer distribuidoraid) {
		this.distribuidoraid = distribuidoraid;
	}
	 
	public String getModalidadetarifariavalor() {
		return modalidadetarifariavalor;
	}
	 
	public void setModalidadetarifariavalor(String modalidadetarifariavalor) {
		this.modalidadetarifariavalor = modalidadetarifariavalor;
	}
	 
	public Integer getModalidadetarifariastatus() {
		return modalidadetarifariastatus;
	}
	 
	public void setModalidadetarifariastatus(Integer modalidadetarifariastatus) {
		this.modalidadetarifariastatus = modalidadetarifariastatus;
	}
	 

} 
