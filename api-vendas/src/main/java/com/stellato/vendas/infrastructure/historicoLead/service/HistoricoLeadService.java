package com.stellato.vendas.infrastructure.historicoLead.service;

import org.springframework.stereotype.Service;

@Service
public class HistoricoLeadService/* implements RepositoryInterface<HistoricoLeadEntity>*/{
	
	/*@Autowired
	private HistoricoLeadRepository histLeadRepository;
	
	@Override
	public HistoricoLeadEntity create(HistoricoLeadEntity histLeadEntityFront) {
		
		if (histLeadEntityFront.validar()) {
			histLeadEntityFront.Ativar();
			
			/*LeadModel leadModel = new LeadModel(leadEntityFront.getNome(), leadEntityFront.getEmail(), 
					leadEntityFront.getTelefone(), leadEntityFront.getConsumo(), leadEntityFront.getCidade(),
					leadEntityFront.getTipoTelha().getNumero(), leadEntityFront.getOrigem().getNumero(), 
					leadEntityFront.getStatus().getNumero());*/
			
		//	HistoricoLeadModel histLeadModel= new HistoricoLeadModel(histLeadEntityFront.getDecricao(),histLeadEntityFront.getData(),histLeadEntityFront.getStatus(), histLeadEntityFront.getLead());
			
		//	histLeadRepository.save(histLeadModel);
			
		//	histLeadEntityFront.SetId(histLeadModel.getId());
		
		//	return histLeadEntityFront;
	/*	}
		return null;
	}

	@Override
	public HistoricoLeadEntity update(BigDecimal id, LeadEntity leadEntityFront) {
		return null;
	}

	@Override
	public HistoricoLeadEntity findById(BigDecimal id) {
		
		Optional<HistoricoLeadEntity> histLeadEntitySave= histLeadRepository.buscarPorId(id);
		
		 if (!histLeadEntitySave.isPresent()) {
			 throw new StellatoException("Não foi encontrado nenhum histórico para o lead com o código: " + id.toBigInteger());
		 }
		 
		return histLeadEntitySave.get();
	}

	@Override
	public List<HistoricoLeadEntity> findAll() {
	
		List<HistoricoLeadEntity> listaHistLeadEntity =  histLeadRepository.listarTodos();
		
		if (listaHistLeadEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum hsitorico cadastrado"); 
		}
	
		return listaHistLeadEntity;
	}
	
	
	public void delete(BigDecimal id) {
		HistoricoLeadEntity histLeadEntityBanco = findById(id);
		
		histLeadEntityBanco.Inativar();
		
		/*LeadModel leadModel = new LeadModel(leadEntityBanco.getId(),leadEntityBanco.getNome(), leadEntityBanco.getEmail(), leadEntityBanco.getTelefone(), 
				leadEntityBanco.getConsumo(), leadEntityBanco.getCidade(), leadEntityBanco.getTipoTelha().getNumero(), leadEntityBanco.getOrigem().getNumero(), leadEntityBanco.getStatus().getNumero());
		leadRepository.save(leadModel);
		*/
	//}
	

}
