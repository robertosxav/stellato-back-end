package com.stellato.administrador.infrastructure.material;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.stellato.administrador.infrastructure.shared.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "TB_MATERIAL",schema = "ADMINISTRADOR")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_MATERIAL")
	@SequenceGenerator(name = "SEQUENCE_MATERIAL",sequenceName = "administrador.tb_material_seq",allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="TIPO")
	private Integer tipo;

	@Column(name="UNIDADE_MEDIDA")
	private Integer unidadeMedida;

	public MaterialModel(Long id,String codigo,String descricao, Integer tipo,Integer unidadeMedida,Integer status, 
			LocalDate criadoEm,Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(codigo,status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
		this.unidadeMedida = unidadeMedida;
	}
    
	public MaterialModel(String descricao,String codigo, Integer tipo,Integer unidadeMedida, Integer status,
			LocalDate criadoEm,Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(codigo,status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.descricao = descricao;
		this.tipo = tipo;
		this.unidadeMedida = unidadeMedida;
	}

}
