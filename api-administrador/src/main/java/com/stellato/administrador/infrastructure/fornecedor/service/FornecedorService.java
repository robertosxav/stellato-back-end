package com.stellato.administrador.infrastructure.fornecedor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.administrador.domain.fornecedor.entity.FornecedorEntity;
import com.stellato.administrador.domain.fornecedor.factory.FornecedorEntityFactory;
import com.stellato.administrador.domain.shared.repository.RepositoryInterface;
import com.stellato.administrador.exceptions.StellatoException;
import com.stellato.administrador.infrastructure.fornecedor.FornecedorModel;
import com.stellato.administrador.infrastructure.fornecedor.repository.FornecedorRepository;
import com.stellato.administrador.infrastructure.fornecedor.factory.FornecedorFactory;

import jakarta.transaction.Transactional;

@Service
public class FornecedorService implements RepositoryInterface<FornecedorEntity>{

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private FornecedorFactory factory; 
	
	@Autowired
	private FornecedorEntityFactory entityFactory;
	
	@Override
	@Transactional
	public FornecedorEntity create(FornecedorEntity fornecedorEntityFront){
	
		if (fornecedorEntityFront.validar()) {
			fornecedorEntityFront.Ativar();
			FornecedorModel fornecedorModel = factory.create(fornecedorEntityFront);
			
			fornecedorRepository.save(fornecedorModel);
			
			fornecedorEntityFront.SetId(fornecedorModel.getId());
		
			return fornecedorEntityFront;
		}
		return null;
	}

	@Override
	@Transactional
	public FornecedorEntity update(Long id, FornecedorEntity fornecedorEntityFront){
			
			fornecedorEntityFront.Alterar(null);
			
			Optional<FornecedorModel> fornecedorModelBanco = fornecedorRepository.findById(id);
			
			fornecedorEntityFront.SetId(id);
			
			fornecedorModelBanco.get().setRazaoSocial(fornecedorEntityFront.getRazaoSocial());
			fornecedorModelBanco.get().setCnpj(fornecedorEntityFront.getCnpj());;
			fornecedorModelBanco.get().setStatus(fornecedorEntityFront.getStatus().getNumero());
			fornecedorModelBanco.get().setCriadoEm(fornecedorEntityFront.getCriadoEm());
			fornecedorModelBanco.get().setCriadoPor(fornecedorEntityFront.getCriadoPor());
			fornecedorModelBanco.get().setAlteradoEm(fornecedorEntityFront.getAlteradoEm());
			fornecedorModelBanco.get().setAlteradoPor(fornecedorEntityFront.getAlteradoPor());
			fornecedorRepository.save(fornecedorModelBanco.get());
			
		return fornecedorEntityFront;


	}

	@Override
	public FornecedorEntity findById(Long id) {
		Optional<FornecedorModel> fornecedorModelSave = fornecedorRepository.findById(id);
		
		 if (!fornecedorModelSave.isPresent()) {
			 throw new StellatoException("Não foi encontrado nenhum lead com o código: " + id);
		 }
		FornecedorEntity leadEntity	=	entityFactory.create(fornecedorModelSave.get());
		return leadEntity;

	}

	@Override
	public List<FornecedorEntity> findAll(){
		
		List<FornecedorEntity> listaFornecedorEntity = fornecedorRepository.listarTodos();
		
		if (listaFornecedorEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead cadastrado"); 
		}
		
		return listaFornecedorEntity;
		
	}
	
	@Override
	public List<FornecedorEntity> findAllActives(){
		
		List<FornecedorEntity> listaFornecedorEntity = fornecedorRepository.listarAtivos();
		
		if (listaFornecedorEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead ativo"); 
		}
	
		return listaFornecedorEntity;
	
	}
	
	@Override
	public Page<FornecedorEntity> findAllActivesPage(Pageable pageable) {
		Page<FornecedorEntity> listaFornecedorEntity = fornecedorRepository.listarAtivos(pageable);
		return listaFornecedorEntity;
	}
	
	public Page<FornecedorEntity> findByRazaoSocial(String razaoSocial, Pageable pageable) {
		String razaoSocialAux = "%"+razaoSocial.toUpperCase() +"%";
		Page<FornecedorEntity> listaFornecedorEntity = fornecedorRepository.listarPorRazaoSocial(razaoSocialAux, pageable);
		return listaFornecedorEntity;
	}
	
	
	public void deleteFornecedor(Long id) {
		FornecedorEntity leadEntityBanco = findById(id);
		leadEntityBanco.Inativar();	
		FornecedorModel fornecedorModel	= factory.create(leadEntityBanco);
		fornecedorRepository.save(fornecedorModel);
		
	}

}
