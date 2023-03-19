package com.stellato.vendas.domain.historicoLead.entity;

import java.math.BigDecimal;

import com.stellato.vendas.domain.shared.enumerated.StatusEnum;

public interface HistoricoLeadInterface {
	public BigDecimal getId();
	public void SetId(BigDecimal id);
	public StatusEnum getStatus();
	public void setStatus(StatusEnum status);
}
