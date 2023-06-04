package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.EtapasFunil;

@Repository
public interface EtapasfunilRepository extends JpaRepository<EtapasFunil, Long>{ 
	
} 