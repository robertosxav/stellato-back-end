package com.stellato.vendas.domain.orcamento.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	
	private Integer tipoPadrao;
	
	private String unidadeConsumidora;
	
	private BigDecimal consumoMedio;
	
	private BigDecimal precoKwh;
	
	private Integer tipoInstalacao;
	
	private Integer tipoEstrutura;
	
	private Integer idLead;
	
	private StatusEnum status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate criadoEm;

	private Long criadoPor;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate alteradoEm;

	private Long alteradoPor;
	
	@Override
	public void SetId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StatusEnum getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStatus(StatusEnum status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean validar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Ativar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Alterar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Inativar() {
		// TODO Auto-generated method stub
		
	}

}
