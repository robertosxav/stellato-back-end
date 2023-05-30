package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.Orcamentoelematcotado;

@Repository
public interface OrcamentoelematcotadoRepository extends JpaRepository<Orcamentoelematcotado, Long>{ 
	
} 