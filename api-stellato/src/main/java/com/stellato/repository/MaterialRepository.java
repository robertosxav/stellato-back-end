package com.stellato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.stellato.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>{

	@Query("SELECT m FROM Material m where m.status=1")
	List<Material> listarTodosAtivos();

	@Query("SELECT m FROM Material m where m.status=1")
	Page<Material> listarTodosAtivos(Pageable pageable);

	@Query("SELECT m FROM Material m where m.status=1 and upper(m.descricao) like concat('%',:pesquisa,'%')")
	Page<Material> buscaGenerica(String pesquisa, Pageable pageable); 
	
} 