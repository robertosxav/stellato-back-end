package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long>{ 
	
} 