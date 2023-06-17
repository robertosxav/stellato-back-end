package com.stellato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stellato.model.EtapasFunil;

@Repository
public interface EtapasFunilRepository extends JpaRepository<EtapasFunil, Long>{

	@Query("SELECT ef FROM EtapasFunil ef where ef.status = 1 order by ef.ordem asc")
	List<EtapasFunil> listarTodosAtivos();
	
	@Query("SELECT ef FROM EtapasFunil ef where ef.status = 1 order by ef.ordem asc")
	Page<EtapasFunil> listarTodosAtivos(Pageable pageable); 
	
	@Query("SELECT ef FROM EtapasFunil ef where ef.status = 1 and upper(ef.etapa) LIKE CONCAT ('%',:pesquisa,'%') order by ef.ordem asc")
	Page<EtapasFunil> buscaGenerica(String pesquisa, Pageable pageable);
	
	@Query("SELECT ef FROM EtapasFunil ef where ef.status = 1 and ef.funilVendas.id = :idFunilVendas order by ef.ordem asc")
	List<EtapasFunil> buscarPeloFunil(Long idFunilVendas);

	@Query(nativeQuery = true,value = "SELECT ef.etapas_funil_ordem FROM etapas_funil ef "
			+ "where ef.etapas_funil_status = 1 "
			+ "and ef.funil_vendas_id = :idFunilVendas "
			+ "order by ef.etapas_funil_ordem desc limit 1")
	Integer buscarOrdemMaxFunil(Long idFunilVendas);
} 