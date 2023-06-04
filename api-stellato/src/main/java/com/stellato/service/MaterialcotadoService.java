package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.MaterialCotado;
import com.stellato.repository.MaterialcotadoRepository;

@Service
public class MaterialcotadoService {

	@Autowired
	private MaterialcotadoRepository materialcotadoRepository;

	public MaterialCotado salvar(MaterialCotado materialcotado) {
		return materialcotadoRepository.save(materialcotado);
	}

	public MaterialCotado buscarPeloCodigo(Long codigo) {
		MaterialCotado materialcotadoSalva = materialcotadoRepository.findById(codigo).get();
		if (materialcotadoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return materialcotadoSalva;
	}

	public MaterialCotado atualizar(Long codigo, MaterialCotado materialcotado) {
		MaterialCotado materialcotadoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(materialcotado, materialcotadoSave, "materialcotadoid");
		return materialcotadoRepository.save(materialcotadoSave);
	}

	public Page<MaterialCotado> pesquisar(Pageable pageable){
		return materialcotadoRepository.findAll(pageable);
	}

	public List<MaterialCotado> listarTodos() {
		return materialcotadoRepository.findAll();
	}

	public void remover(Long codigo) {
		materialcotadoRepository.deleteById(codigo);
	}

}