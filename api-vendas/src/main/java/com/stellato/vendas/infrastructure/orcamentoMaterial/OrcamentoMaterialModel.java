package com.stellato.vendas.infrastructure.orcamentoMaterial;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.stellato.vendas.infrastructure.materialCotado.model.MaterialCotadoModel;
import com.stellato.vendas.infrastructure.orcamento.OrcamentoEletricoModel;
import com.stellato.vendas.infrastructure.shared.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_ORCAMENTO_MATERIAL",schema = "VENDAS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrcamentoMaterialModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_ORCAMENTO_MATERIAL")
	@SequenceGenerator(name = "SEQUENCE_ORCAMENTO_MATERIAL",sequenceName = "vendas.tb_orcamento_material_seq",allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_MATERIAL_COTADO",referencedColumnName = "ID")
	private MaterialCotadoModel materialCotado;
	
	@ManyToOne
	@JoinColumn(name = "ID_ORCAMENTO",referencedColumnName = "ID")
	private OrcamentoEletricoModel orcamentoEletrico;
	
	@Column(name = "QUANTIDADE")
	private Long quantidade;
	
	@Column(name = "VALOR")
	private BigDecimal valor;
}
