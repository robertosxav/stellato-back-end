package com.stellato.vendas.infrastructure.lead.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stellato.vendas.infrastructure.lead.LeadModel;

@Repository
public interface LeadRepository extends JpaRepository<LeadModel, Long>{

	@Query("select l from LeadModel l where l.id = :id")
	public Optional<LeadModel> buscarPorId(Long id);

	
	@Query("select l from LeadModel l")
	public List<LeadModel> listarTodos();
	
	@Query("select l from LeadModel l where l.status =1")
	public List<LeadModel> listarAtivos();
	
}
