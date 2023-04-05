package com.stellato.administrador.infrastructure.fornecedor.resource;

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

import com.stellato.administrador.domain.fornecedor.entity.FornecedorEntity;
import com.stellato.administrador.infrastructure.fornecedor.service.FornecedorService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorResource {

	@Autowired
	FornecedorService fornecedorService;
	
	@ApiOperation(value = "Criar novo Fornecedor")
	@PostMapping()
	public ResponseEntity<FornecedorEntity> createFornecedor(@RequestBody FornecedorEntity fornecedorEntity) throws Exception {
		FornecedorEntity fornecedorEntitySave = fornecedorService.create(fornecedorEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorEntitySave);
	}
	
	@ApiOperation(value = "Atualizar Fornecedor já existente")
	@PutMapping("/{id}")
	public ResponseEntity<FornecedorEntity> updateFornecedor(@PathVariable Long id,@RequestBody FornecedorEntity fornecedorEntity) throws Exception {
		FornecedorEntity fornecedorEntityUpdated = fornecedorService.update(id,fornecedorEntity);
		return ResponseEntity.ok(fornecedorEntityUpdated);
	}
	
	@ApiOperation(value = "Buscar Fornecedor por id")
	@GetMapping("/{id}")
	public ResponseEntity<FornecedorEntity> findFornecedor(@PathVariable Long id) {
		return ResponseEntity.ok(fornecedorService.findById(id));
	}
	
	@ApiOperation(value = "Buscar todos Fornecedores")
	@GetMapping("/all")
	public List<FornecedorEntity> findAll() throws Exception {
		return fornecedorService.findAll();
	}
	
	@ApiOperation(value = "Buscar todos Fornecedores ativos")
	@GetMapping("/ativos")
	public List<FornecedorEntity> findAllActives() throws Exception {
		return fornecedorService.findAllActives();
	}
	
	@ApiOperation(value = "Buscar todos Fornecedores ativos - paginado")
	@GetMapping("/ativos/paginado")
	public Page<FornecedorEntity> findAllActivesPage(Pageable pageable) throws Exception {
		return fornecedorService.findAllActivesPage(pageable);
	}
	
	@ApiOperation(value = "Buscar Fornecedor pela razão social - paginado")
	@GetMapping("/razaosocial/{razaoSocial}")
	public Page<FornecedorEntity> findByRazaoSocial(@PathVariable String razaoSocial, Pageable pageable) throws Exception {
		return fornecedorService.findByRazaoSocial(razaoSocial,pageable);
	}
	
	@ApiOperation(value = "Deletar Fornecedor")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFornecedor(@PathVariable Long id) throws Exception {
		fornecedorService.deleteFornecedor(id);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
}


