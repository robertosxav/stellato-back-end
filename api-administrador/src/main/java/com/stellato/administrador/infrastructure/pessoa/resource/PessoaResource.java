package com.stellato.administrador.infrastructure.pessoa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stellato.administrador.domain.pessoa.entity.PessoaEntity;
import com.stellato.administrador.infrastructure.pessoa.service.PessoaService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	PessoaService pessoaService;
	
	@ApiOperation(value = "Criar nova Pessoa")
	@PostMapping()
	public ResponseEntity<PessoaEntity> createPessoa(@RequestBody PessoaEntity leadEntity) throws Exception {
		PessoaEntity leadEntitySave = pessoaService.create(leadEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(leadEntitySave);
	}
	
	@ApiOperation(value = "Atualizar Pessoa já existente")
	@PutMapping("/{id}")
	public ResponseEntity<PessoaEntity> updatePessoa(@PathVariable Long id,@RequestBody PessoaEntity leadEntity) throws Exception {
		PessoaEntity leadEntityUpdated = pessoaService.update(id,leadEntity);
		return ResponseEntity.ok(leadEntityUpdated);
	}
	
	@ApiOperation(value = "Buscar Pessoa por id")
	@GetMapping("/{id}")
	public ResponseEntity<PessoaEntity> findPessoa(@PathVariable Long id) {
		return ResponseEntity.ok(pessoaService.findById(id));
	}
	
	@ApiOperation(value = "Buscar todas Pessoas")
	@GetMapping("/all")
	public List<PessoaEntity> findAll() throws Exception {
		return pessoaService.findAll();
	}
	
	@ApiOperation(value = "Buscar todas Pessoas ativas")
	@GetMapping("/ativos")
	public List<PessoaEntity> findAllActives() throws Exception {
		return pessoaService.findAllActives();
	}
	
	@ApiOperation(value = "Buscar todas Pessoas ativas - paginado")
	@GetMapping("/ativos/paginado")
	public Page<PessoaEntity> findAllActivesPage(Pageable pageable) throws Exception {
		return pessoaService.findAllActivesPage(pageable);
	}
	
	
	@ApiOperation(value = "Buscar Pessoa pelo nome - paginado")
	@GetMapping("/nome/{nome}")
	public Page<PessoaEntity> findByName(@PathVariable String nome, Pageable pageable) throws Exception {
		return pessoaService.findByName(nome,pageable);
	}
	
	@ApiOperation(value = "Deletar Pessoa")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePessoa(@PathVariable Long id) throws Exception {
		pessoaService.deletePessoa(id);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
}


