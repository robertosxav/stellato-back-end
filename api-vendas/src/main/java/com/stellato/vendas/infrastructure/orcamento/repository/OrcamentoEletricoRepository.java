package com.stellato.vendas.infrastructure.orcamento.repository;

import java.util.List;

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
			+ "o.precoKwh,o.tipoInstalacao,o.tipoEstrutura,o.status,o.criadoEm,o.criadoPor,o.alteradoEm,o.alteradoPor)"
			+ " from OrcamentoEletricoModel o")
	public List<OrcamentoEletricoEntity> listarTodos();
	
	@Query("select o from OrcamentoEletricoModel o")
	public List<OrcamentoEletricoModel> teste();
	
//	public List<OrcamentoEletricoEntity> listarAtivos();

	//public Page<OrcamentoEletricoEntity> listarAtivos(Pageable pageable );

}

/*
"
+ "o.percentualPerda,o.detalheProposta,o.modalidadeTarifaria,o.tipoPadrao,o.unidadeConsumidora,o.consumoMedio,"
+ "o.precoKwh,o.tipoInstalacao,o.tipoEstrutura,
*/