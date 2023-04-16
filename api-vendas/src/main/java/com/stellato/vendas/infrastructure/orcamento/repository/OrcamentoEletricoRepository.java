package com.stellato.vendas.infrastructure.orcamento.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.infrastructure.orcamento.OrcamentoEletricoModel;

@Repository
public interface OrcamentoEletricoRepository extends JpaRepository<OrcamentoEletricoModel, Long>{

	@Query("select new com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity(o.id,o.codigo,o.titulo,"
			+ "o.observacao,o.observacaoInterna,o.validadeProposta,o.prazoEntrega,o.distancia,o.potenciaModulo,"
			+ "o.percentualPerda,o.detalheProposta,o.modalidadeTarifaria,o.tipoPadrao,o.unidadeConsumidora,o.consumoMedio,"
			+ "o.precoKwh,o.tipoInstalacao,o.tipoEstrutura,o.lead.id,o.lead.nome,o.lead.telefone,o.lead.email,o.lead.whatsApp,"
			+ "o.status,o.criadoEm,o.criadoPor,o.alteradoEm,o.alteradoPor)"
			+ " from OrcamentoEletricoModel o")
	public List<OrcamentoEletricoEntity> listarTodos();

	@Query("select new com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity(o.id,o.codigo,o.titulo,"
			+ "o.observacao,o.observacaoInterna,o.validadeProposta,o.prazoEntrega,o.distancia,o.potenciaModulo,"
			+ "o.percentualPerda,o.detalheProposta,o.modalidadeTarifaria,o.tipoPadrao,o.unidadeConsumidora,o.consumoMedio,"
			+ "o.precoKwh,o.tipoInstalacao,o.tipoEstrutura,o.lead.id,o.lead.nome,o.lead.telefone,o.lead.email,o.lead.whatsApp,"
			+ "o.status,o.criadoEm,o.criadoPor,o.alteradoEm,o.alteradoPor)"
			+ " from OrcamentoEletricoModel o where o.status =1")
	public List<OrcamentoEletricoEntity> listarAtivos();

	@Query("select new com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity(o.id,o.codigo,o.titulo,"
			+ "o.observacao,o.observacaoInterna,o.validadeProposta,o.prazoEntrega,o.distancia,o.potenciaModulo,"
			+ "o.percentualPerda,o.detalheProposta,o.modalidadeTarifaria,o.tipoPadrao,o.unidadeConsumidora,o.consumoMedio,"
			+ "o.precoKwh,o.tipoInstalacao,o.tipoEstrutura,o.lead.id,o.lead.nome,o.lead.telefone,o.lead.email,o.lead.whatsApp,"
			+ "o.status,o.criadoEm,o.criadoPor,o.alteradoEm,o.alteradoPor)"
			+ " from OrcamentoEletricoModel o where o.status =1")
	public Page<OrcamentoEletricoEntity> listarAtivos(Pageable pageable );
	
	@Query("select new com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity(o.id,o.codigo,o.titulo,"
			+ "o.observacao,o.observacaoInterna,o.validadeProposta,o.prazoEntrega,o.distancia,o.potenciaModulo,"
			+ "o.percentualPerda,o.detalheProposta,o.modalidadeTarifaria,o.tipoPadrao,o.unidadeConsumidora,o.consumoMedio,"
			+ "o.precoKwh,o.tipoInstalacao,o.tipoEstrutura,o.lead.id,o.lead.nome,o.lead.telefone,o.lead.email,o.lead.whatsApp,"
			+ "o.status,o.criadoEm,o.criadoPor,o.alteradoEm,o.alteradoPor)"
			+ " from OrcamentoEletricoModel o where o.status =1 and o.lead.id = :idLead")
	public List<OrcamentoEletricoEntity> listarPorLead(Long idLead);
	
	
	@Query("select new com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity(o.id,o.codigo,o.titulo,"
			+ "o.observacao,o.observacaoInterna,o.validadeProposta,o.prazoEntrega,o.distancia,o.potenciaModulo,"
			+ "o.percentualPerda,o.detalheProposta,o.modalidadeTarifaria,o.tipoPadrao,o.unidadeConsumidora,o.consumoMedio,"
			+ "o.precoKwh,o.tipoInstalacao,o.tipoEstrutura,o.lead.id,o.lead.nome,o.lead.telefone,o.lead.email,o.lead.whatsApp,"
			+ "o.status,o.criadoEm,o.criadoPor,o.alteradoEm,o.alteradoPor)"
			+ " from OrcamentoEletricoModel o where o.status =1 and o.lead.id = :idLead")
	public Page<OrcamentoEletricoEntity> listarPorLead(Long idLead,Pageable pageable);
	
	@Query("select o from OrcamentoEletricoModel o")
	public List<OrcamentoEletricoModel> teste();
}

/*
"
+ "o.percentualPerda,o.detalheProposta,o.modalidadeTarifaria,o.tipoPadrao,o.unidadeConsumidora,o.consumoMedio,"
+ "o.precoKwh,o.tipoInstalacao,o.tipoEstrutura,
*/