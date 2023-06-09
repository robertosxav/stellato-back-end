package com.stellato.vendas.infrastructure.materialCotado.resource;

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

import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;
import com.stellato.vendas.infrastructure.materialCotado.service.MaterialCotadoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/materialcotado")
public class MaterialCotadoResource {

	@Autowired
	MaterialCotadoService materialCotadoService;
	
	@ApiOperation(value = "Criar novo Material Cotado")
	@PostMapping()
	public ResponseEntity<MaterialCotadoEntity> createMaterialCotado(@RequestBody MaterialCotadoEntity materialCotadoEntity) throws Exception {
		MaterialCotadoEntity materialCotadoEntitySave = materialCotadoService.create(materialCotadoEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(materialCotadoEntitySave);
	}
	
	@ApiOperation(value = "Atualizar um Material Cotado já existente")
	@PutMapping("/{id}")
	public ResponseEntity<MaterialCotadoEntity> updateMaterialCotado(@PathVariable Long id,@RequestBody MaterialCotadoEntity materialCotadoEntity) throws Exception {
		MaterialCotadoEntity materialCotadoEntityUpdated = materialCotadoService.update(id,materialCotadoEntity);
		return ResponseEntity.ok(materialCotadoEntityUpdated);
	}
	
	@ApiOperation(value = "Buscar Material Cotado por id")
	@GetMapping("/{id}")
	public ResponseEntity<MaterialCotadoEntity> findMaterialCotado(@PathVariable Long id) {
		return ResponseEntity.ok(materialCotadoService.findById(id));
	}
	
	@ApiOperation(value = "Buscar todos Materiais Cotados")
	@GetMapping("/all")
	public List<MaterialCotadoEntity> findAllMaterialCotados() throws Exception {
		return materialCotadoService.findAll();
	}
	
	@ApiOperation(value = "Buscar todos Materiais Cotados ativos")
	@GetMapping("/ativos")
	public List<MaterialCotadoEntity> findAllMaterialCotadosActives() throws Exception {
		return materialCotadoService.findAllActives();
	}
	
	@ApiOperation(value = "Buscar todos Materiais Cotados ativos - paginado")
	@GetMapping("/ativos/paginado")
	public Page<MaterialCotadoEntity> findAllActivesPage(Pageable pageable) throws Exception {
		return materialCotadoService.findAllActivesPage(pageable);
	}
	
	@ApiOperation(value = "Buscar todos Materiais Cotados de um fornecedor")
	@GetMapping("/fornecedor/{idFornecedor}")
	public List<MaterialCotadoEntity> findByIdFornecedor(@PathVariable Long idFornecedor) throws Exception {
		return materialCotadoService.findByFornecedor(idFornecedor);
	}
	
	@ApiOperation(value = "Buscar todos Materiais Cotados de um fornecedor - paginado")
	@GetMapping("/fornecedor/paginado/{idFornecedor}")
	public Page<MaterialCotadoEntity> findByIdFornecedorPage(@PathVariable Long idFornecedor, Pageable pageable) throws Exception {
		return materialCotadoService.findByFornecedorPage(idFornecedor, pageable);
	}
	
	@ApiOperation(value = "Buscar todos Materiais Cotados de um material")
	@GetMapping("/material/{idMaterial}")
	public List<MaterialCotadoEntity> findByIdMaterial(@PathVariable Long idMaterial) throws Exception {
		return materialCotadoService.findByMaterial(idMaterial);
	}
	
	@ApiOperation(value = "Buscar todos Materiais Cotados de um material - paginado")
	@GetMapping("/material/paginado/{idMaterial}")
	public Page<MaterialCotadoEntity> findByIdMaterialPage(@PathVariable Long idMaterial, Pageable pageable) throws Exception {
		return materialCotadoService.findByMaterialPage(idMaterial, pageable);
	}
	
	@ApiOperation(value = "Deletar Material Cotado")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMaterialCotado(@PathVariable Long id) throws Exception {
		materialCotadoService.deleteMaterialCotado(id);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
}
