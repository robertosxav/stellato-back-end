package com.stellato.administrador.infrastructure.material;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.stellato.administrador.infrastructure.material.shared.BaseModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Table(name = "TB_MATERIAL",schema = "ADMINISTRADOR")
@Entity
public class MaterialModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_MATERIAL")
	@SequenceGenerator(name = "SEQUENCE_MATERIAL",sequenceName = "administrador.tb_material_seq",allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	private String descricao;
	
	private Integer tipo;

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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public MaterialModel() {
		super();
	
	}

	public MaterialModel(Long id, String descricao, Integer tipo, Integer status, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super(status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
	}
    
	public MaterialModel(String descricao, Integer tipo, Integer status, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super(status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.descricao = descricao;
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaterialModel other = (MaterialModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "MaterialModel [id=" + id + ", descricao=" + descricao + ", tipo=" + tipo + "]";
	}
	
	

}
