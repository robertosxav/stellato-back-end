package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.Arquivo;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long>{ 
	
} 