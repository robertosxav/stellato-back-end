package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Dadoscontaenergia;
import com.stellato.repository.DadoscontaenergiaRepository;

@Service
public class DadoscontaenergiaService {

	@Autowired
	private DadoscontaenergiaRepository dadoscontaenergiaRepository;

	public Dadoscontaenergia salvar(Dadoscontaenergia dadoscontaenergia) {
		return dadoscontaenergiaRepository.save(dadoscontaenergia);
	}

	public Dadoscontaenergia buscarPeloCodigo(Long codigo) {
		Dadoscontaenergia dadoscontaenergiaSalva = dadoscontaenergiaRepository.findById(codigo).get();
		if (dadoscontaenergiaSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return dadoscontaenergiaSalva;
	}

	public Dadoscontaenergia atualizar(Long codigo, Dadoscontaenergia dadoscontaenergia) {
		Dadoscontaenergia dadoscontaenergiaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(dadoscontaenergia, dadoscontaenergiaSave, "dadoscontaenergiaid");
		return dadoscontaenergiaRepository.save(dadoscontaenergiaSave);
	}

	public Page<Dadoscontaenergia> pesquisar(Pageable pageable){
		return dadoscontaenergiaRepository.findAll(pageable);
	}

	public List<Dadoscontaenergia> listarTodos() {
		return dadoscontaenergiaRepository.findAll();
	}

	public void remover(Long codigo) {
		dadoscontaenergiaRepository.deleteById(codigo);
	}

}