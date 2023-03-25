package com.stellato.administrador.infrastructure.pessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.administrador.domain.pessoa.entity.PessoaEntity;
import com.stellato.administrador.domain.pessoa.factory.PessoaEntityFactory;
import com.stellato.administrador.domain.shared.repository.RepositoryInterface;
import com.stellato.administrador.exceptions.StellatoException;
import com.stellato.administrador.infrastructure.pessoa.PessoaModel;
import com.stellato.administrador.infrastructure.pessoa.factory.PessoaFactory;
import com.stellato.administrador.infrastructure.pessoa.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class PessoaService implements RepositoryInterface<PessoaEntity>{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaFactory factory; 
	
	@Autowired
	private PessoaEntityFactory entityFactory;
	
	@Override
	@Transactional
	public PessoaEntity create(PessoaEntity pessoaEntityFront){
	
		if (pessoaEntityFront.validar()) {
			pessoaEntityFront.Ativar();
			PessoaModel leadModel = factory.create(pessoaEntityFront);
			
			pessoaRepository.save(leadModel);
			
			pessoaEntityFront.SetId(leadModel.getId());
		
			return pessoaEntityFront;
		}
		return null;
	}

	@Override
	@Transactional
	public PessoaEntity update(Long id, PessoaEntity pessoaEntityFront){
			
			pessoaEntityFront.Alterar(null);
			
			Optional<PessoaModel> leadModelBanco = pessoaRepository.findById(id);
			
			pessoaEntityFront.SetId(id);
			
			leadModelBanco.get().setNome(pessoaEntityFront.getNome());
			leadModelBanco.get().setNome(pessoaEntityFront.getCpf());
			leadModelBanco.get().setNome(pessoaEntityFront.getNomeFantasia());
			leadModelBanco.get().setNome(pessoaEntityFront.getCnpj());
			leadModelBanco.get().setTelefone(pessoaEntityFront.getTelefone());
			leadModelBanco.get().setWhatsapp(pessoaEntityFront.getWhatsApp());
			leadModelBanco.get().setStatus(pessoaEntityFront.getStatus().getNumero());
			leadModelBanco.get().setCriadoEm(pessoaEntityFront.getCriadoEm());
			leadModelBanco.get().setCriadoPor(pessoaEntityFront.getCriadoPor());
			leadModelBanco.get().setAlteradoEm(pessoaEntityFront.getAlteradoEm());
			leadModelBanco.get().setAlteradoPor(pessoaEntityFront.getAlteradoPor());
			pessoaRepository.save(leadModelBanco.get());
			
		return pessoaEntityFront;


	}

	@Override
	public PessoaEntity findById(Long id) {
		Optional<PessoaModel> leadModelSave = pessoaRepository.findById(id);
		
		 if (!leadModelSave.isPresent()) {
			 throw new StellatoException("Não foi encontrado nenhum lead com o código: " + id);
		 }
		PessoaEntity leadEntity	=	entityFactory.create(leadModelSave.get());
		return leadEntity;

	}

	@Override
	public List<PessoaEntity> findAll(){
		
		List<PessoaEntity> listaPessoaEntity = pessoaRepository.listarTodos();
		
		if (listaPessoaEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead cadastrado"); 
		}
		
		return listaPessoaEntity;
		
	}
	
	@Override
	public List<PessoaEntity> findAllActives(){
		
		List<PessoaEntity> listaPessoaEntity = pessoaRepository.listarAtivos();
		
		if (listaPessoaEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead ativo"); 
		}
	
		return listaPessoaEntity;
	
	}
	
	@Override
	public Page<PessoaEntity> findAllActivesPage(Pageable pageable) {
		Page<PessoaEntity> listaPessoaEntity = pessoaRepository.listarAtivos(pageable);
		return listaPessoaEntity;
	}
	
	public Page<PessoaEntity> findByName(String nome, Pageable pageable) {
		String nomeAux = "%"+nome.toUpperCase() +"%";
		Page<PessoaEntity> listaPessoaEntity = pessoaRepository.listarPorNome(nomeAux, pageable);
		return listaPessoaEntity;
	}
	
	
	public void deletePessoa(Long id) {
		PessoaEntity leadEntityBanco = findById(id);
		leadEntityBanco.Inativar();	
		PessoaModel leadModel	= factory.create(leadEntityBanco);
		pessoaRepository.save(leadModel);
		
	}

}
