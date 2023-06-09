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

import com.stellato.model.FunilVendas;
import com.stellato.service.FunilVendasService;

@RestController
@RequestMapping("/funilvenda")
public class FunilVendasResource {

	@Autowired
	private FunilVendasService funilvendasService;

	@PostMapping
	public ResponseEntity<FunilVendas> criar(@Valid @RequestBody FunilVendas funilvendas, HttpServletResponse response) {
		 FunilVendas funilvendasSalva = funilvendasService.salvar(funilvendas);
		return ResponseEntity.status(HttpStatus.CREATED).body(funilvendasSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<FunilVendas> buscarPeloCodigo(@PathVariable Long codigo) {
		FunilVendas funilvendas = funilvendasService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(funilvendas);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<FunilVendas> atualizar(@PathVariable Long codigo, @Valid @RequestBody FunilVendas funilvendas) {
		FunilVendas funilvendasSalva = funilvendasService.atualizar(codigo, funilvendas);
		return ResponseEntity.ok(funilvendasSalva);
	}

	@GetMapping
	public Page<FunilVendas> pesquisar(Pageable pageable) {
		return funilvendasService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<FunilVendas> pesquisar() {
		return funilvendasService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		funilvendasService.remover(codigo);
	}
	@GetMapping("/ativos/paginado")
	public Page<FunilVendas> listarTodosAtivos(Pageable pageable) {
		return funilvendasService.listarTodosAtivos(pageable);
	}

	@GetMapping("/ativos")
	public List<FunilVendas> listarTodosAtivos() {
		return funilvendasService.listarTodosAtivos();
	}
	
	@GetMapping("/buscagenerica")
	public Page<FunilVendas> buscaGenerica(@RequestParam String pesquisa,Pageable pageable) {
		return funilvendasService.buscaGenerica(pesquisa,pageable);
	}

}