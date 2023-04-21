package com.stellato.vendas.domain.orcamento.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.domain.orcamento.entity.enumerated.TipoEstruturaEnum;
import com.stellato.vendas.domain.orcamento.entity.enumerated.TipoInstalacaoEnum;
import com.stellato.vendas.domain.orcamento.entity.enumerated.TipoPadraoEnum;
import com.stellato.vendas.domain.orcamentoMaterial.entity.OrcamentoMaterialEntity;
import com.stellato.vendas.domain.shared.BaseEntity;
import com.stellato.vendas.infrastructure.materialCotado.model.MaterialCotadoModel;
import com.stellato.vendas.infrastructure.orcamentoMaterial.OrcamentoMaterialModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrcamentoEletricoEntity extends BaseEntity {

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
	
	private Integer modalidadeTarifaria;
	
	private TipoPadraoEnum tipoPadrao;
	
	private String unidadeConsumidora;
	
	private BigDecimal consumoMedio;
	
	private BigDecimal precoKwh;
	
	private TipoInstalacaoEnum tipoInstalacao;
	
	private TipoEstruturaEnum tipoEstrutura;
	
	@Setter
	private LeadEntity lead;
	
	private List<OrcamentoMaterialEntity>listaMateriais = new ArrayList<OrcamentoMaterialEntity>();
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	@Override
	public void SetId(Long id) {
		this.id =	id;
		
	}

	@Override
	public Boolean validar() {
		return true;
	}
	
	public void addMaterial(OrcamentoMaterialEntity orcamentoMaterialEntity) {
		listaMateriais.add(orcamentoMaterialEntity);
	}
	
	public OrcamentoEletricoEntity(Long id, String codigo,String titulo, String observacao, String observacaoInterna,
			Integer validadeProposta, Integer prazoEntrega, Integer distancia, BigDecimal potenciaModulo,
			Integer percentualPerda, String detalheProposta, Integer modalidadeTarifaria, Integer tipoPadraoNumero,
			String unidadeConsumidora, BigDecimal consumoMedio, BigDecimal precoKwh, Integer tipoInstalacaoNumero,
			Integer tipoEstruturaNumero, LeadEntity lead, Integer statusNumero, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super(codigo,statusNumero, criadoEm, criadoPor, alteradoEm, alteradoPor);
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
		this.tipoPadrao = TipoPadraoEnum.toEnum(tipoPadraoNumero);
		this.unidadeConsumidora = unidadeConsumidora;
		this.consumoMedio = consumoMedio;
		this.precoKwh = precoKwh;
		this.tipoInstalacao = TipoInstalacaoEnum.toEnum(tipoInstalacaoNumero);
		this.tipoEstrutura = TipoEstruturaEnum.toEnum(tipoEstruturaNumero);
		this.lead = lead;

	}

	
	public OrcamentoEletricoEntity(Long id, String codigo, String titulo, String observacao, String observacaoInterna,
			Integer validadeProposta, Integer prazoEntrega, Integer distancia, BigDecimal potenciaModulo,
			Integer percentualPerda, String detalheProposta, Integer modalidadeTarifaria, Integer tipoPadraoNumero,
			String unidadeConsumidora, BigDecimal consumoMedio, BigDecimal precoKwh, Integer tipoInstalacaoNumero,
			Integer tipoEstruturaNumero, LeadEntity lead,/* List<MaterialCotadoModel>listaMateriais,*/LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(codigo, criadoEm, criadoPor, alteradoEm, alteradoPor);
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
		this.tipoPadrao = TipoPadraoEnum.toEnum(tipoPadraoNumero);
		this.unidadeConsumidora = unidadeConsumidora;
		this.consumoMedio = consumoMedio;
		this.precoKwh = precoKwh;
		this.tipoInstalacao = TipoInstalacaoEnum.toEnum(tipoInstalacaoNumero);
		this.tipoEstrutura = TipoEstruturaEnum.toEnum(tipoEstruturaNumero);
		this.lead	= lead;
		//this.listaMateriais = listaMateriais;
	}
	
	public OrcamentoEletricoEntity(Long id, String codigo, String titulo, String observacao, String observacaoInterna,
			Integer validadeProposta, Integer prazoEntrega, Integer distancia, BigDecimal potenciaModulo,
			Integer percentualPerda, String detalheProposta, Integer modalidadeTarifaria, Integer tipoPadraoNumero,
			String unidadeConsumidora, BigDecimal consumoMedio, BigDecimal precoKwh, Integer tipoInstalacaoNumero,
			Integer tipoEstruturaNumero,Long idLead, String nomeLead,String telefoneLead, String emailLead,String whatsAppLead,
			Integer statusNumero, LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(codigo, statusNumero, criadoEm, criadoPor, alteradoEm, alteradoPor);
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
		this.tipoPadrao = TipoPadraoEnum.toEnum(tipoPadraoNumero);
		this.unidadeConsumidora = unidadeConsumidora;
		this.consumoMedio = consumoMedio;
		this.precoKwh = precoKwh;
		this.tipoInstalacao = TipoInstalacaoEnum.toEnum(tipoInstalacaoNumero);
		this.tipoEstrutura = TipoEstruturaEnum.toEnum(tipoEstruturaNumero);
		this.lead	= new LeadEntity(idLead, nomeLead, telefoneLead,emailLead,whatsAppLead);
		//this.listaMateriais = listaMateriais;
	}
	
}
