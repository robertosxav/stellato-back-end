package com.stellato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.stellato.model.Dimensionamento;

@Repository
public interface DimensionamentoRepository extends JpaRepository<Dimensionamento, Long>{

	@Query("SELECT d FROM Dimensionamento d where d.status =1")
	List<Dimensionamento> listarTodosAtivos();

	@Query("SELECT d FROM Dimensionamento d where d.status =1")
	Page<Dimensionamento> listarTodosAtivos(Pageable pageable); 
	
} 