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
import org.springframework.web.bind.annotation.RestController;

import com.stellato.model.ParamModTarifaria;
import com.stellato.service.ParamModTarifariaService;

@RestController
@RequestMapping("/parammodtarif")
public class ParamModTarifariaResource {

	@Autowired
	private ParamModTarifariaService paramModTarifariaService;

	@PostMapping
	public ResponseEntity<ParamModTarifaria> criar(@Valid @RequestBody ParamModTarifaria modalidadetarifaria, HttpServletResponse response) {
		 ParamModTarifaria modalidadetarifariaSalva = paramModTarifariaService.salvar(modalidadetarifaria);
		return ResponseEntity.status(HttpStatus.CREATED).body(modalidadetarifariaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ParamModTarifaria> buscarPeloCodigo(@PathVariable Long codigo) {
		ParamModTarifaria modalidadetarifaria = paramModTarifariaService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(modalidadetarifaria);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ParamModTarifaria> atualizar(@PathVariable Long codigo, @Valid @RequestBody ParamModTarifaria modalidadetarifaria) {
		ParamModTarifaria modalidadetarifariaSalva = paramModTarifariaService.atualizar(codigo, modalidadetarifaria);
		return ResponseEntity.ok(modalidadetarifariaSalva);
	}

	@GetMapping
	public Page<ParamModTarifaria> pesquisar(Pageable pageable) {
		return paramModTarifariaService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ParamModTarifaria> pesquisar() {
		return paramModTarifariaService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		paramModTarifariaService.remover(codigo);
	}
	
	@GetMapping("/ativos/paginado")
	public Page<ParamModTarifaria> listarTodosAtivos(Pageable pageable) {
		return paramModTarifariaService.listarTodosAtivos(pageable);
	}

	@GetMapping("/ativos")
	public List<ParamModTarifaria> listarTodosAtivos() {
		return paramModTarifariaService.listarTodosAtivos();
	}
	
	@GetMapping("/buscarpeladistribuidora/{id}")
	public List<ParamModTarifaria> buscarPelaDistribuidora(@PathVariable Long id) {
		return paramModTarifariaService.buscarPelaDistribuidora(id);
	}
	
}