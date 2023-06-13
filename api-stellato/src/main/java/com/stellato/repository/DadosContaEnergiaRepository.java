package com.stellato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.stellato.model.DadosContaEnergia;

@Repository
public interface DadosContaEnergiaRepository extends JpaRepository<DadosContaEnergia, Long>{

	@Query("SELECT dce FROM DadosContaEnergia dce WHERE dce.status =1")
	Page<DadosContaEnergia> listarTodosAtivos(Pageable pageable);

	@Query("SELECT dce FROM DadosContaEnergia dce WHERE dce.status =1")
	List<DadosContaEnergia> listarTodosAtivos(); 
	
} 