package com.stellato.vendas.infrastructure.materialCotado.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;
import com.stellato.vendas.domain.materialCotado.factory.MaterialCotadoEntityFactory;
import com.stellato.vendas.domain.shared.repository.RepositoryInterface;
import com.stellato.vendas.exceptions.StellatoException;
import com.stellato.vendas.infrastructure.materialCotado.factory.MaterialCotadoFactory;
import com.stellato.vendas.infrastructure.materialCotado.model.MaterialCotadoModel;
import com.stellato.vendas.infrastructure.materialCotado.repository.MaterialCotadoRepository;
import com.stellato.vendas.infrastructure.materialCotado.service.grpc.GrpcMaterialRequestImpl;

@Service
public class MaterialCotadoService implements RepositoryInterface<MaterialCotadoEntity> {

	@Autowired
	private MaterialCotadoRepository materialCotadoRepository;

	@Autowired
	private MaterialCotadoFactory factory;

	@Autowired
	private MaterialCotadoEntityFactory entityFactory;

	@Autowired
	private GrpcMaterialRequestImpl materialRequestImpl;

	@Override
	@Transactional
	public MaterialCotadoEntity create(MaterialCotadoEntity materialCotadoEntityFront) {
		materialCotadoEntityFront = materialRequestImpl.verificaMaterial(materialCotadoEntityFront);
		materialCotadoEntityFront = materialRequestImpl.verificaFornecedor(materialCotadoEntityFront);

		if (materialCotadoEntityFront.validar()) {
			materialCotadoEntityFront.Ativar();
			MaterialCotadoModel materialCotadoModel = factory.create(materialCotadoEntityFront);

			materialCotadoRepository.save(materialCotadoModel);

			materialCotadoEntityFront.SetId(materialCotadoModel.getId());

		}
		return materialCotadoEntityFront;
	}

	@Override
	@Transactional
	public MaterialCotadoEntity update(Long id, MaterialCotadoEntity materialCotadoEntityFront) {

		materialCotadoEntityFront.Alterar(null);

		MaterialCotadoModel materialCotadoModelBanco = materialCotadoRepository
				.findById(id).orElseThrow(()->new StellatoException("Não foi encontrado nenhum material cotado com o código: " + id));
				
		materialCotadoEntityFront.SetId(id);
		
		materialCotadoEntityFront = materialRequestImpl.verificaMaterial(materialCotadoEntityFront);
		materialCotadoEntityFront = materialRequestImpl.verificaFornecedor(materialCotadoEntityFront);

		materialCotadoModelBanco.setId(materialCotadoEntityFront.getId());
		materialCotadoModelBanco.setObservacao(materialCotadoEntityFront.getObservacao());
		materialCotadoModelBanco.setValor(materialCotadoEntityFront.getValor());
		materialCotadoModelBanco.setIdFornecedor(materialCotadoEntityFront.getIdFornecedor());
		materialCotadoModelBanco.setRazaoSocial(materialCotadoEntityFront.getRazaoSocial());
		materialCotadoModelBanco.setCnpj(materialCotadoEntityFront.getCnpj());
		materialCotadoModelBanco.setIdMaterial(materialCotadoEntityFront.getIdMaterial());
		materialCotadoModelBanco.setDescricaoMaterial(materialCotadoEntityFront.getDescricaoMaterial());
		materialCotadoModelBanco.setStatus(materialCotadoEntityFront.getStatus().getNumero());
		materialCotadoModelBanco.setCriadoEm(materialCotadoEntityFront.getCriadoEm());
		materialCotadoModelBanco.setCriadoPor(materialCotadoEntityFront.getCriadoPor());
		materialCotadoModelBanco.setAlteradoEm(materialCotadoEntityFront.getAlteradoEm());
		materialCotadoModelBanco.setAlteradoPor(materialCotadoEntityFront.getAlteradoPor());
		materialCotadoRepository.save(materialCotadoModelBanco);

		return materialCotadoEntityFront;

	}

	@Override
	public MaterialCotadoEntity findById(Long id) {
		Optional<MaterialCotadoModel> materialCotadoModelSave = materialCotadoRepository.findById(id);

		if (!materialCotadoModelSave.isPresent()) {
			throw new StellatoException("Não foi encontrado nenhum lead com o código: " + id);
		}
		MaterialCotadoEntity materialCotadoEntity = entityFactory.create(materialCotadoModelSave.get());
		return materialCotadoEntity;

	}

	@Override
	public List<MaterialCotadoEntity> findAll() {

		List<MaterialCotadoEntity> listaMaterialCotadoEntity = materialCotadoRepository.listarTodos();

		if (listaMaterialCotadoEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead cadastrado");
		}

		return listaMaterialCotadoEntity;
	}

	@Override
	public List<MaterialCotadoEntity> findAllActives() {

		List<MaterialCotadoEntity> listaMaterialCotadoEntity = materialCotadoRepository.listarAtivos();

		if (listaMaterialCotadoEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead ativo");
		}

		return listaMaterialCotadoEntity;
	}

	@Override
	public Page<MaterialCotadoEntity> findAllActivesPage(Pageable pageable) {
		Page<MaterialCotadoEntity> listaMaterialCotadoEntity = materialCotadoRepository.listarAtivos(pageable);
		return listaMaterialCotadoEntity;
	}

	public void deleteMaterialCotado(Long id) {
		MaterialCotadoEntity materialCotadoEntityBanco = findById(id);
		materialCotadoEntityBanco.Inativar();
		MaterialCotadoModel materialCotadoModel = factory.create(materialCotadoEntityBanco);
		materialCotadoRepository.save(materialCotadoModel);

	}

	public List<MaterialCotadoEntity> findByFornecedor(Long idFornecedor) {
		List<MaterialCotadoEntity> listaMaterialCotadoEntity = materialCotadoRepository
				.findByIdFornecedor(idFornecedor);

		if (listaMaterialCotadoEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum material cotado para o fornecedor: " + idFornecedor);
		}

		return listaMaterialCotadoEntity;

	}

	public Page<MaterialCotadoEntity> findByFornecedorPage(Long idFornecedor, Pageable pageable) {
		Page<MaterialCotadoEntity> listaMaterialCotadoEntity = materialCotadoRepository.findByIdFornecedor(idFornecedor,
				pageable);
		return listaMaterialCotadoEntity;
	}

	public List<MaterialCotadoEntity> findByMaterial(Long idMaterial) {
		List<MaterialCotadoEntity> listaMaterialCotadoEntity = materialCotadoRepository.findByIdMaterial(idMaterial);

		if (listaMaterialCotadoEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum material cotado para o material: " + idMaterial);
		}

		return listaMaterialCotadoEntity;

	}

	public Page<MaterialCotadoEntity> findByMaterialPage(Long idMaterial, Pageable pageable) {
		Page<MaterialCotadoEntity> listaMaterialCotadoEntity = materialCotadoRepository.findByIdMaterial(idMaterial,
				pageable);
		return listaMaterialCotadoEntity;
	}
}
