package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Materialcotado;
import com.stellato.repository.MaterialcotadoRepository;

@Service
public class MaterialcotadoService {

	@Autowired
	private MaterialcotadoRepository materialcotadoRepository;

	public Materialcotado salvar(Materialcotado materialcotado) {
		return materialcotadoRepository.save(materialcotado);
	}

	public Materialcotado buscarPeloCodigo(Long codigo) {
		Materialcotado materialcotadoSalva = materialcotadoRepository.findById(codigo).get();
		if (materialcotadoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return materialcotadoSalva;
	}

	public Materialcotado atualizar(Long codigo, Materialcotado materialcotado) {
		Materialcotado materialcotadoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(materialcotado, materialcotadoSave, "materialcotadoid");
		return materialcotadoRepository.save(materialcotadoSave);
	}

	public Page<Materialcotado> pesquisar(Pageable pageable){
		return materialcotadoRepository.findAll(pageable);
	}

	public List<Materialcotado> listarTodos() {
		return materialcotadoRepository.findAll();
	}

	public void remover(Long codigo) {
		materialcotadoRepository.deleteById(codigo);
	}

}