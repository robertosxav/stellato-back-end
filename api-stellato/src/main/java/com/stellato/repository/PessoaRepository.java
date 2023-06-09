package com.stellato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stellato.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	@Query("SELECT p FROM Pessoa p WHERE p.status =1")
	Page<Pessoa> listarTodosAtivos(Pageable pageable);

	@Query("SELECT p FROM Pessoa p WHERE p.status =1")
	List<Pessoa> listarTodosAtivos();

	@Query("SELECT p FROM Pessoa p WHERE p.status =1")
	Page<Pessoa> buscaGenerica(String pesquisa, Pageable pageable); 
	
} 