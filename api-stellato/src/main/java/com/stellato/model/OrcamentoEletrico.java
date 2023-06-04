package com.stellato.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.orcamentoeletrico") 
public class OrcamentoEletrico implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "orcamentoeletricoid")
	private Long orcamentoeletricoid;

	@Column(name = "leadid")
	private Integer leadid;

	@Column(name = "orcamentoeletricotitulo")
	private String orcamentoeletricotitulo;

	@Column(name = "orcamentoeletricoobservacao")
	private String orcamentoeletricoobservacao;

	@Column(name = "orcamentoeletricoobservacaoint")
	private String orcamentoeletricoobservacaoint;

	@Column(name = "orcamentoeletricovalidadepropo")
	private Integer orcamentoeletricovalidadepropo;

	@Column(name = "orcamentoeletricoprazoentrega")
	private Integer orcamentoeletricoprazoentrega;

	@Column(name = "orcamentoeletricodistancia")
	private Integer orcamentoeletricodistancia;

	@Column(name = "orcamentoeletricodetalhespropo")
	private String orcamentoeletricodetalhespropo;

	@Column(name = "orcamentoeletricotipoinstalaca")
	private Integer orcamentoeletricotipoinstalaca;

	@Column(name = "orcamentoeletricotipoestrutura")
	private Integer orcamentoeletricotipoestrutura;

	@Column(name = "etapasfunilid")
	private Integer etapasfunilid;

	public Long getOrcamentoeletricoid() {
		return orcamentoeletricoid;
	}
	 
	public void setOrcamentoeletricoid(Long orcamentoeletricoid) {
		this.orcamentoeletricoid = orcamentoeletricoid;
	}
	 
	public Integer getLeadid() {
		return leadid;
	}
	 
	public void setLeadid(Integer leadid) {
		this.leadid = leadid;
	}
	 
	public String getOrcamentoeletricotitulo() {
		return orcamentoeletricotitulo;
	}
	 
	public void setOrcamentoeletricotitulo(String orcamentoeletricotitulo) {
		this.orcamentoeletricotitulo = orcamentoeletricotitulo;
	}
	 
	public String getOrcamentoeletricoobservacao() {
		return orcamentoeletricoobservacao;
	}
	 
	public void setOrcamentoeletricoobservacao(String orcamentoeletricoobservacao) {
		this.orcamentoeletricoobservacao = orcamentoeletricoobservacao;
	}
	 
	public String getOrcamentoeletricoobservacaoint() {
		return orcamentoeletricoobservacaoint;
	}
	 
	public void setOrcamentoeletricoobservacaoint(String orcamentoeletricoobservacaoint) {
		this.orcamentoeletricoobservacaoint = orcamentoeletricoobservacaoint;
	}
	 
	public Integer getOrcamentoeletricovalidadepropo() {
		return orcamentoeletricovalidadepropo;
	}
	 
	public void setOrcamentoeletricovalidadepropo(Integer orcamentoeletricovalidadepropo) {
		this.orcamentoeletricovalidadepropo = orcamentoeletricovalidadepropo;
	}
	 
	public Integer getOrcamentoeletricoprazoentrega() {
		return orcamentoeletricoprazoentrega;
	}
	 
	public void setOrcamentoeletricoprazoentrega(Integer orcamentoeletricoprazoentrega) {
		this.orcamentoeletricoprazoentrega = orcamentoeletricoprazoentrega;
	}
	 
	public Integer getOrcamentoeletricodistancia() {
		return orcamentoeletricodistancia;
	}
	 
	public void setOrcamentoeletricodistancia(Integer orcamentoeletricodistancia) {
		this.orcamentoeletricodistancia = orcamentoeletricodistancia;
	}
	 
	public String getOrcamentoeletricodetalhespropo() {
		return orcamentoeletricodetalhespropo;
	}
	 
	public void setOrcamentoeletricodetalhespropo(String orcamentoeletricodetalhespropo) {
		this.orcamentoeletricodetalhespropo = orcamentoeletricodetalhespropo;
	}
	 
	public Integer getOrcamentoeletricotipoinstalaca() {
		return orcamentoeletricotipoinstalaca;
	}
	 
	public void setOrcamentoeletricotipoinstalaca(Integer orcamentoeletricotipoinstalaca) {
		this.orcamentoeletricotipoinstalaca = orcamentoeletricotipoinstalaca;
	}
	 
	public Integer getOrcamentoeletricotipoestrutura() {
		return orcamentoeletricotipoestrutura;
	}
	 
	public void setOrcamentoeletricotipoestrutura(Integer orcamentoeletricotipoestrutura) {
		this.orcamentoeletricotipoestrutura = orcamentoeletricotipoestrutura;
	}
	 
	public Integer getEtapasfunilid() {
		return etapasfunilid;
	}
	 
	public void setEtapasfunilid(Integer etapasfunilid) {
		this.etapasfunilid = etapasfunilid;
	}
	 

} 
