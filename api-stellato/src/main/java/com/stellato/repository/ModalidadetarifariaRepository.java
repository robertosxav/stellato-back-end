package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.Modalidadetarifaria;

@Repository
public interface ModalidadetarifariaRepository extends JpaRepository<Modalidadetarifaria, Long>{ 
	
} 