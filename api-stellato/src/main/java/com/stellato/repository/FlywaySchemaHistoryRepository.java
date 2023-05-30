package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.FlywaySchemaHistory;

@Repository
public interface FlywaySchemaHistoryRepository extends JpaRepository<FlywaySchemaHistory, Long>{ 
	
} 