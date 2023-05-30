package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.Distribuidora;

@Repository
public interface DistribuidoraRepository extends JpaRepository<Distribuidora, Long>{ 
	
} 