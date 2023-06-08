package com.stellato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.stellato.model.Distribuidora;

@Repository
public interface DistribuidoraRepository extends JpaRepository<Distribuidora, Long>{

	@Query("SELECT d FROM Distribuidora d where d.status=1")
	List<Distribuidora> listarTodosAtivos();

	@Query("SELECT d FROM Distribuidora d where d.status=1")
	Page<Distribuidora> listarTodosAtivos(Pageable pageable);

	@Query("SELECT d FROM Distribuidora d where d.status=1 and (upper(d.nome) like concat('%',:pesquisa,'%') or upper(d.sigla) like concat('%',:pesquisa,'%'))")
	Page<Distribuidora> buscaGenerica(String pesquisa, Pageable pageable); 
	
} 