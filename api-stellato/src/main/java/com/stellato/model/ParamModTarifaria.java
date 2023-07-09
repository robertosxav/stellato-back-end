package com.stellato.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import com.stellato.model.enumerated.ModalidadeTariariaEnum;
import com.stellato.model.enumerated.StatusEnum;

@Entity
@Table(name = "param_mod_tarifaria") 
public class ParamModTarifaria implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_PARAM_MODALIDADE_TARIFARIA")
	@SequenceGenerator(name = "SEQUENCE_PARAM_MODALIDADE_TARIFARIA",sequenceName = "seq_param_modalidade_tarifaria",allocationSize = 1)
	@Column(name = "param_mod_tarifaria_id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "distribuidora_id",referencedColumnName  = "distribuidora_id")
	private Distribuidora distribuidora;
	
	@Column(name= "modalidade_tarifaria")
	private ModalidadeTariariaEnum modalidadeTariaria;
	
	@Column(name = "param_mod_tarifaria_valor")
	private BigDecimal valor;

	@Column(name = "param_mod_tarifaria_status")
	private StatusEnum status;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "param_mod_tarifaria_criado_em")
	private LocalDate criadoEm;

	@Column(name = "param_mod_tarifaria_criado_por")
	private Integer criadoPor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Distribuidora getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
	}

	public ModalidadeTariariaEnum getModalidadeTariaria() {
		return modalidadeTariaria;
	}

	public void setModalidadeTariaria(ModalidadeTariariaEnum modalidadeTariaria) {
		this.modalidadeTariaria = modalidadeTariaria;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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