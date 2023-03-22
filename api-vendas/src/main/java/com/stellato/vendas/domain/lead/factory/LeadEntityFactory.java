package com.stellato.vendas.domain.lead.factory;

import org.springframework.stereotype.Component;

import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.infrastructure.lead.LeadModel;

@Component
public class LeadEntityFactory {
	
	public LeadEntity create (LeadModel leadModel) {		
		
		LeadEntity leadEntity = new LeadEntity(leadModel.getId(),leadModel.getNome(),
				leadModel.getTelefone(),leadModel.getwhatsapp(), leadModel.getEmail(),
				leadModel.getCidade(),leadModel.getOrigem(),leadModel.getTipoLead(),
				leadModel.getidPessoa(),leadModel.getStatus(), leadModel.getCriadoEm(),
				leadModel.getCriadoPor(), leadModel.getAlteradoEm(),leadModel.getAlteradoPor());
		
		return leadEntity;
	}
}
