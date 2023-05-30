package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Modalidadetarifaria;
import com.stellato.repository.ModalidadetarifariaRepository;

@Service
public class ModalidadetarifariaService {

	@Autowired
	private ModalidadetarifariaRepository modalidadetarifariaRepository;

	public Modalidadetarifaria salvar(Modalidadetarifaria modalidadetarifaria) {
		return modalidadetarifariaRepository.save(modalidadetarifaria);
	}

	public Modalidadetarifaria buscarPeloCodigo(Long codigo) {
		Modalidadetarifaria modalidadetarifariaSalva = modalidadetarifariaRepository.findById(codigo).get();
		if (modalidadetarifariaSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return modalidadetarifariaSalva;
	}

	public Modalidadetarifaria atualizar(Long codigo, Modalidadetarifaria modalidadetarifaria) {
		Modalidadetarifaria modalidadetarifariaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(modalidadetarifaria, modalidadetarifariaSave, "modalidadetarifariaid");
		return modalidadetarifariaRepository.save(modalidadetarifariaSave);
	}

	public Page<Modalidadetarifaria> pesquisar(Pageable pageable){
		return modalidadetarifariaRepository.findAll(pageable);
	}

	public List<Modalidadetarifaria> listarTodos() {
		return modalidadetarifariaRepository.findAll();
	}

	public void remover(Long codigo) {
		modalidadetarifariaRepository.deleteById(codigo);
	}

}