package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Funilvendas;
import com.stellato.repository.FunilvendasRepository;

@Service
public class FunilvendasService {

	@Autowired
	private FunilvendasRepository funilvendasRepository;

	public Funilvendas salvar(Funilvendas funilvendas) {
		return funilvendasRepository.save(funilvendas);
	}

	public Funilvendas buscarPeloCodigo(Long codigo) {
		Funilvendas funilvendasSalva = funilvendasRepository.findById(codigo).get();
		if (funilvendasSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return funilvendasSalva;
	}

	public Funilvendas atualizar(Long codigo, Funilvendas funilvendas) {
		Funilvendas funilvendasSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(funilvendas, funilvendasSave, "funilvendasid");
		return funilvendasRepository.save(funilvendasSave);
	}

	public Page<Funilvendas> pesquisar(Pageable pageable){
		return funilvendasRepository.findAll(pageable);
	}

	public List<Funilvendas> listarTodos() {
		return funilvendasRepository.findAll();
	}

	public void remover(Long codigo) {
		funilvendasRepository.deleteById(codigo);
	}

}