package com.stellato.vendas.domain.historicoLead.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.domain.shared.BaseEntity;
import com.stellato.vendas.domain.shared.BaseEntityInterface;
import com.stellato.vendas.domain.shared.enumerated.StatusEnum;
import com.stellato.vendas.exceptions.StellatoException;

public class HistoricoLeadEntity extends BaseEntity{
	
	private Long id; 
	
	private String decricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	private StatusEnum status;
	
	private LeadEntity lead;
	
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void SetId(Long id) {
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
		public LeadEntity getLead() {
		return lead;
	}

	public void setLead(LeadEntity lead) {
		this.lead = lead;
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

	public HistoricoLeadEntity(Long id, String decricao, LocalDate data, StatusEnum status, LeadEntity lead) {
		super();
		this.id = id;
		this.decricao = decricao;
		this.data = data;
		this.status = status;
		this.lead	= lead;
	}

	
}
