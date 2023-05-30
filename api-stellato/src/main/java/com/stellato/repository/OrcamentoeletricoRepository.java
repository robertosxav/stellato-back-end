package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.Orcamentoeletrico;

@Repository
public interface OrcamentoeletricoRepository extends JpaRepository<Orcamentoeletrico, Long>{ 
	
} 