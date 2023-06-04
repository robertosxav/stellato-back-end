package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.OrcamentoEleMatCotado;

@Repository
public interface OrcamentoEleMatCotadoRepository extends JpaRepository<OrcamentoEleMatCotado, Long>{ 
	
} 