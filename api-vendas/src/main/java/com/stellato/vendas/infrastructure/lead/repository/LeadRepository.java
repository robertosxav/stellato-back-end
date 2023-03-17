package com.stellato.vendas.infrastructure.lead.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
  
import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.infrastructure.lead.LeadModel;

@Repository
public interface LeadRepository extends JpaRepository<LeadModel, BigDecimal>{

	@Query("select new com.stellato.vendas.domain.lead.entity.LeadEntity(l.id,l.nome,l.email,l.telefone,l.consumo,l.cidade,l.tipoTelha,l.origem) from LeadModel l where l.id = :id")
	public Optional<LeadEntity> buscarPorId(BigDecimal id);
	
	@Query("select new com.stellato.vendas.domain.lead.entity.LeadEntity(l.id,l.nome,l.email,l.telefone,l.consumo,l.cidade,l.tipoTelha,l.origem) from LeadModel l")
	public List<LeadEntity> listarTodos();
}
