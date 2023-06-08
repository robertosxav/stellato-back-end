package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.Distribuidora;
import com.stellato.repository.DistribuidoraRepository;

@Service
public class DistribuidoraService {

	@Autowired
	private DistribuidoraRepository distribuidoraRepository;

	public Distribuidora salvar(Distribuidora distribuidora) {
		distribuidora.ativar();
		return distribuidoraRepository.save(distribuidora);
	}

	public Distribuidora buscarPeloCodigo(Long codigo) {
		Distribuidora distribuidoraSalva = distribuidoraRepository
				.findById(codigo)
				.orElseThrow(()->new StellatoException("Id não encontrado"));
		return distribuidoraSalva;
	}

	public Distribuidora atualizar(Long codigo, Distribuidora distribuidora) {
		Distribuidora distribuidoraSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(distribuidora, distribuidoraSave, "id","status");
		return distribuidoraRepository.save(distribuidoraSave);
	}

	public Page<Distribuidora> pesquisar(Pageable pageable){
		return distribuidoraRepository.findAll(pageable);
	}

	public List<Distribuidora> listarTodos() {
		return distribuidoraRepository.findAll();
	}

	public void remover(Long codigo) {
		Distribuidora distribuidora = buscarPeloCodigo(codigo);
		distribuidora.inativar();
		distribuidoraRepository.save(distribuidora);
	}

	public List<Distribuidora> listarTodosAtivos() {
		return distribuidoraRepository.listarTodosAtivos();
	}

	public Page<Distribuidora> listarTodosAtivos(Pageable pageable) {
		return distribuidoraRepository.listarTodosAtivos(pageable);
	}
	
	public Page<Distribuidora> buscaGenerica(String pesquisa, Pageable pageable) {
		return distribuidoraRepository.buscaGenerica(pesquisa,pageable);
	}


}