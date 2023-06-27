package com.stellato.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.OrcamentoEletrico;

@Repository
public interface OrcamentoEletricoRepository extends JpaRepository<OrcamentoEletrico, Long>{

	Page<OrcamentoEletrico> findByLeadId(Long idLead, Pageable pageable); 
	
} 