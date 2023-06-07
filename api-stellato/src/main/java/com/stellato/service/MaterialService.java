package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.Material;
import com.stellato.repository.MaterialRepository;

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository materialRepository;

	public Material salvar(Material material) {
		material.ativar();
		return materialRepository.save(material);
	}

	public Material buscarPeloCodigo(Long codigo) {
		Material materialSalva = materialRepository
				.findById(codigo)
				.orElseThrow(()->new StellatoException("Id não encontrado"));
		
		return materialSalva;
	}

	public Material atualizar(Long codigo, Material material) {
		Material materialSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(material, materialSave, "materialid");
		return materialRepository.save(materialSave);
	}

	public Page<Material> pesquisar(Pageable pageable){
		return materialRepository.findAll(pageable);
	}

	public List<Material> listarTodos() {
		return materialRepository.findAll();
	}

	public void remover(Long codigo) {
		Material materialBanco = buscarPeloCodigo(codigo);
		materialBanco.inativar();
		materialRepository.save(materialBanco);
	}

}