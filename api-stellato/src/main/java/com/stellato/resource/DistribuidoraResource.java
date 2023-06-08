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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stellato.model.Distribuidora;
import com.stellato.service.DistribuidoraService;

@RestController
@RequestMapping("/distribuidora")
public class DistribuidoraResource {

	@Autowired
	private DistribuidoraService distribuidoraService;

	@PostMapping
	public ResponseEntity<Distribuidora> criar(@Valid @RequestBody Distribuidora distribuidora, HttpServletResponse response) {
		 Distribuidora distribuidoraSalva = distribuidoraService.salvar(distribuidora);
		return ResponseEntity.status(HttpStatus.CREATED).body(distribuidoraSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Distribuidora> buscarPeloCodigo(@PathVariable Long codigo) {
		Distribuidora distribuidora = distribuidoraService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(distribuidora);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Distribuidora> atualizar(@PathVariable Long codigo, @Valid @RequestBody Distribuidora distribuidora) {
		Distribuidora distribuidoraSalva = distribuidoraService.atualizar(codigo, distribuidora);
		return ResponseEntity.ok(distribuidoraSalva);
	}

	@GetMapping
	public Page<Distribuidora> pesquisar(Pageable pageable) {
		return distribuidoraService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Distribuidora> pesquisar() {
		return distribuidoraService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		distribuidoraService.remover(codigo);
	}
	
	@GetMapping("/ativos/paginado")
	public Page<Distribuidora> listarTodosAtivos(Pageable pageable) {
		return distribuidoraService.listarTodosAtivos(pageable);
	}

	@GetMapping("/ativos")
	public List<Distribuidora> listarTodosAtivos() {
		return distribuidoraService.listarTodosAtivos();
	}
	
	@GetMapping("/buscagenerica")
	public Page<Distribuidora> buscaGenerica(@RequestParam String pesquisa,Pageable pageable) {
		return distribuidoraService.buscaGenerica(pesquisa,pageable);
	}

}