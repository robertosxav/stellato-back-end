package com.stellato.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stellato.model.Material;
import com.stellato.service.MaterialService;

@RestController
@RequestMapping("/materials")
public class MaterialResource {

	@Autowired
	private MaterialService materialService;
	
	@PostMapping
	public ResponseEntity<Material> criar(@Valid @RequestBody Material material, HttpServletResponse response) {
		 Material materialSalva = materialService.salvar(material);
		return ResponseEntity.status(HttpStatus.CREATED).body(materialSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Material> buscarPeloCodigo(@PathVariable Long codigo) {
		Material material = materialService.buscarPeloCodigo(codigo);
		return material != null ? ResponseEntity.ok(material) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Material> atualizar(@PathVariable Long codigo, @Valid @RequestBody Material material) {
		Material materialSalva = materialService.atualizar(codigo, material);
		return ResponseEntity.ok(materialSalva);
	}

	@GetMapping
	public Page<Material> pesquisar(Pageable pageable) {
		return materialService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Material> pesquisar() {
		return materialService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		materialService.remover(codigo);
	}

}