package com.stellato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stellato.model.ParamModTarifaria;

@Repository
public interface ParamModTarifariaRepository extends JpaRepository<ParamModTarifaria, Long>{

	@Query("SELECT m FROM ParamModTarifaria m where m.status =1")
	Page<ParamModTarifaria> listarTodosAtivos(Pageable pageable);

	@Query("SELECT m FROM ParamModTarifaria m where m.status =1")
	List<ParamModTarifaria> listarTodosAtivos();

	@Query("SELECT m FROM ParamModTarifaria m where m.status =1 and m.distribuidora.id = :idDistribuidora")
	List<ParamModTarifaria> buscarPelaDistribuidora(Long idDistribuidora);
	
} 