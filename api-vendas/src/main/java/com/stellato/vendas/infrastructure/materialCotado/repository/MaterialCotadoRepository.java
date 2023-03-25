package com.stellato.vendas.infrastructure.materialCotado.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;
import com.stellato.vendas.infrastructure.materialCotado.MaterialCotadoModel;

@Repository
public interface MaterialCotadoRepository extends JpaRepository<MaterialCotadoModel, Long>{
	
	@Query("select new com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity(m.id,m.observacao,m.valor,m.idFornecedor,"
			+ "m.idMaterial,m.status,m.criadoEm,m.criadoPor,m.alteradoEm,m.alteradoPor) from MaterialCotadoModel m")
	public List<MaterialCotadoEntity> listarTodos();
	
	@Query("select new com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity(m.id,m.observacao,m.valor,m.idFornecedor,"
			+ "m.idMaterial,m.status,m.criadoEm,m.criadoPor,m.alteradoEm,m.alteradoPor) from MaterialCotadoModel m where m.status = 1")
	public List<MaterialCotadoEntity> listarAtivos();

	@Query("select new com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity(m.id,m.observacao,m.valor,m.idFornecedor,"
			+ "m.idMaterial,m.status,m.criadoEm,m.criadoPor,m.alteradoEm,m.alteradoPor) from MaterialCotadoModel m")
	public Page<MaterialCotadoEntity> listarAtivos(Pageable pageable );

}