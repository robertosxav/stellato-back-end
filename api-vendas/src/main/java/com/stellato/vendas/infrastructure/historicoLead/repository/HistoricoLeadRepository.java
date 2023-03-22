package com.stellato.vendas.infrastructure.historicoLead.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoLeadRepository /*extends JpaRepository<HistoricoLeadModel, BigDecimal>*/{
	
	/*@Query("select new com.stellato.vendas.domain.lead.entity.HistoricoLeadEntity(h.id,h.descricao,h.data,h.lead,"
			+ " h.status)"
			+ " from HistoricoLeadModel h where l.id = :id")
	public Optional<HistoricoLeadEntity> buscarPorId(BigDecimal id);
	
	@Query("select new com.stellato.vendas.domain.lead.entity.HistoricoLeadEntity(h.id,h.descricao,h.data,h.lead,"
			+ " h.status)"
			+ " from HistoricoLeadModel ")
	public List<HistoricoLeadEntity> listarTodos();
*/
}
