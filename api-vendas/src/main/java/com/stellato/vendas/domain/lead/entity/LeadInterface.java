package com.stellato.vendas.domain.lead.entity;

import com.stellato.vendas.domain.shared.enumerated.StatusEnum;

public interface LeadInterface {
	public Long getId();
	public void SetId(Long id);
	public StatusEnum getStatus();
	public void setStatus(StatusEnum status);
}
