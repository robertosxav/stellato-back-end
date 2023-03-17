package com.stellato.vendas.domain.shared.repository;

import java.math.BigDecimal;
import java.util.List;

import com.stellato.vendas.domain.lead.entity.LeadEntity;

public interface RepositoryInterface<T> {
	public LeadEntity create(T entity);
	public LeadEntity update(BigDecimal id, LeadEntity leadEntityFront);
	public LeadEntity findById(BigDecimal id);
	public List<T> findAll();
	
}
