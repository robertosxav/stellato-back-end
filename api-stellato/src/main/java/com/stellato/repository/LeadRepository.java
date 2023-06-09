package com.stellato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.stellato.model.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long>{

	@Query("SELECT l FROM Lead l WHERE l.status =1")
	List<Lead> listarTodosAtivos();
	
	@Query("SELECT l FROM Lead l WHERE l.status =1")
	Page<Lead> listarTodosAtivos(Pageable pageable);

	@Query("SELECT l FROM Lead l WHERE l.status =1")
	Page<Lead> buscaGenerica(String pesquisa, Pageable pageable); 
	
} 