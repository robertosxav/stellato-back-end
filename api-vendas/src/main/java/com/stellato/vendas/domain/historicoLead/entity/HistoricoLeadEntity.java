package com.stellato.vendas.domain.historicoLead.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.domain.lead.entity.LeadInterface;
import com.stellato.vendas.domain.shared.enumerated.StatusEnum;
import com.stellato.vendas.exceptions.StellatoException;

public class HistoricoLeadEntity implements LeadInterface{
	
	private BigDecimal id;
	
	private String decricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	private StatusEnum status;
	
	private LeadEntity lead;
	
	@Override
	public BigDecimal getId() {
		return this.id;
	}

	@Override
	public void SetId(BigDecimal id) {
		this.id	= id;
		
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}	

	public String getDecricao() {
		return decricao;
	}

	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}
	@Override
	public StatusEnum getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(StatusEnum status) {
		this.status	=	status;
	}
	
	public void Ativar() {
		this.status = StatusEnum.ATIVO;
	}
	
	public Boolean validar(){
		if (this.decricao.isEmpty()) {
			throw new StellatoException("Descrição é obrigatório");
		}
		
		if (this.data == null) {
			throw new StellatoException("Data é obrigatório");
		}
				
		
		return true;
	}

	public HistoricoLeadEntity() {
		super();
	}

	public HistoricoLeadEntity(BigDecimal id, String decricao, LocalDate data, StatusEnum status) {
		super();
		this.id = id;
		this.decricao = decricao;
		this.data = data;
		this.status = status;
	}
	
}
