package com.stellato.vendas.infrastructure.lead.factory;

import org.springframework.stereotype.Component;

import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.infrastructure.lead.LeadModel;

@Component
public class LeadFactory {
	
	public LeadModel create (LeadEntity leadEntity) {		
		LeadModel leadModel = new LeadModel(leadEntity.getId(),leadEntity.getNome(),leadEntity.getTelefone(),leadEntity.getWhatsApp(),
				leadEntity.getEmail(), leadEntity.getCidade(),leadEntity.getOrigem(),leadEntity.getTipoLead(), leadEntity.getidPessoa(), 
				leadEntity.getStatus().getNumero(),leadEntity.getCriadoEm(), leadEntity.getCriadoPor(), leadEntity.getAlteradoEm(), leadEntity.getAlteradoPor());
		
		return leadModel;
	}
}
