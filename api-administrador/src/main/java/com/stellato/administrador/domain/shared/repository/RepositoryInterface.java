package com.stellato.administrador.domain.shared.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RepositoryInterface<T> {
	public T create(T entity);
	public T update(Long id, T entity);
	public T findById(Long id);
	public List<T> findAll();
	public List<T> findAllActives();
	public Page<T> findAllActivesPage(Pageable pageable);
	
}
