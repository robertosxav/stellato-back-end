package com.stellato.administrador.infrastructure.fornecedor.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stellato.administrador.domain.fornecedor.entity.FornecedorEntity;
import com.stellato.administrador.infrastructure.fornecedor.FornecedorModel;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long>{
	
	@Query("select new com.stellato.administrador.domain.fornecedor.entity.FornecedorEntity(f.id,f.codigo,f.razaoSocial,f.cnpj,"
			+"f.status,f.criadoEm,f.criadoPor,f.alteradoEm,f.alteradoPor) from FornecedorModel f")
	public List<FornecedorEntity> listarTodos();
	
	@Query("select new com.stellato.administrador.domain.fornecedor.entity.FornecedorEntity(f.id,f.codigo,f.razaoSocial,f.cnpj,"
			+"f.status,f.criadoEm,f.criadoPor,f.alteradoEm,f.alteradoPor) from FornecedorModel f where f.status =1")
	public List<FornecedorEntity> listarAtivos();

	@Query("select new com.stellato.administrador.domain.fornecedor.entity.FornecedorEntity(f.id,f.codigo,f.razaoSocial,f.cnpj,"
			+"f.status,f.criadoEm,f.criadoPor,f.alteradoEm,f.alteradoPor) from FornecedorModel f where f.status =1")
	public Page<FornecedorEntity> listarAtivos(Pageable pageable );


	@Query("select new com.stellato.administrador.domain.fornecedor.entity.FornecedorEntity(f.id,f.codigo,f.razaoSocial,f.cnpj,"
			+"f.status,f.criadoEm,f.criadoPor,f.alteradoEm,f.alteradoPor) from FornecedorModel f where f.status =1 and f.razaoSocial = :razaoSocial")
	public Page<FornecedorEntity> listarPorRazaoSocial(String razaoSocial, Pageable pageable);
}
