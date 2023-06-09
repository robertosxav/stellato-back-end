package com.stellato.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "dimensionamento") 
public class Dimensionamento implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "dimensionamento_id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "orcamento_eletrico_id",referencedColumnName = "orcamento_eletrico_id")
	private OrcamentoEletrico orcamentoEletrico;

	@Column(name = "dimensionamento_potmodulo")
	private String potenciaModulo;

	@Column(name = "dimensionamento_percperda")
	private String percentualPerda;

	@Column(name = "dimensionamento_area_modu")
	private String areaModu;

	@Column(name = "dimensionamento_status")
	private Integer status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dimensionamento_criado_em")
	private LocalDate criadoEm;
	
	@Column(name = "dimensionamento_criado_por")
	private Integer criadoPor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrcamentoEletrico getOrcamentoEletrico() {
		return orcamentoEletrico;
	}

	public void setOrcamentoEletrico(OrcamentoEletrico orcamentoEletrico) {
		this.orcamentoEletrico = orcamentoEletrico;
	}

	public String getPotenciaModulo() {
		return potenciaModulo;
	}

	public void setPtenciaModulo(String potenciaModulo) {
		this.potenciaModulo = potenciaModulo;
	}

	public String getPercentualPerda() {
		return percentualPerda;
	}

	public void setPercentualPerda(String percentualPerda) {
		this.percentualPerda = percentualPerda;
	}

	public String getAreaModu() {
		return areaModu;
	}

	public void setAreaModu(String areaModu) {
		this.areaModu = areaModu;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDate getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Integer getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Integer criadoPor) {
		this.criadoPor = criadoPor;
	}
	
	

} 