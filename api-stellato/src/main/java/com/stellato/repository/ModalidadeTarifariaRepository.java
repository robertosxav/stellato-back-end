package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.ModalidadeTarifaria;

@Repository
public interface ModalidadeTarifariaRepository extends JpaRepository<ModalidadeTarifaria, Long>{ 
	
} 