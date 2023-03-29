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
import com.stellato.vendas.infrastructure.materialCotado.MaterialCotadoModel;
import com.stellato.vendas.infrastructure.materialCotado.factory.MaterialCotadoFactory;
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
		boolean retornoMaterial = materialRequestImpl.verificaMaterial(materialCotadoEntityFront);
		boolean retornoFornecedor = materialRequestImpl.verificaFornecedor(materialCotadoEntityFront);

		if (retornoMaterial && retornoFornecedor) {

			if (materialCotadoEntityFront.validar()) {
				materialCotadoEntityFront.Ativar();
				MaterialCotadoModel materialCotadoModel = factory.create(materialCotadoEntityFront);

				materialCotadoRepository.save(materialCotadoModel);

				materialCotadoEntityFront.SetId(materialCotadoModel.getId());

				return materialCotadoEntityFront;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public MaterialCotadoEntity update(Long id, MaterialCotadoEntity materialCotadoEntityFront) {

		materialCotadoEntityFront.Alterar(null);

		Optional<MaterialCotadoModel> materialCotadoModelBanco = materialCotadoRepository.findById(id);

		materialCotadoEntityFront.SetId(id);

		materialCotadoModelBanco.get().setId(materialCotadoEntityFront.getId());
		materialCotadoModelBanco.get().setObservacao(materialCotadoEntityFront.getObservacao());
		materialCotadoModelBanco.get().setValor(materialCotadoEntityFront.getValor());
		materialCotadoModelBanco.get().setIdFornecedor(materialCotadoEntityFront.getIdFornecedor());
		materialCotadoModelBanco.get().setIdMaterial(materialCotadoEntityFront.getIdMaterial());
		materialCotadoModelBanco.get().setStatus(materialCotadoEntityFront.getStatus().getNumero());
		materialCotadoModelBanco.get().setCriadoEm(materialCotadoEntityFront.getCriadoEm());
		materialCotadoModelBanco.get().setCriadoPor(materialCotadoEntityFront.getCriadoPor());
		materialCotadoModelBanco.get().setAlteradoEm(materialCotadoEntityFront.getAlteradoEm());
		materialCotadoModelBanco.get().setAlteradoPor(materialCotadoEntityFront.getAlteradoPor());
		materialCotadoRepository.save(materialCotadoModelBanco.get());

		return materialCotadoEntityFront;

	}

	@Override
	public MaterialCotadoEntity findById(Long id) {
		Optional<MaterialCotadoModel> materialCotadoModelSave = null;// materialCotadoRepository.findById(id);

		if (!materialCotadoModelSave.isPresent()) {
			throw new StellatoException("Não foi encontrado nenhum lead com o código: " + id);
		}
		MaterialCotadoEntity materialCotadoEntity = entityFactory.create(materialCotadoModelSave.get());
		return materialCotadoEntity;

	}

	@Override
	public List<MaterialCotadoEntity> findAll() {

		List<MaterialCotadoEntity> listaMaterialCotadoEntity = null;// materialCotadoRepository.listarTodos();

		if (listaMaterialCotadoEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead cadastrado");
		}

		return listaMaterialCotadoEntity;
	}

	@Override
	public List<MaterialCotadoEntity> findAllActives() {

		List<MaterialCotadoEntity> listaMaterialCotadoEntity = null;// materialCotadoRepository.listarAtivos();

		if (listaMaterialCotadoEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead ativo");
		}

		return listaMaterialCotadoEntity;
	}

	@Override
	public Page<MaterialCotadoEntity> findAllActivesPage(Pageable pageable) {
		Page<MaterialCotadoEntity> listaMaterialCotadoEntity = null;// materialCotadoRepository.listarAtivos(pageable);
		return listaMaterialCotadoEntity;
	}

	public void deleteMaterialCotado(Long id) {
		MaterialCotadoEntity materialCotadoEntityBanco = findById(id);
		materialCotadoEntityBanco.Inativar();
		MaterialCotadoModel materialCotadoModel = factory.create(materialCotadoEntityBanco);
		materialCotadoRepository.save(materialCotadoModel);

	}

}
