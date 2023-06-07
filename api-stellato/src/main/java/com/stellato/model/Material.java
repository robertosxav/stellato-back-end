package com.stellato.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.model.enumerated.StatusEnum;
import com.stellato.model.enumerated.TipoMaterialEnum;
import com.stellato.model.enumerated.UnidadeMedidaEnum;

@Entity
@Table(name = "material") 
public class Material implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_MATERIAL")
	@SequenceGenerator(name = "SEQUENCE_MATERIAL",sequenceName = "seq_material",allocationSize = 1)
	@Column(name = "material_id")
	private Long id;

	@Column(name = "material_descricao")
	private String descricao;

	@Column(name = "material_tipo")
	private TipoMaterialEnum tipo;

	@Column(name = "material_unidade_medida")
	private UnidadeMedidaEnum unidadeMedida;

	@Column(name = "material_status")
	private StatusEnum status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "material_criado_em")
	private LocalDate criadoEm;

	@Column(name = "material_criado_por")
	private Integer criadoPor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoMaterialEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoMaterialEnum tipo) {
		this.tipo = tipo;
	}

	public UnidadeMedidaEnum getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedidaEnum unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
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
