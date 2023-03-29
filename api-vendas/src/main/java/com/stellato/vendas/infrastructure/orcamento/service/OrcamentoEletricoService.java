package com.stellato.vendas.infrastructure.orcamento.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.domain.shared.repository.RepositoryInterface;


@Service
public class OrcamentoEletricoService implements RepositoryInterface<OrcamentoEletricoEntity>{
/*
	@Autowired
	private OrcamentoEletricoRepository materialCotadoRepository;
	
	@Autowired
	private OrcamentoFactory factory; 
	
	@Autowired
	private OrcamentoEntityFactory entityFactory;*/
	
	@Override
	@Transactional
	public OrcamentoEletricoEntity create(OrcamentoEletricoEntity materialCotadoEntityFront){
		return null;
	}

	@Override
	@Transactional
	public OrcamentoEletricoEntity update(Long id, OrcamentoEletricoEntity materialCotadoEntityFront){	
		return null;

	}
	
	@Override
	public OrcamentoEletricoEntity findById(Long id) {
		return null;
	}

	@Override
	public List<OrcamentoEletricoEntity> findAll(){
		return null;
	}
	
	@Override
	public List<OrcamentoEletricoEntity> findAllActives(){
		return null;
	}
	
	@Override
	public Page<OrcamentoEletricoEntity> findAllActivesPage(Pageable pageable) {
		return null;
	}
	
	
	public void deleteOrcamentoEletrico(Long id) {
	
	}

}
