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


@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	PessoaService pessoaService;
	
	@PostMapping()
	public ResponseEntity<PessoaEntity> createLead(@RequestBody PessoaEntity leadEntity) throws Exception {
		PessoaEntity leadEntitySave = pessoaService.create(leadEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(leadEntitySave);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PessoaEntity> updateLead(@PathVariable Long id,@RequestBody PessoaEntity leadEntity) throws Exception {
		PessoaEntity leadEntityUpdated = pessoaService.update(id,leadEntity);
		return ResponseEntity.ok(leadEntityUpdated);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaEntity> findLead(@PathVariable Long id) {
		return ResponseEntity.ok(pessoaService.findById(id));
	}
	
	@GetMapping("/all")
	public List<PessoaEntity> findAllLeads() throws Exception {
		return pessoaService.findAll();
	}
	
	@GetMapping("/ativos")
	public List<PessoaEntity> findAllLeadsActives() throws Exception {
		return pessoaService.findAllActives();
	}
	
	@GetMapping("/ativos/paginado")
	public Page<PessoaEntity> findAllActivesPage(Pageable pageable) throws Exception {
		return pessoaService.findAllActivesPage(pageable);
	}
	
	@GetMapping("/nome/{nome}")
	public Page<PessoaEntity> findByName(@PathVariable String nome, Pageable pageable) throws Exception {
		return pessoaService.findByName(nome,pageable);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLead(@PathVariable Long id) throws Exception {
		pessoaService.deleteLead(id);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
}


