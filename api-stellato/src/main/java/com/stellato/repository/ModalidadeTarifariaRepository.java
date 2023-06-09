package com.stellato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stellato.model.ModalidadeTarifaria;

@Repository
public interface ModalidadeTarifariaRepository extends JpaRepository<ModalidadeTarifaria, Long>{

	@Query("SELECT m FROM ModalidadeTarifaria m where m.status =1")
	Page<ModalidadeTarifaria> listarTodosAtivos(Pageable pageable);

	@Query("SELECT m FROM ModalidadeTarifaria m where m.status =1")
	List<ModalidadeTarifaria> listarTodosAtivos();

	@Query("SELECT m FROM ModalidadeTarifaria m where m.status =1 and m.distribuidora.id = :idDistribuidora")
	List<ModalidadeTarifaria> buscarPelaDistribuidora(Long idDistribuidora);
	
} 