package com.stellato.vendas.infrastructure.orcamento.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.infrastructure.lead.LeadModel;
import com.stellato.vendas.infrastructure.lead.factory.LeadFactory;
import com.stellato.vendas.infrastructure.orcamento.OrcamentoEletricoModel;



@Component
public class OrcamentoFactory {
	
	@Autowired
	private LeadFactory factory; 
	
	public OrcamentoEletricoModel create (OrcamentoEletricoEntity orcamentoEletricoEntity) {	
		
		LeadModel leadModel = factory.create(orcamentoEletricoEntity.getLead());
		
		OrcamentoEletricoModel orcamentoEletricoModel = new OrcamentoEletricoModel(orcamentoEletricoEntity.getId(),orcamentoEletricoEntity.getCodigo(),orcamentoEletricoEntity.getTitulo(),orcamentoEletricoEntity.getObservacao(),
				orcamentoEletricoEntity.getObservacaoInterna(),orcamentoEletricoEntity.getValidadeProposta(),orcamentoEletricoEntity.getPrazoEntrega(),orcamentoEletricoEntity.getDistancia(),
				orcamentoEletricoEntity.getPotenciaModulo(),orcamentoEletricoEntity.getPercentualPerda(),orcamentoEletricoEntity.getDetalheProposta(),orcamentoEletricoEntity.getModalidadeTarifaria(),
				orcamentoEletricoEntity.getTipoPadrao().getNumero(),orcamentoEletricoEntity.getUnidadeConsumidora(),orcamentoEletricoEntity.getConsumoMedio(),orcamentoEletricoEntity.getPrecoKwh(), 
				orcamentoEletricoEntity.getTipoInstalacao().getNumero(),orcamentoEletricoEntity.getTipoEstrutura().getNumero(),leadModel,orcamentoEletricoEntity.getStatus().getNumero(),
				orcamentoEletricoEntity.getCriadoEm(), orcamentoEletricoEntity.getCriadoPor(), orcamentoEletricoEntity.getAlteradoEm(), orcamentoEletricoEntity.getAlteradoPor());
		
		return orcamentoEletricoModel;
	}
}
