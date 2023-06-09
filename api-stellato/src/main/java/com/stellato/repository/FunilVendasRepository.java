package com.stellato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.stellato.model.FunilVendas;

@Repository
public interface FunilVendasRepository extends JpaRepository<FunilVendas, Long>{

	@Query("SELECT f FROM FunilVendas f WHERE f.status = 1")
	List<FunilVendas> listarTodosAtivos();

	@Query("SELECT f FROM FunilVendas f WHERE f.status = 1")
	Page<FunilVendas> listarTodosAtivos(Pageable pageable);

	@Query("SELECT f FROM FunilVendas f WHERE f.status = 1 and UPPER(f.descricao) LIKE CONCAT('%',:pesquisa,'%')")
	Page<FunilVendas> buscaGenerica(String pesquisa, Pageable pageable); 
	
} 