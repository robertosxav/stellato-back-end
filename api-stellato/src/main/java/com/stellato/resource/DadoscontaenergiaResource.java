package com.stellato.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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

import com.stellato.model.Dadoscontaenergia;
import com.stellato.service.DadoscontaenergiaService;
import br.gov.mt.gestao.thanos.event.RecursoCriadoEvent;

@RestController
@RequestMapping("/dadoscontaenergias")
public class DadoscontaenergiaResource {

	@Autowired
	private DadoscontaenergiaService dadoscontaenergiaService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Dadoscontaenergia> criar(@Valid @RequestBody Dadoscontaenergia dadoscontaenergia, HttpServletResponse response) {
		 Dadoscontaenergia dadoscontaenergiaSalva = dadoscontaenergiaService.salvar(dadoscontaenergia);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, dadoscontaenergiaSalva.getDadoscontaenergiaid()));
		return ResponseEntity.status(HttpStatus.CREATED).body(dadoscontaenergiaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Dadoscontaenergia> buscarPeloCodigo(@PathVariable Long codigo) {
		Dadoscontaenergia dadoscontaenergia = dadoscontaenergiaService.buscarPeloCodigo(codigo);
		return dadoscontaenergia != null ? ResponseEntity.ok(dadoscontaenergia) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Dadoscontaenergia> atualizar(@PathVariable Long codigo, @Valid @RequestBody Dadoscontaenergia dadoscontaenergia) {
		Dadoscontaenergia dadoscontaenergiaSalva = dadoscontaenergiaService.atualizar(codigo, dadoscontaenergia);
		return ResponseEntity.ok(dadoscontaenergiaSalva);
	}

	@GetMapping
	public Page<Dadoscontaenergia> pesquisar(Pageable pageable) {
		return dadoscontaenergiaService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Dadoscontaenergia> pesquisar() {
		return dadoscontaenergiaService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		dadoscontaenergiaService.remover(codigo);
	}

}