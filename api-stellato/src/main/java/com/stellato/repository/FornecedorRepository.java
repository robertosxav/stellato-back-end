package com.stellato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.stellato.model.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

	@Query("SELECT f FROM Fornecedor f WHERE f.status = 1")
	List<Fornecedor> listarTodosAtivos();

	@Query("SELECT f FROM Fornecedor f WHERE f.status = 1")
	Page<Fornecedor> listarTodosAtivos(Pageable pageable);

	@Query("SELECT f FROM Fornecedor f WHERE f.status = 1 and UPPER(f.nome) LIKE CONCAT('%',:pesquisa,'%')")
	Page<Fornecedor> buscaGenerica(String pesquisa, Pageable pageable); 
	
} 