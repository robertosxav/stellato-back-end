package com.stellato.administrador.infrastructure.pessoa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stellato.administrador.domain.pessoa.entity.PessoaEntity;
import com.stellato.administrador.infrastructure.pessoa.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long>{
	
	@Query("select new com.stellato.administrador.domain.pessoa.entity.PessoaEntity(p.id,p.nome,p.cpf,"
			+ " p.nomeFantasia,p.cnpj,p.telefone,p.whatsapp,p.email,p.status,p.criadoEm,p.criadoPor,p.alteradoEm,p.alteradoPor)"
			+ " from PessoaModel p")
	public List<PessoaEntity> listarTodos();
	
	@Query("select new com.stellato.administrador.domain.pessoa.entity.PessoaEntity(p.id,p.nome,p.cpf,"
			+ " p.nomeFantasia,p.cnpj,p.telefone,p.whatsapp,p.email,p.status,p.criadoEm,p.criadoPor,p.alteradoEm,p.alteradoPor)"
			+ " from PessoaModel p where p.status =1")
	public List<PessoaEntity> listarAtivos();

	@Query("select new com.stellato.administrador.domain.pessoa.entity.PessoaEntity(p.id,p.nome,p.cpf,"
			+ " p.nomeFantasia,p.cnpj,p.telefone,p.whatsapp,p.email,p.status,p.criadoEm,p.criadoPor,p.alteradoEm,p.alteradoPor)"
			+ " from PessoaModel p where p.status =1")
	public Page<PessoaEntity> listarAtivos(Pageable pageable );

	@Query("select new com.stellato.administrador.domain.pessoa.entity.PessoaEntity(p.id,p.nome,p.cpf,"
			+ " p.nomeFantasia,p.cnpj,p.telefone,p.whatsapp,p.email,p.status,p.criadoEm,p.criadoPor,p.alteradoEm,p.alteradoPor)"
			+ " from PessoaModel p where p.status =1 and upper(p.nome) like :nome")
	public Page<PessoaEntity> listarPorNome(String nome, Pageable pageable);
}
