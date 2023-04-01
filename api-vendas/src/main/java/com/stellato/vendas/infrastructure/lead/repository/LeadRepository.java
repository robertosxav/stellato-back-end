package com.stellato.vendas.infrastructure.lead.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.infrastructure.lead.LeadModel;

@Repository
public interface LeadRepository extends JpaRepository<LeadModel, Long>{
	
	@Query("select new com.stellato.vendas.domain.lead.entity.LeadEntity(l.id,l.codigo,l.nome,l.telefone,l.whatsapp,"
			+ "l.email,l.cidade, l.origem, l.tipoLead,l.idPessoa,l.status, l.criadoEm,l.criadoPor,l.alteradoEm, l.alteradoPor)"
			+ " from LeadModel l")
	public List<LeadEntity> listarTodos();
	
	@Query("select new com.stellato.vendas.domain.lead.entity.LeadEntity(l.id,l.codigo,l.nome,l.telefone,l.whatsapp,"
			+ "l.email,l.cidade, l.origem, l.tipoLead,l.idPessoa,l.status, l.criadoEm,l.criadoPor,l.alteradoEm, l.alteradoPor)"
			+ " from LeadModel l where l.status =1")
	public List<LeadEntity> listarAtivos();

	@Query("select new com.stellato.vendas.domain.lead.entity.LeadEntity(l.id,l.codigo,l.nome,l.telefone,l.whatsapp,"
			+ "l.email,l.cidade, l.origem, l.tipoLead,l.idPessoa,l.status, l.criadoEm,l.criadoPor,l.alteradoEm, l.alteradoPor)"
			+ " from LeadModel l where l.status =1")
	public Page<LeadEntity> listarAtivos(Pageable pageable );

	@Query("select new com.stellato.vendas.domain.lead.entity.LeadEntity(l.id,l.codigo,l.nome,l.telefone,l.whatsapp,"
			+ "l.email,l.cidade, l.origem, l.tipoLead,l.idPessoa,l.status, l.criadoEm,l.criadoPor,l.alteradoEm, l.alteradoPor)"
			+ " from LeadModel l where l.status =1 and upper(l.nome) like :nome")
	public Page<LeadEntity> listarPorNome(String nome, Pageable pageable);
}