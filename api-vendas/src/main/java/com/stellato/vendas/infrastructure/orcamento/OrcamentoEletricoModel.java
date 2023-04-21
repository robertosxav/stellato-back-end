package com.stellato.vendas.infrastructure.orcamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.stellato.vendas.infrastructure.lead.LeadModel;
import com.stellato.vendas.infrastructure.materialCotado.model.MaterialCotadoModel;
import com.stellato.vendas.infrastructure.orcamentoMaterial.OrcamentoMaterialModel;
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
	
	@Column(name = "TITULO")
	private String titulo;
	
	@Column(name = "OBSERVACAO")
	private String observacao;
	
	@Column(name = "OBSERVACAO_INTERNA")
	private String observacaoInterna;
	
	@Column(name = "VALIDADE_PROPOSTA")
	private Integer validadeProposta;
	
	@Column(name = "PRAZO_ENTREGA")
	private Integer prazoEntrega;
	
	@Column(name = "DISTANCIA")
	private Integer distancia;
	
	@Column(name = "POTENCIA_MODULO")
	private BigDecimal potenciaModulo;
	
	@Column(name = "PERCENTUAL_PERDA")
	private Integer percentualPerda;
	
	@Column(name = "DETALHE_PROPOSTA")
	private String detalheProposta;
	
	@Column(name = "MODALIDA_TARIFARIA")
	private Integer modalidadeTarifaria;
	
	@Column(name = "TIPO_PADRAO")
	private Integer tipoPadrao;
	
	@Column(name = "UC")
	private String unidadeConsumidora;
	
	@Column(name = "CONSUMO_MEDIO")
	private BigDecimal consumoMedio;
	
	@Column(name = "PRECO_KWH")
	private BigDecimal precoKwh;
	
	@Column(name = "TIPO_INSTALACAO")
	private Integer tipoInstalacao;
	
	@Column(name = "TIPO_ESTRUTURA")
	private Integer tipoEstrutura;
	
	@ManyToOne()
	@JoinColumn(name = "ID_LEAD")
	private LeadModel lead;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "orcamentoEletrico")
	private List<OrcamentoMaterialModel>listaMateriais;
	
	public OrcamentoEletricoModel(Long id, String codigo, String titulo, String observacao, String observacaoInterna,
			Integer validadeProposta, Integer prazoEntrega, Integer distancia, BigDecimal potenciaModulo,
			Integer percentualPerda, String detalheProposta, Integer modalidadeTarifaria, Integer tipoPadrao,
			String unidadeConsumidora, BigDecimal consumoMedio, BigDecimal precoKwh, Integer tipoInstalacao,
			Integer tipoEstrutura, LeadModel lead, /*List<MaterialCotadoModel> listaMateriais,*/ Integer status, LocalDate criadoEm, Long criadoPor,
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
		this.lead = lead;
		//this.listaMateriais = listaMateriais;

	}
	
	public OrcamentoEletricoModel(String codigo, String titulo, String observacao, String observacaoInterna,
			Integer validadeProposta, Integer prazoEntrega, Integer distancia, BigDecimal potenciaModulo,
			Integer percentualPerda, String detalheProposta, Integer modalidadeTarifaria, Integer tipoPadrao,
			String unidadeConsumidora, BigDecimal consumoMedio, BigDecimal precoKwh, Integer tipoInstalacao,
			Integer tipoEstrutura, LeadModel lead/*,List<MaterialCotadoModel> listaMateriais*/,Integer status, LocalDate criadoEm, Long criadoPor,
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
		this.lead = lead;
		//this.listaMateriais = listaMateriais;
	}

}
