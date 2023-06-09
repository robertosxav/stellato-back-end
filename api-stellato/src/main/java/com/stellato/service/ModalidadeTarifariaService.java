package com.stellato.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.Distribuidora;
import com.stellato.model.ModalidadeTarifaria;
import com.stellato.repository.ModalidadeTarifariaRepository;

@Service
public class ModalidadeTarifariaService {

	@Autowired
	private ModalidadeTarifariaRepository modalidadetarifariaRepository;
	
	@Autowired
	private DistribuidoraService distribuidoraService;

	public ModalidadeTarifaria salvar(ModalidadeTarifaria modalidadetarifaria) {
		validar(modalidadetarifaria);
		modalidadetarifaria.ativar();
		return modalidadetarifariaRepository.save(modalidadetarifaria);
	}

	
	private void validar(ModalidadeTarifaria modalidadetarifaria) {
		Distribuidora distirbuidora = distribuidoraService.buscarPeloCodigo(modalidadetarifaria.getDistribuidora().getId());
		modalidadetarifaria.setDistribuidora(distirbuidora);
		
		Boolean isMaiorQueZero = modalidadetarifaria.getValor().compareTo(BigDecimal.ZERO)==1?true:false;
		
		if(!isMaiorQueZero) {
			throw new StellatoException("Valor deve ser maior que zero");
		}
	}

	public ModalidadeTarifaria buscarPeloCodigo(Long codigo) {
		ModalidadeTarifaria modalidadetarifariaSalva = modalidadetarifariaRepository
				.findById(codigo)
				.orElseThrow(()-> new StellatoException("Id não encontrado"));
		return modalidadetarifariaSalva;
	}

	public ModalidadeTarifaria atualizar(Long codigo, ModalidadeTarifaria modalidadetarifaria) {
		validar(modalidadetarifaria);
		ModalidadeTarifaria modalidadetarifariaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(modalidadetarifaria, modalidadetarifariaSave, "id","status");
		return modalidadetarifariaRepository.save(modalidadetarifariaSave);
	}

	public Page<ModalidadeTarifaria> pesquisar(Pageable pageable){
		return modalidadetarifariaRepository.findAll(pageable);
	}

	public List<ModalidadeTarifaria> listarTodos() {
		return modalidadetarifariaRepository.findAll();
	}

	public void remover(Long codigo) {
		ModalidadeTarifaria modalidadeTarifaria = buscarPeloCodigo(codigo);
		modalidadeTarifaria.inativar();
		modalidadetarifariaRepository.save(modalidadeTarifaria);
	}

	public Page<ModalidadeTarifaria> listarTodosAtivos(Pageable pageable) {
		return modalidadetarifariaRepository.listarTodosAtivos(pageable);
	}

	public List<ModalidadeTarifaria> listarTodosAtivos() {
		return modalidadetarifariaRepository.listarTodosAtivos();
	}


	public List<ModalidadeTarifaria> buscarPelaDistribuidora(Long idDistribuidora) {
		return modalidadetarifariaRepository.buscarPelaDistribuidora(idDistribuidora);
	}


}