package com.stellato.vendas.infrastructure.orcamento;

import java.io.Serializable;
import java.math.BigDecimal;

import com.stellato.vendas.infrastructure.lead.LeadModel;
import com.stellato.vendas.infrastructure.shared.BaseModel;

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

@Table(name = "TB_ORCAMENTO_ELETRICO",schema = "VENDAS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrcamentoEletricoModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_ORCAM_ELETRICO")
	@SequenceGenerator(name = "SEQUENCE_ORCAM_ELETRICO",sequenceName = "vendas.tb_orcamento_eletrico_seq",allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	private String titulo;
	
	private String observacao;
	
	private String observacaoInterna;
	
	private Integer validadeProposta;
	
	private Integer prazoEntrega;
	
	private Integer distancia;
	
	private BigDecimal potenciaModulo;
	
	private Integer percentualPerda;
	
	private String detalheProposta;
	
	@Column(name = "MODALIDA_TARIFARIA")
	private Integer modalidadeTarifaria;
	
	private Integer tipoPadrao;
	
	@Column(name = "UC")
	private String unidadeConsumidora;
	
	private BigDecimal consumoMedio;
	
	private BigDecimal precoKwh;
	
	private Integer tipoInstalacao;
	
	private Integer tipoEstrutura;
	
	private Integer idLead;

}
