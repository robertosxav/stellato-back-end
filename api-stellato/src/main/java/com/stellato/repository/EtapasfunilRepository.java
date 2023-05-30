package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.Etapasfunil;

@Repository
public interface EtapasfunilRepository extends JpaRepository<Etapasfunil, Long>{ 
	
} 