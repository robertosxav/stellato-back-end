package com.stellato.administrador.infrastructure.material;

import java.io.Serializable;
import java.time.LocalDate;

import com.stellato.administrador.infrastructure.shared.BaseModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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

}
