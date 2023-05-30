package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.Dimensionamento;

@Repository
public interface DimensionamentoRepository extends JpaRepository<Dimensionamento, Long>{ 
	
} 