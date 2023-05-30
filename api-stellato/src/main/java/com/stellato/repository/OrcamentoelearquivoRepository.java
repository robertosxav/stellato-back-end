package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.Orcamentoelearquivo;

@Repository
public interface OrcamentoelearquivoRepository extends JpaRepository<Orcamentoelearquivo, Long>{ 
	
} 