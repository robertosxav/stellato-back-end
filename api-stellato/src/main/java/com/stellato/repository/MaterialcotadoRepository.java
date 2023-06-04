package com.stellato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stellato.model.MaterialCotado;

@Repository
public interface MaterialcotadoRepository extends JpaRepository<MaterialCotado, Long>{ 
	
} 