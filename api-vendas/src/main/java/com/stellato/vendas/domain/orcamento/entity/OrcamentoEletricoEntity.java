package com.stellato.vendas.domain.orcamento.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.vendas.domain.orcamento.entity.enumerated.TipoEstruturaEnum;
import com.stellato.vendas.domain.orcamento.entity.enumerated.TipoInstalacaoEnum;
import com.stellato.vendas.domain.orcamento.entity.enumerated.TipoPadraoEnum;
import com.stellato.vendas.domain.shared.BaseEnityInterface;
import com.stellato.vendas.domain.shared.enumerated.StatusEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrcamentoEletricoEntity implements BaseEnityInterface {

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
	
	private Integer idLead;
	
	private StatusEnum status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate criadoEm;

	private Long criadoPor;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate alteradoEm;

	private Long alteradoPor;
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	@Override
	public void SetId(Long id) {
		this.id =	id;
		
	}

	@Override
	public StatusEnum getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(StatusEnum status) {
		this.status	=	status;
		
	}

	@Override
	public Boolean validar() {
		return true;
	}

	@Override
	public void Ativar() {
		this.status 	=	StatusEnum.ATIVO;
		this.criadoEm	=	LocalDate.now();		
	}
	
	@Override
	public void Alterar(Long id) {
		this.status 	=	StatusEnum.ATIVO;
		this.alteradoEm	 =	LocalDate.now();	
		this.alteradoPor = id;
	}

	@Override
	public void Inativar() {
		this.status = StatusEnum.INATIVO;
	}

	public OrcamentoEletricoEntity(Long id, String titulo, String observacao, String observacaoInterna,
			Integer validadeProposta, Integer prazoEntrega, Integer distancia, BigDecimal potenciaModulo,
			Integer percentualPerda, String detalheProposta, Integer modalidadeTarifaria, Integer tipoPadraoNumero,
			String unidadeConsumidora, BigDecimal consumoMedio, BigDecimal precoKwh, Integer tipoInstalacaoNumero,
			Integer tipoEstruturaNumero, Integer idLead, Integer statusNumero, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super();
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
		this.idLead = idLead;
		this.status = StatusEnum.toEnum(statusNumero);
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}
	
	public OrcamentoEletricoEntity(Long id, String titulo, String observacao, String observacaoInterna,
			Integer validadeProposta, Integer prazoEntrega, Integer distancia, BigDecimal potenciaModulo,
			Integer percentualPerda, String detalheProposta, Integer modalidadeTarifaria, Integer tipoPadraoNumero,
			String unidadeConsumidora, BigDecimal consumoMedio, BigDecimal precoKwh, Integer tipoInstalacaoNumero,
			Integer tipoEstruturaNumero, Integer idLead, LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super();
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
		this.idLead = idLead;
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}
}
