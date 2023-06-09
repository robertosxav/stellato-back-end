package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.FunilVendas;
import com.stellato.repository.FunilVendasRepository;

@Service
public class FunilVendasService {

	@Autowired
	private FunilVendasRepository funilvendasRepository;

	public FunilVendas salvar(FunilVendas funilvendas) {
		funilvendas.ativar();
		return funilvendasRepository.save(funilvendas);
	}

	public FunilVendas buscarPeloCodigo(Long codigo) {
		FunilVendas funilvendasSalva = funilvendasRepository
				.findById(codigo)
				.orElseThrow(()-> new StellatoException("Id não encontrado"));
		return funilvendasSalva;
	}

	public FunilVendas atualizar(Long codigo, FunilVendas funilvendas) {
		FunilVendas funilvendasSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(funilvendas, funilvendasSave, "id","status");
		return funilvendasRepository.save(funilvendasSave);
	}

	public Page<FunilVendas> pesquisar(Pageable pageable){
		return funilvendasRepository.findAll(pageable);
	}

	public List<FunilVendas> listarTodos() {
		return funilvendasRepository.findAll();
	}

	public void remover(Long codigo) {
		FunilVendas funilVendas = buscarPeloCodigo(codigo);
		funilVendas.inativar();
		funilvendasRepository.save(funilVendas);
	}

	public List<FunilVendas> listarTodosAtivos() {
		return funilvendasRepository.listarTodosAtivos();
	}

	public Page<FunilVendas> listarTodosAtivos(Pageable pageable) {
		return funilvendasRepository.listarTodosAtivos(pageable);
	}
	
	public Page<FunilVendas> buscaGenerica(String pesquisa, Pageable pageable) {
		return funilvendasRepository.buscaGenerica(pesquisa.toUpperCase(), pageable);
	}
}