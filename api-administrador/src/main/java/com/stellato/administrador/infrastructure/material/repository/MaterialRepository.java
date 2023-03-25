package com.stellato.administrador.infrastructure.material.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stellato.administrador.domain.material.entity.MaterialEntity;
import com.stellato.administrador.infrastructure.material.MaterialModel;


@Repository
public interface MaterialRepository extends JpaRepository<MaterialModel, Long>{
	
	@Query("select new com.stellato.administrador.domain.material.entity.MaterialEntity(m.id,m.descricao,m.tipo,m.status,m.criadoEm,m.criadoPor,m.alteradoEm,m.alteradoPor)"
			+ " from MaterialModel m")
	public List<MaterialEntity> listarTodos();
	
	@Query("select new com.stellato.administrador.domain.material.entity.MaterialEntity(m.id,m.descricao,m.tipo,m.status,m.criadoEm,m.criadoPor,m.alteradoEm,m.alteradoPor)"
			+ " from MaterialModel m where m.status =1")
	public List<MaterialEntity> listarAtivos();

	@Query("select new com.stellato.administrador.domain.material.entity.MaterialEntity(m.id,m.descricao,m.tipo,m.status,m.criadoEm,m.criadoPor,m.alteradoEm,m.alteradoPor)"
			+ " from MaterialModel m where m.status =1")
	public Page<MaterialEntity> listarAtivos(Pageable pageable );

	
	@Query("select new com.stellato.administrador.domain.material.entity.MaterialEntity(m.id,m.descricao,m.tipo,m.status,m.criadoEm,m.criadoPor,m.alteradoEm,m.alteradoPor)"
			+ " from MaterialModel m where m.status =1 and upper(m.descricao) like :descricao")
	public Page<MaterialEntity> listarPorDescricao(String descricao, Pageable pageable);
}