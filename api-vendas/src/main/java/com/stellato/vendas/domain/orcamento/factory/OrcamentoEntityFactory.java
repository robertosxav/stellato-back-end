package com.stellato.vendas.domain.orcamento.factory;

import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.infrastructure.orcamento.OrcamentoEletricoModel;

public class OrcamentoEntityFactory {

	public OrcamentoEletricoEntity create(OrcamentoEletricoModel orcamentoEletricoModel) {

		OrcamentoEletricoEntity orcamentoCotadoEntity = new OrcamentoEletricoEntity(orcamentoEletricoModel.getId(),orcamentoEletricoModel.getTitulo(),orcamentoEletricoModel.getObservacao(),
				orcamentoEletricoModel.getObservacaoInterna(),orcamentoEletricoModel.getValidadeProposta(),orcamentoEletricoModel.getPrazoEntrega(),orcamentoEletricoModel.getDistancia(),
				orcamentoEletricoModel.getPotenciaModulo(),orcamentoEletricoModel.getPercentualPerda(),orcamentoEletricoModel.getDetalheProposta(),orcamentoEletricoModel.getModalidadeTarifaria(),
				orcamentoEletricoModel.getTipoPadrao(),orcamentoEletricoModel.getUnidadeConsumidora(),orcamentoEletricoModel.getConsumoMedio(),orcamentoEletricoModel.getPrecoKwh(), 
				orcamentoEletricoModel.getTipoInstalacao(),orcamentoEletricoModel.getTipoEstrutura(),orcamentoEletricoModel.getIdLead(),orcamentoEletricoModel.getStatus(), 
				orcamentoEletricoModel.getCriadoEm(), orcamentoEletricoModel.getCriadoPor(),orcamentoEletricoModel.getAlteradoEm(), orcamentoEletricoModel.getAlteradoPor());

		return orcamentoCotadoEntity;
	}

}
