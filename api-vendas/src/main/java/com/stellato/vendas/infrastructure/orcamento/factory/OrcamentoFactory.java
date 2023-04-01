package com.stellato.vendas.infrastructure.orcamento.factory;

import org.springframework.stereotype.Component;

import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.infrastructure.orcamento.OrcamentoEletricoModel;



@Component
public class OrcamentoFactory {
	
	public OrcamentoEletricoModel create (OrcamentoEletricoEntity orcamentoEletricoEntity) {		
		OrcamentoEletricoModel materialCotadoModel = new OrcamentoEletricoModel(orcamentoEletricoEntity.getId(),orcamentoEletricoEntity.getCodigo(),orcamentoEletricoEntity.getTitulo(),orcamentoEletricoEntity.getObservacao(),
				orcamentoEletricoEntity.getObservacaoInterna(),orcamentoEletricoEntity.getValidadeProposta(),orcamentoEletricoEntity.getPrazoEntrega(),orcamentoEletricoEntity.getDistancia(),
				orcamentoEletricoEntity.getPotenciaModulo(),orcamentoEletricoEntity.getPercentualPerda(),orcamentoEletricoEntity.getDetalheProposta(),orcamentoEletricoEntity.getModalidadeTarifaria(),
				orcamentoEletricoEntity.getTipoPadrao().getNumero(),orcamentoEletricoEntity.getUnidadeConsumidora(),orcamentoEletricoEntity.getConsumoMedio(),orcamentoEletricoEntity.getPrecoKwh(), 
				orcamentoEletricoEntity.getTipoInstalacao().getNumero(),orcamentoEletricoEntity.getTipoEstrutura().getNumero(),orcamentoEletricoEntity.getIdLead(),orcamentoEletricoEntity.getStatus().getNumero(),
				orcamentoEletricoEntity.getCriadoEm(), orcamentoEletricoEntity.getCriadoPor(), orcamentoEletricoEntity.getAlteradoEm(), orcamentoEletricoEntity.getAlteradoPor());
		
		return materialCotadoModel;
	}
}
