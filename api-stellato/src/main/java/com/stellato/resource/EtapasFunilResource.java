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

import com.stellato.model.EtapasFunil;
import com.stellato.service.EtapasFunilService;

@RestController
@RequestMapping("/etapasfunil")
public class EtapasFunilResource {

	@Autowired
	private EtapasFunilService etapasFunilService;

	@PostMapping
	public ResponseEntity<EtapasFunil> criar(@Valid @RequestBody EtapasFunil etapasFunil) {
		EtapasFunil etapasFunilSalva = etapasFunilService.salvar(etapasFunil);
		return ResponseEntity.status(HttpStatus.CREATED).body(etapasFunilSalva);
	}
	
	@PutMapping("/ordenarfunil")
	public ResponseEntity<String> ordenarFunil(@Valid @RequestBody List<EtapasFunil> listaEtapasFunil) {
		etapasFunilService.ordenarFunil(listaEtapasFunil);
		return ResponseEntity.ok("Etapas ordenadas com sucesso");
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<EtapasFunil> buscarPeloCodigo(@PathVariable Long codigo) {
		EtapasFunil etapasfunil = etapasFunilService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(etapasfunil);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<EtapasFunil> atualizar(@PathVariable Long codigo, @Valid @RequestBody EtapasFunil etapasfunil) {
		EtapasFunil etapasfunilSalva = etapasFunilService.atualizar(codigo, etapasfunil);
		return ResponseEntity.ok(etapasfunilSalva);
	}

	@GetMapping
	public Page<EtapasFunil> pesquisar(Pageable pageable) {
		return etapasFunilService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<EtapasFunil> pesquisar() {
		return etapasFunilService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		etapasFunilService.remover(codigo);
	}
	
	@GetMapping("/ativos/paginado")
	public Page<EtapasFunil> listarTodosAtivos(Pageable pageable) {
		return etapasFunilService.listarTodosAtivos(pageable);
	}

	@GetMapping("/ativos")
	public List<EtapasFunil> listarTodosAtivos() {
		return etapasFunilService.listarTodosAtivos();
	}
	
	@GetMapping("/buscagenerica")
	public Page<EtapasFunil> buscaGenerica(@RequestParam String pesquisa,Pageable pageable) {
		return etapasFunilService.buscaGenerica(pesquisa,pageable);
	}
	
	@GetMapping("/buscarpelofunil/{id}")
	public List<EtapasFunil> buscarPeloFunil(@PathVariable Long id) {
		return etapasFunilService.buscarPeloFunil(id);
	}
}