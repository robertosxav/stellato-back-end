package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.Dadoscontaenergia;

@Repository
public interface DadoscontaenergiaRepository extends JpaRepository<Dadoscontaenergia, Long>{ 
	
} 