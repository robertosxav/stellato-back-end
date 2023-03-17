package com.stellato.vendas.domain.lead.entity;

import java.math.BigDecimal;

import com.stellato.vendas.domain.shared.enumerated.StatusEnum;

public interface LeadInterface {
	public BigDecimal getId();
	public StatusEnum getStatus();
}
