package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.FunilVendas;

@Repository
public interface FunilVendasRepository extends JpaRepository<FunilVendas, Long>{ 
	
} 