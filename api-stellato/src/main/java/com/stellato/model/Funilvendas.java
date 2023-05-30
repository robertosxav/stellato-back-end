package com.stellato.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "public.funilvendas") 
public class Funilvendas implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "funilvendasid")
	private Long funilvendasid;

	@Column(name = "funilvendasdescricao")
	private String funilvendasdescricao;

	@Column(name = "funilvendasstatus")
	private Integer funilvendasstatus;

	public Long getFunilvendasid() {
		return funilvendasid;
	}
	 
	public void setFunilvendasid(Long funilvendasid) {
		this.funilvendasid = funilvendasid;
	}
	 
	public String getFunilvendasdescricao() {
		return funilvendasdescricao;
	}
	 
	public void setFunilvendasdescricao(String funilvendasdescricao) {
		this.funilvendasdescricao = funilvendasdescricao;
	}
	 
	public Integer getFunilvendasstatus() {
		return funilvendasstatus;
	}
	 
	public void setFunilvendasstatus(Integer funilvendasstatus) {
		this.funilvendasstatus = funilvendasstatus;
	}
	 

} 
