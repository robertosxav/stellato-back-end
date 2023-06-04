package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.ModalidadeTarifaria;
import com.stellato.repository.ModalidadetarifariaRepository;

@Service
public class ModalidadetarifariaService {

	@Autowired
	private ModalidadetarifariaRepository modalidadetarifariaRepository;

	public ModalidadeTarifaria salvar(ModalidadeTarifaria modalidadetarifaria) {
		return modalidadetarifariaRepository.save(modalidadetarifaria);
	}

	public ModalidadeTarifaria buscarPeloCodigo(Long codigo) {
		ModalidadeTarifaria modalidadetarifariaSalva = modalidadetarifariaRepository.findById(codigo).get();
		if (modalidadetarifariaSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return modalidadetarifariaSalva;
	}

	public ModalidadeTarifaria atualizar(Long codigo, ModalidadeTarifaria modalidadetarifaria) {
		ModalidadeTarifaria modalidadetarifariaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(modalidadetarifaria, modalidadetarifariaSave, "modalidadetarifariaid");
		return modalidadetarifariaRepository.save(modalidadetarifariaSave);
	}

	public Page<ModalidadeTarifaria> pesquisar(Pageable pageable){
		return modalidadetarifariaRepository.findAll(pageable);
	}

	public List<ModalidadeTarifaria> listarTodos() {
		return modalidadetarifariaRepository.findAll();
	}

	public void remover(Long codigo) {
		modalidadetarifariaRepository.deleteById(codigo);
	}

}