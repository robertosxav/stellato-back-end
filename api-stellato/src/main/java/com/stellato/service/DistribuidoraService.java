package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Distribuidora;
import com.stellato.repository.DistribuidoraRepository;

@Service
public class DistribuidoraService {

	@Autowired
	private DistribuidoraRepository distribuidoraRepository;

	public Distribuidora salvar(Distribuidora distribuidora) {
		return distribuidoraRepository.save(distribuidora);
	}

	public Distribuidora buscarPeloCodigo(Long codigo) {
		Distribuidora distribuidoraSalva = distribuidoraRepository.findById(codigo).get();
		if (distribuidoraSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return distribuidoraSalva;
	}

	public Distribuidora atualizar(Long codigo, Distribuidora distribuidora) {
		Distribuidora distribuidoraSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(distribuidora, distribuidoraSave, "distribuidoraid");
		return distribuidoraRepository.save(distribuidoraSave);
	}

	public Page<Distribuidora> pesquisar(Pageable pageable){
		return distribuidoraRepository.findAll(pageable);
	}

	public List<Distribuidora> listarTodos() {
		return distribuidoraRepository.findAll();
	}

	public void remover(Long codigo) {
		distribuidoraRepository.deleteById(codigo);
	}

}