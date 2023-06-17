package com.stellato.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.model.enumerated.StatusEnum;

@Entity
@Table(name = "etapas_funil") 
public class EtapasFunil implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_ETAPAS_FUNIL")
	@SequenceGenerator(name = "SEQUENCE_ETAPAS_FUNIL",sequenceName = "seq_etapas_funil",allocationSize = 1)
	@Column(name = "etapas_funil_id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "funil_vendas_id",referencedColumnName = "funil_vendas_id")
	private FunilVendas funilVendas;

	@Column(name = "etapas_funil_etapa")
	private String etapa;
	
	@Column(name = "etapas_funil_ordem")
	private Integer ordem;

	@Column(name = "etapas_funil_status")
	private StatusEnum status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "etapas_funil_criado_em")
	private LocalDate criadoEm;

	@Column(name = "etapas_funil_criado_por")
	private Integer criadoPor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FunilVendas getFunilVendas() {
		return funilVendas;
	}

	public void setFunilVendas(FunilVendas funilVendas) {
		this.funilVendas = funilVendas;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public LocalDate getCriadoEm() {
		return criadoEm;
	}

	public Integer getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Integer criadoPor) {
		this.criadoPor = criadoPor;
	}

	public void ativar() {
		this.status = StatusEnum.ATIVO;
		this.criadoEm = LocalDate.now();
	}
	
	public void inativar() {
		this.status = StatusEnum.INATIVO;
	}

} 
