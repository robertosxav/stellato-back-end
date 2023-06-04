package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.FunilVendas;
import com.stellato.repository.FunilVendasRepository;

@Service
public class FunilVendasService {

	@Autowired
	private FunilVendasRepository funilvendasRepository;

	public FunilVendas salvar(FunilVendas funilvendas) {
		return funilvendasRepository.save(funilvendas);
	}

	public FunilVendas buscarPeloCodigo(Long codigo) {
		FunilVendas funilvendasSalva = funilvendasRepository.findById(codigo).get();
		if (funilvendasSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return funilvendasSalva;
	}

	public FunilVendas atualizar(Long codigo, FunilVendas funilvendas) {
		FunilVendas funilvendasSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(funilvendas, funilvendasSave, "funilvendasid");
		return funilvendasRepository.save(funilvendasSave);
	}

	public Page<FunilVendas> pesquisar(Pageable pageable){
		return funilvendasRepository.findAll(pageable);
	}

	public List<FunilVendas> listarTodos() {
		return funilvendasRepository.findAll();
	}

	public void remover(Long codigo) {
		funilvendasRepository.deleteById(codigo);
	}

}