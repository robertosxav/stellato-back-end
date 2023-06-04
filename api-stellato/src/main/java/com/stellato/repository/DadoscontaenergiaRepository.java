package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.DadosContaEnergia;

@Repository
public interface DadoscontaenergiaRepository extends JpaRepository<DadosContaEnergia, Long>{ 
	
} 