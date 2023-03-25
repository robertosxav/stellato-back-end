package com.stellato.vendas.domain.shared;

import com.stellato.vendas.domain.shared.enumerated.StatusEnum;

public interface BaseEnityInterface {
	public Long getId();
	public void SetId(Long id);
	public StatusEnum getStatus();
	public void setStatus(StatusEnum status);
	public Boolean validar();
	public void Ativar();
	public void Alterar(Long id);
	public void Inativar();
}
