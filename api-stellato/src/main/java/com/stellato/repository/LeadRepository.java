package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long>{ 
	
} 