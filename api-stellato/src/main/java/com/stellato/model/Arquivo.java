package com.stellato.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "public.arquivo") 
public class Arquivo implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "arquivoid")
	private Long arquivoid;

	@Column(name = "arquivonome")
	private String arquivonome;

	@Column(name = "arquivoextensao")
	private String arquivoextensao;

	@Column(name = "arquivostatus")
	private Integer arquivostatus;

	@Column(name = "arquivoblob")
	private String arquivoblob;

	public Long getArquivoid() {
		return arquivoid;
	}
	 
	public void setArquivoid(Long arquivoid) {
		this.arquivoid = arquivoid;
	}
	 
	public String getArquivonome() {
		return arquivonome;
	}
	 
	public void setArquivonome(String arquivonome) {
		this.arquivonome = arquivonome;
	}
	 
	public String getArquivoextensao() {
		return arquivoextensao;
	}
	 
	public void setArquivoextensao(String arquivoextensao) {
		this.arquivoextensao = arquivoextensao;
	}
	 
	public Integer getArquivostatus() {
		return arquivostatus;
	}
	 
	public void setArquivostatus(Integer arquivostatus) {
		this.arquivostatus = arquivostatus;
	}
	 
	public String getArquivoblob() {
		return arquivoblob;
	}
	 
	public void setArquivoblob(String arquivoblob) {
		this.arquivoblob = arquivoblob;
	}
	 

} 
