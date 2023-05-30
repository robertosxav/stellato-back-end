package com.stellato.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "public.dadoscontaenergia") 
public class Dadoscontaenergia implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "dadoscontaenergiaid")
	private Long dadoscontaenergiaid;

	@Column(name = "orcamentoeletricoid")
	private Integer orcamentoeletricoid;

	@Column(name = "dadoscontaenergiauc")
	private String dadoscontaenergiauc;

	@Column(name = "dadoscontaenergiadescricaouc")
	private String dadoscontaenergiadescricaouc;

	@Column(name = "dadoscontaenergiatipopadrao")
	private Integer dadoscontaenergiatipopadrao;

	@Column(name = "dadoscontaenergiamodtarifa")
	private Integer dadoscontaenergiamodtarifa;

	@Column(name = "dadoscontaenergiaprecokwh")
	private String dadoscontaenergiaprecokwh;

	@Column(name = "dadoscontaenergiaconsumomedio")
	private String dadoscontaenergiaconsumomedio;

	public Long getDadoscontaenergiaid() {
		return dadoscontaenergiaid;
	}
	 
	public void setDadoscontaenergiaid(Long dadoscontaenergiaid) {
		this.dadoscontaenergiaid = dadoscontaenergiaid;
	}
	 
	public Integer getOrcamentoeletricoid() {
		return orcamentoeletricoid;
	}
	 
	public void setOrcamentoeletricoid(Integer orcamentoeletricoid) {
		this.orcamentoeletricoid = orcamentoeletricoid;
	}
	 
	public String getDadoscontaenergiauc() {
		return dadoscontaenergiauc;
	}
	 
	public void setDadoscontaenergiauc(String dadoscontaenergiauc) {
		this.dadoscontaenergiauc = dadoscontaenergiauc;
	}
	 
	public String getDadoscontaenergiadescricaouc() {
		return dadoscontaenergiadescricaouc;
	}
	 
	public void setDadoscontaenergiadescricaouc(String dadoscontaenergiadescricaouc) {
		this.dadoscontaenergiadescricaouc = dadoscontaenergiadescricaouc;
	}
	 
	public Integer getDadoscontaenergiatipopadrao() {
		return dadoscontaenergiatipopadrao;
	}
	 
	public void setDadoscontaenergiatipopadrao(Integer dadoscontaenergiatipopadrao) {
		this.dadoscontaenergiatipopadrao = dadoscontaenergiatipopadrao;
	}
	 
	public Integer getDadoscontaenergiamodtarifa() {
		return dadoscontaenergiamodtarifa;
	}
	 
	public void setDadoscontaenergiamodtarifa(Integer dadoscontaenergiamodtarifa) {
		this.dadoscontaenergiamodtarifa = dadoscontaenergiamodtarifa;
	}
	 
	public String getDadoscontaenergiaprecokwh() {
		return dadoscontaenergiaprecokwh;
	}
	 
	public void setDadoscontaenergiaprecokwh(String dadoscontaenergiaprecokwh) {
		this.dadoscontaenergiaprecokwh = dadoscontaenergiaprecokwh;
	}
	 
	public String getDadoscontaenergiaconsumomedio() {
		return dadoscontaenergiaconsumomedio;
	}
	 
	public void setDadoscontaenergiaconsumomedio(String dadoscontaenergiaconsumomedio) {
		this.dadoscontaenergiaconsumomedio = dadoscontaenergiaconsumomedio;
	}
	 

} 
