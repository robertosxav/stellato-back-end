package com.stellato.vendas.infrastructure.materialCotado;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.stellato.vendas.infrastructure.shared.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_MATERIAL_COTADO",schema = "VENDAS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialCotadoModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_MATERIAL_COTADO")
	@SequenceGenerator(name = "SEQUENCE_MATERIAL_COTADO",sequenceName = "vendas.tb_material_cotado_seq",allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name= "OBSERVACAO")
	private String observacao;
	
	@Column(name= "VALOR")
	private BigDecimal valor;
	
	@Column(name= "ID_FORNECEDOR")
	private Long idFornecedor;
	
	@Column(name= "ID_MATERIAL")
	private Long idMaterial;
	
	public MaterialCotadoModel(Long id, String observacao, BigDecimal valor, Long idFornecedor, Long idMaterial, Integer status, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super(status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.observacao = observacao;
		this.valor = valor;
		this.idFornecedor = idFornecedor;
		this.idMaterial = idMaterial;
	}
	
	public MaterialCotadoModel(String observacao, BigDecimal valor, Long idFornecedor, Long idMaterial, Integer status, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super(status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.observacao = observacao;
		this.valor = valor;
		this.idFornecedor = idFornecedor;
		this.idMaterial = idMaterial;
	}
}
