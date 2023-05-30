package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>{ 
	
} 