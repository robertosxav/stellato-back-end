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

	@Query("SELECT ef FROM EtapasFunil ef where ef.status = 1")
	List<EtapasFunil> listarTodosAtivos();
	
	@Query("SELECT ef FROM EtapasFunil ef where ef.status = 1")
	Page<EtapasFunil> listarTodosAtivos(Pageable pageable); 
	
	@Query("SELECT ef FROM EtapasFunil ef where ef.status = 1 and upper(ef.etapa) LIKE CONCAT ('%',:pesquisa,'%')")
	Page<EtapasFunil> buscaGenerica(String pesquisa, Pageable pageable);
	
	@Query("SELECT ef FROM EtapasFunil ef where ef.status = 1 and ef.funilVendas.id = :idFunilVendas")
	List<EtapasFunil> buscarPeloFunil(Long idFunilVendas);
} 