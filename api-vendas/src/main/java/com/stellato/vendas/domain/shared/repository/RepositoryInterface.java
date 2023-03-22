package com.stellato.vendas.domain.shared.repository;

import java.util.List;

import com.stellato.vendas.domain.lead.entity.LeadEntity;

public interface RepositoryInterface<T> {
	public T create(T entity);
	public T update(Long id, LeadEntity leadEntityFront);
	public T findById(Long id);
	public List<T> findAll();
	
}
