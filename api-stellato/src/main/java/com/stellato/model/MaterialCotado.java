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
@Table(name = "material_cotado") 
public class MaterialCotado implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "material_cotado_id")
	private Long id;
	
	@Column(name = "material_cotado_descricao")
	private String material_cotado_descricao;

	@Column(name = "material_cotado_observacao")
	private String observacao;

	@Column(name = "material_cotado_valor")
	private String valor;

	@ManyToOne()
	@JoinColumn(name = "fornecedor_id",referencedColumnName = "fornecedor_id")
	private Fornecedor fornecedor;

	@ManyToOne()
	@JoinColumn(name = "material_id",referencedColumnName = "material_id")
	private Material material;
	
	@Column(name = "material_status")
	private Integer status;

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

	public String getMaterial_cotado_descricao() {
		return material_cotado_descricao;
	}

	public void setMaterial_cotado_descricao(String material_cotado_descricao) {
		this.material_cotado_descricao = material_cotado_descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
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