package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.FlywaySchemaHistory;
import com.stellato.repository.FlywaySchemaHistoryRepository;

@Service
public class FlywaySchemaHistoryService {

	@Autowired
	private FlywaySchemaHistoryRepository flywayschemahistoryRepository;

	public FlywaySchemaHistory salvar(FlywaySchemaHistory flywayschemahistory) {
		return flywayschemahistoryRepository.save(flywayschemahistory);
	}

	public FlywaySchemaHistory buscarPeloCodigo(Long codigo) {
		FlywaySchemaHistory flywayschemahistorySalva = flywayschemahistoryRepository.findById(codigo).get();
		if (flywayschemahistorySalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return flywayschemahistorySalva;
	}

	public FlywaySchemaHistory atualizar(Long codigo, FlywaySchemaHistory flywayschemahistory) {
		FlywaySchemaHistory flywayschemahistorySave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(flywayschemahistory, flywayschemahistorySave, "installedRank");
		return flywayschemahistoryRepository.save(flywayschemahistorySave);
	}

	public Page<FlywaySchemaHistory> pesquisar(Pageable pageable){
		return flywayschemahistoryRepository.findAll(pageable);
	}

	public List<FlywaySchemaHistory> listarTodos() {
		return flywayschemahistoryRepository.findAll();
	}

	public void remover(Long codigo) {
		flywayschemahistoryRepository.deleteById(codigo);
	}

}