package com.stellato.vendas.infrastructure.lead.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.domain.lead.factory.LeadEntityFactory;
import com.stellato.vendas.domain.shared.repository.RepositoryInterface;
import com.stellato.vendas.exceptions.StellatoException;
import com.stellato.vendas.infrastructure.lead.LeadModel;
import com.stellato.vendas.infrastructure.lead.factory.LeadFactory;
import com.stellato.vendas.infrastructure.lead.repository.LeadRepository;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


@Service
public class LeadService implements RepositoryInterface<LeadEntity>{

	@Autowired
	private LeadRepository leadRepository;
	
	@Autowired
	private LeadFactory factory; 
	
	@Autowired
	private LeadEntityFactory entityFactory;
	
	@Override
	@Transactional
	public LeadEntity create(LeadEntity leadEntityFront){
	
		if (leadEntityFront.validar()) {
			leadEntityFront.Ativar();
			LeadModel leadModel = factory.create(leadEntityFront);
			
			leadRepository.save(leadModel);
			
			leadEntityFront.SetId(leadModel.getId());
		
			return leadEntityFront;
		}
		return null;
	}

	@Override
	@Transactional
	public LeadEntity update(Long id, LeadEntity leadEntityFront){
			
			leadEntityFront.Alterar(null);
			
			LeadModel leadModelBanco = leadRepository
					.findById(id)
					.orElseThrow(()-> new StellatoException("Não foi encontrado nenhum lead com o código: " + id));
			
			leadEntityFront.SetId(id);
			
			leadModelBanco.setId(leadEntityFront.getId());
			leadModelBanco.setNome(leadEntityFront.getNome());
			leadModelBanco.setTelefone(leadEntityFront.getTelefone());
			leadModelBanco.setWhatsApp(leadEntityFront.getWhatsApp());
			leadModelBanco.setCidade(leadEntityFront.getCidade());
			leadModelBanco.setOrigem(leadEntityFront.getOrigem().getNumero());
			leadModelBanco.setTipoLead(leadEntityFront.getTipoLead().getNumero());
			leadModelBanco.setIdPessoa(leadEntityFront.getIdPessoa());
			leadModelBanco.setStatus(leadEntityFront.getStatus().getNumero());
			leadModelBanco.setCriadoEm(leadEntityFront.getCriadoEm());
			leadModelBanco.setCriadoPor(leadEntityFront.getCriadoPor());
			leadModelBanco.setAlteradoEm(leadEntityFront.getAlteradoEm());
			leadModelBanco.setAlteradoPor(leadEntityFront.getAlteradoPor());
			leadRepository.save(leadModelBanco);
			
		return leadEntityFront;


	}

	@Override
	public LeadEntity findById(Long id) {
		LeadModel leadModelSave = leadRepository
				.findById(id)
				.orElseThrow(()-> new StellatoException("Não foi encontrado nenhum lead com o código: " + id));
		
		LeadEntity leadEntity	=	entityFactory.create(leadModelSave);
		return leadEntity;


	}

	@Override
	public List<LeadEntity> findAll(){
		
		List<LeadEntity> listaLeadEntity = leadRepository.listarTodos();
		
		if (listaLeadEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead cadastrado"); 
		}
		
		return listaLeadEntity;
		
	}
	
	@Override
	public List<LeadEntity> findAllActives(){
		
		List<LeadEntity> listaLeadEntity = leadRepository.listarAtivos();
		
		if (listaLeadEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead ativo"); 
		}
	
		return listaLeadEntity;
	}
	
	@Override
	public Page<LeadEntity> findAllActivesPage(Pageable pageable) {
		Page<LeadEntity> listaLeadEntity = leadRepository.listarAtivos(pageable);
		return listaLeadEntity;
	}
	
	public Page<LeadEntity> findByName(String nome, Pageable pageable) {
		String nomeAux = "%"+nome.toUpperCase() +"%";
		Page<LeadEntity> listaLeadEntity =leadRepository.listarPorNome(nomeAux, pageable);
		return listaLeadEntity;
	}
	
	
	public void deleteLead(Long id) {
		LeadEntity leadEntityBanco = findById(id);
		leadEntityBanco.Inativar();	
		LeadModel leadModel	= factory.create(leadEntityBanco);
		leadRepository.save(leadModel);
		
	}

}
