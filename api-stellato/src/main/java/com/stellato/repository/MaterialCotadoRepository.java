package com.stellato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stellato.model.MaterialCotado;

@Repository
public interface MaterialCotadoRepository extends JpaRepository<MaterialCotado, Long>{ 
	@Query("SELECT mc FROM MaterialCotado mc WHERE mc.status =1")
	List<MaterialCotado> listarTodosAtivos();
	
	@Query("SELECT mc FROM MaterialCotado mc WHERE mc.status =1")
	Page<MaterialCotado> listarTodosAtivos(Pageable pageable);
	
	@Query("SELECT mc FROM MaterialCotado mc WHERE mc.status =1")
	Page<MaterialCotado> buscaGenerica(String pesquisa, Pageable pageable);

	@Query("SELECT mc FROM MaterialCotado mc WHERE mc.status =1 and mc.material.id = :idMaterial")
	Page<MaterialCotado> listarPorMaterial(Long idMaterial, Pageable pageable);

} 