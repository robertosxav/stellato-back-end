package com.stellato.vendas.infrastructure.orcamento;

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
	
	public OrcamentoEletricoModel(Long id, String codigo, String titulo, String observacao, String observacaoInterna,
			Integer validadeProposta, Integer prazoEntrega, Integer distancia, BigDecimal potenciaModulo,
			Integer percentualPerda, String detalheProposta, Integer modalidadeTarifaria, Integer tipoPadrao,
			String unidadeConsumidora, BigDecimal consumoMedio, BigDecimal precoKwh, Integer tipoInstalacao,
			Integer tipoEstrutura, Integer idLead,Integer status, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super(codigo, status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.titulo = titulo;
		this.observacao = observacao;
		this.observacaoInterna = observacaoInterna;
		this.validadeProposta = validadeProposta;
		this.prazoEntrega = prazoEntrega;
		this.distancia = distancia;
		this.potenciaModulo = potenciaModulo;
		this.percentualPerda = percentualPerda;
		this.detalheProposta = detalheProposta;
		this.modalidadeTarifaria = modalidadeTarifaria;
		this.tipoPadrao = tipoPadrao;
		this.unidadeConsumidora = unidadeConsumidora;
		this.consumoMedio = consumoMedio;
		this.precoKwh = precoKwh;
		this.tipoInstalacao = tipoInstalacao;
		this.tipoEstrutura = tipoEstrutura;
		this.idLead = idLead;
	}
	
	public OrcamentoEletricoModel(String codigo, String titulo, String observacao, String observacaoInterna,
			Integer validadeProposta, Integer prazoEntrega, Integer distancia, BigDecimal potenciaModulo,
			Integer percentualPerda, String detalheProposta, Integer modalidadeTarifaria, Integer tipoPadrao,
			String unidadeConsumidora, BigDecimal consumoMedio, BigDecimal precoKwh, Integer tipoInstalacao,
			Integer tipoEstrutura, Integer idLead,Integer status, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super(codigo, status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.titulo = titulo;
		this.observacao = observacao;
		this.observacaoInterna = observacaoInterna;
		this.validadeProposta = validadeProposta;
		this.prazoEntrega = prazoEntrega;
		this.distancia = distancia;
		this.potenciaModulo = potenciaModulo;
		this.percentualPerda = percentualPerda;
		this.detalheProposta = detalheProposta;
		this.modalidadeTarifaria = modalidadeTarifaria;
		this.tipoPadrao = tipoPadrao;
		this.unidadeConsumidora = unidadeConsumidora;
		this.consumoMedio = consumoMedio;
		this.precoKwh = precoKwh;
		this.tipoInstalacao = tipoInstalacao;
		this.tipoEstrutura = tipoEstrutura;
		this.idLead = idLead;
	}

}
