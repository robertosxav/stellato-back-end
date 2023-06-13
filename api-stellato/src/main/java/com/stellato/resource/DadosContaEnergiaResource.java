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

import com.stellato.model.DadosContaEnergia;
import com.stellato.service.DadosContaEnergiaService;

@RestController
@RequestMapping("/dadoscontaenergia")
public class DadosContaEnergiaResource {

	@Autowired
	private DadosContaEnergiaService dadoscontaenergiaService;

	@PostMapping
	public ResponseEntity<DadosContaEnergia> criar(@Valid @RequestBody DadosContaEnergia dadoscontaenergia, HttpServletResponse response) {
		 DadosContaEnergia dadoscontaenergiaSalva = dadoscontaenergiaService.salvar(dadoscontaenergia);
		return ResponseEntity.status(HttpStatus.CREATED).body(dadoscontaenergiaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<DadosContaEnergia> buscarPeloCodigo(@PathVariable Long codigo) {
		DadosContaEnergia dadoscontaenergia = dadoscontaenergiaService.buscarPeloCodigo(codigo);
		return dadoscontaenergia != null ? ResponseEntity.ok(dadoscontaenergia) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<DadosContaEnergia> atualizar(@PathVariable Long codigo, @Valid @RequestBody DadosContaEnergia dadoscontaenergia) {
		DadosContaEnergia dadoscontaenergiaSalva = dadoscontaenergiaService.atualizar(codigo, dadoscontaenergia);
		return ResponseEntity.ok(dadoscontaenergiaSalva);
	}

	@GetMapping
	public Page<DadosContaEnergia> pesquisar(Pageable pageable) {
		return dadoscontaenergiaService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<DadosContaEnergia> pesquisar() {
		return dadoscontaenergiaService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		dadoscontaenergiaService.remover(codigo);
	}

}