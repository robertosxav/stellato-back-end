package com.stellato.administrador.infrastructure.material.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.administrador.domain.material.entity.MaterialEntity;
import com.stellato.administrador.domain.material.factory.MaterialEntityFactory;
import com.stellato.administrador.domain.shared.repository.RepositoryInterface;
import com.stellato.administrador.exceptions.StellatoException;
import com.stellato.administrador.infrastructure.material.MaterialModel;
import com.stellato.administrador.infrastructure.material.factory.MaterialFactory;
import com.stellato.administrador.infrastructure.material.repository.MaterialRepository;

import jakarta.transaction.Transactional;

@Service
public class MaterialService implements RepositoryInterface<MaterialEntity>{

	@Autowired
	private MaterialRepository materialRepository;
	
	@Autowired
	private MaterialFactory factory; 
	
	@Autowired
	private MaterialEntityFactory entityFactory;
	
	@Override
	@Transactional
	public MaterialEntity create(MaterialEntity MaterialEntityFront){
	
		if (MaterialEntityFront.validar()) {
			MaterialEntityFront.Ativar();
			MaterialModel MaterialModel = factory.create(MaterialEntityFront);
			
			materialRepository.save(MaterialModel);
			
			MaterialEntityFront.SetId(MaterialModel.getId());
		
			return MaterialEntityFront;
		}
		return null;
	}

	@Override
	@Transactional
	public MaterialEntity update(Long id, MaterialEntity MaterialEntityFront){
			
			MaterialEntityFront.Alterar(null);
			
			Optional<MaterialModel> MaterialModelBanco = materialRepository.findById(id);
			MaterialEntityFront.SetId(id);
			MaterialModelBanco.get().setDescricao(MaterialEntityFront.getDescricao());
			MaterialModelBanco.get().setTipo(MaterialEntityFront.getTipo().getNumero());
			MaterialModelBanco.get().setStatus(MaterialEntityFront.getStatus().getNumero());
			MaterialModelBanco.get().setCriadoEm(MaterialEntityFront.getCriadoEm());
			MaterialModelBanco.get().setCriadoPor(MaterialEntityFront.getCriadoPor());
			MaterialModelBanco.get().setAlteradoEm(MaterialEntityFront.getAlteradoEm());
			MaterialModelBanco.get().setAlteradoPor(MaterialEntityFront.getAlteradoPor());
			materialRepository.save(MaterialModelBanco.get());
			
		return MaterialEntityFront;


	}

	@Override
	public MaterialEntity findById(Long id) {
		Optional<MaterialModel> MaterialModelSave = materialRepository.findById(id);
		
		 if (!MaterialModelSave.isPresent()) {
			 throw new StellatoException("Não foi encontrado nenhum material com o código: " + id);
		 }
		MaterialEntity MaterialEntity	=	entityFactory.create(MaterialModelSave.get());
		return MaterialEntity;

	}

	@Override
	public List<MaterialEntity> findAll(){
		
		List<MaterialEntity> listaMaterialEntity = materialRepository.listarTodos();
		
		if (listaMaterialEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum material cadastrado"); 
		}
		
		return listaMaterialEntity;
		
	}
	
	@Override
	public List<MaterialEntity> findAllActives(){
		
		List<MaterialEntity> listaMaterialEntity = materialRepository.listarAtivos();
		
		if (listaMaterialEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum material ativo"); 
		}
	
		return listaMaterialEntity;
				//listaMaterialModel.stream().map(e->(entityFactory.create(e))).collect(Collectors.toList());
	}
	
	@Override
	public Page<MaterialEntity> findAllActivesPage(Pageable pageable) {
		Page<MaterialEntity> listaMaterialEntity = materialRepository.listarAtivos(pageable);
		return listaMaterialEntity;
	}
	
	public Page<MaterialEntity> findByDescricao(String descricao, Pageable pageable) {
		String descricaoAux = "%"+descricao.toUpperCase() +"%";
		Page<MaterialEntity> listaMaterialEntity =materialRepository.listarPorDescricao(descricaoAux, pageable);
		return listaMaterialEntity;
	}
	
	
	public void delete(Long id) {
		MaterialEntity MaterialEntityBanco = findById(id);
		MaterialEntityBanco.Inativar();	
		MaterialModel MaterialModel	= factory.create(MaterialEntityBanco);
		materialRepository.save(MaterialModel);
		
	}

}
