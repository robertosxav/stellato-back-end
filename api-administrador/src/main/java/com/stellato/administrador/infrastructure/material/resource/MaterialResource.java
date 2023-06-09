package com.stellato.administrador.infrastructure.material.resource;

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

import com.stellato.administrador.domain.material.entity.MaterialEntity;
import com.stellato.administrador.infrastructure.material.service.MaterialService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/material")
public class MaterialResource {

	@Autowired
	MaterialService materialService;
	
	@ApiOperation(value = "Criar novo Material")
	@PostMapping()
	public ResponseEntity<MaterialEntity> createMaterial(@RequestBody MaterialEntity materialEntity) throws Exception {
		MaterialEntity materialEntitySave = materialService.create(materialEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(materialEntitySave);
	}
	
	@ApiOperation(value = "Atualizar Material já existente")
	@PutMapping("/{id}")
	public ResponseEntity<MaterialEntity> updateMaterial(@PathVariable Long id,@RequestBody MaterialEntity materialEntity) throws Exception {
		MaterialEntity materialEntityUpdated = materialService.update(id,materialEntity);
		return ResponseEntity.ok(materialEntityUpdated);
	}
	
	@ApiOperation(value = "Buscar Material por id")
	@GetMapping("/{id}")
	public ResponseEntity<MaterialEntity> findMaterial(@PathVariable Long id) {
		return ResponseEntity.ok(materialService.findById(id));
	}
	
	@ApiOperation(value = "Buscar todos Materiais")
	@GetMapping("/all")
	public List<MaterialEntity> findAll() throws Exception {
		return materialService.findAll();
	}
	
	@ApiOperation(value = "Buscar todos Materiais ativos")
	@GetMapping("/ativos")
	public List<MaterialEntity> findAllActives() throws Exception {
		return materialService.findAllActives();
	}
	
	@ApiOperation(value = "Buscar todos Materiais ativos - paginado")
	@GetMapping("/ativos/paginado")
	public Page<MaterialEntity> findAllActivesPage(Pageable pageable) throws Exception {
		return materialService.findAllActivesPage(pageable);
	}
	
	@ApiOperation(value = "Buscar Material pelo nome - paginado")
	@GetMapping("/nome/{descricao}")
	public Page<MaterialEntity> findByDescricao(@PathVariable String descricao, Pageable pageable) throws Exception {
		return materialService.findByDescricao(descricao,pageable);
	}
	
	@ApiOperation(value = "Deletar Material")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMaterial(@PathVariable Long id) throws Exception {
		materialService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
}
