package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.DadosContaEnergia;
import com.stellato.repository.DadosContaEnergiaRepository;

@Service
public class DadosContaEnergiaService {

	@Autowired
	private DadosContaEnergiaRepository dadoscontaenergiaRepository;

	public DadosContaEnergia salvar(DadosContaEnergia dadoscontaenergia) {
		return dadoscontaenergiaRepository.save(dadoscontaenergia);
	}

	public DadosContaEnergia buscarPeloCodigo(Long codigo) {
		DadosContaEnergia dadoscontaenergiaSalva = dadoscontaenergiaRepository.findById(codigo).get();
		if (dadoscontaenergiaSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return dadoscontaenergiaSalva;
	}

	public DadosContaEnergia atualizar(Long codigo, DadosContaEnergia dadoscontaenergia) {
		DadosContaEnergia dadoscontaenergiaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(dadoscontaenergia, dadoscontaenergiaSave, "dadoscontaenergiaid");
		return dadoscontaenergiaRepository.save(dadoscontaenergiaSave);
	}

	public Page<DadosContaEnergia> pesquisar(Pageable pageable){
		return dadoscontaenergiaRepository.findAll(pageable);
	}

	public List<DadosContaEnergia> listarTodos() {
		return dadoscontaenergiaRepository.findAll();
	}

	public void remover(Long codigo) {
		dadoscontaenergiaRepository.deleteById(codigo);
	}

}