package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.Fornecedor;
import com.stellato.model.Material;
import com.stellato.model.MaterialCotado;
import com.stellato.repository.MaterialCotadoRepository;

@Service
public class MaterialCotadoService {

	@Autowired
	private MaterialCotadoRepository materialCotadoRepository;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private FornecedorService fornecedorService;

	public MaterialCotado salvar(MaterialCotado materialCotado) {
		validar(materialCotado);
		materialCotado.ativar();
		return materialCotadoRepository.save(materialCotado);
	}

	private void validar(MaterialCotado materialCotado) {
		Material material =  materialService.buscarPeloCodigo(materialCotado.getMaterial().getId());
		materialCotado.setMaterial(material);
		
		Fornecedor fornecedor = fornecedorService.buscarPeloCodigo(materialCotado.getFornecedor().getId());
		materialCotado.setFornecedor(fornecedor);
	}

	public MaterialCotado buscarPeloCodigo(Long codigo) {
		MaterialCotado materialCotadoSalvo = materialCotadoRepository
				.findById(codigo)
				.orElseThrow(()-> new StellatoException("Id não encontrado"));
		
		return materialCotadoSalvo;
	}

	public MaterialCotado atualizar(Long codigo, MaterialCotado materialCotado) {
		MaterialCotado materialCotadoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(materialCotado, materialCotadoSave, "id","status");
		return materialCotadoRepository.save(materialCotadoSave);
	}

	public Page<MaterialCotado> pesquisar(Pageable pageable){
		return materialCotadoRepository.findAll(pageable);
	}

	public List<MaterialCotado> listarTodos() {
		return materialCotadoRepository.findAll();
	}

	public void remover(Long codigo) {
		MaterialCotado materialCotadoSalvo = buscarPeloCodigo(codigo);
		materialCotadoSalvo.inativar();
		materialCotadoRepository.save(materialCotadoSalvo);
	}

}