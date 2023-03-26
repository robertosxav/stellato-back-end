package com.stellato.vendas.infrastructure.orcamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stellato.vendas.infrastructure.orcamento.OrcamentoEletricoModel;

@Repository
public interface OrcamentoEletricoRepository extends JpaRepository<OrcamentoEletricoModel, Long>{

	//public List<OrcamentoEletricoEntity> listarTodos();
	
//	public List<OrcamentoEletricoEntity> listarAtivos();

	//public Page<OrcamentoEletricoEntity> listarAtivos(Pageable pageable );

}