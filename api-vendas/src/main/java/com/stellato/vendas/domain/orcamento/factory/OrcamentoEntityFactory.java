package com.stellato.vendas.domain.orcamento.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.domain.lead.factory.LeadEntityFactory;
import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.infrastructure.orcamento.OrcamentoEletricoModel;

@Component
public class OrcamentoEntityFactory {
	
	@Autowired
	private LeadEntityFactory factory; 
	
	public OrcamentoEletricoEntity create(OrcamentoEletricoModel orcamentoEletricoModel) {
		
		LeadEntity leadEntity = factory.create(orcamentoEletricoModel.getLead());
		
		OrcamentoEletricoEntity orcamentoCotadoEntity = new OrcamentoEletricoEntity(orcamentoEletricoModel.getId(),orcamentoEletricoModel.getCodigo(),orcamentoEletricoModel.getTitulo(),orcamentoEletricoModel.getObservacao(),
				orcamentoEletricoModel.getObservacaoInterna(),orcamentoEletricoModel.getValidadeProposta(),orcamentoEletricoModel.getPrazoEntrega(),orcamentoEletricoModel.getDistancia(),
				orcamentoEletricoModel.getPotenciaModulo(),orcamentoEletricoModel.getPercentualPerda(),orcamentoEletricoModel.getDetalheProposta(),orcamentoEletricoModel.getModalidadeTarifaria(),
				orcamentoEletricoModel.getTipoPadrao(),orcamentoEletricoModel.getUnidadeConsumidora(),orcamentoEletricoModel.getConsumoMedio(),orcamentoEletricoModel.getPrecoKwh(), 
				orcamentoEletricoModel.getTipoInstalacao(),orcamentoEletricoModel.getTipoEstrutura(),leadEntity,orcamentoEletricoModel.getStatus(), 
				orcamentoEletricoModel.getCriadoEm(), orcamentoEletricoModel.getCriadoPor(),orcamentoEletricoModel.getAlteradoEm(), orcamentoEletricoModel.getAlteradoPor());

		return orcamentoCotadoEntity;
	}

}
