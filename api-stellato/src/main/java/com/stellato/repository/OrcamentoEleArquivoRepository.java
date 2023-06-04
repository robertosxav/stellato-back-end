package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.OrcamentoEleArquivo;

@Repository
public interface OrcamentoEleArquivoRepository extends JpaRepository<OrcamentoEleArquivo, Long>{ 
	
} 