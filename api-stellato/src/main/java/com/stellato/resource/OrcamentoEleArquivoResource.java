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

import com.stellato.model.OrcamentoEleArquivo;
import com.stellato.service.OrcamentoelearquivoService;

@RestController
@RequestMapping("/orcamentoelearquivos")
public class OrcamentoEleArquivoResource {

	@Autowired
	private OrcamentoelearquivoService orcamentoelearquivoService;

	@PostMapping
	public ResponseEntity<OrcamentoEleArquivo> criar(@Valid @RequestBody OrcamentoEleArquivo orcamentoelearquivo, HttpServletResponse response) {
		 OrcamentoEleArquivo orcamentoelearquivoSalva = orcamentoelearquivoService.salvar(orcamentoelearquivo);
		return ResponseEntity.status(HttpStatus.CREATED).body(orcamentoelearquivoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OrcamentoEleArquivo> buscarPeloCodigo(@PathVariable Long codigo) {
		OrcamentoEleArquivo orcamentoelearquivo = orcamentoelearquivoService.buscarPeloCodigo(codigo);
		return orcamentoelearquivo != null ? ResponseEntity.ok(orcamentoelearquivo) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrcamentoEleArquivo> atualizar(@PathVariable Long codigo, @Valid @RequestBody OrcamentoEleArquivo orcamentoelearquivo) {
		OrcamentoEleArquivo orcamentoelearquivoSalva = orcamentoelearquivoService.atualizar(codigo, orcamentoelearquivo);
		return ResponseEntity.ok(orcamentoelearquivoSalva);
	}

	@GetMapping
	public Page<OrcamentoEleArquivo> pesquisar(Pageable pageable) {
		return orcamentoelearquivoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<OrcamentoEleArquivo> pesquisar() {
		return orcamentoelearquivoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		orcamentoelearquivoService.remover(codigo);
	}

}