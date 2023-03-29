package com.stellato.vendas.infrastructure.lead.resource;

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

import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.infrastructure.lead.service.LeadService;
import com.stellato.vendas.infrastructure.lead.service.ScoreCalculatorService;

@RestController
@RequestMapping("/lead")
public class LeadResource {

	@Autowired
	LeadService leadService;
	
	@Autowired
	ScoreCalculatorService scoreCalculatorService;
	
	@PostMapping()
	public ResponseEntity<LeadEntity> createLead(@RequestBody LeadEntity leadEntity) throws Exception {
		LeadEntity leadEntitySave = leadService.create(leadEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(leadEntitySave);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LeadEntity> updateLead(@PathVariable Long id,@RequestBody LeadEntity leadEntity) throws Exception {
		LeadEntity leadEntityUpdated = leadService.update(id,leadEntity);
		return ResponseEntity.ok(leadEntityUpdated);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LeadEntity> findLead(@PathVariable Long id) {
		return ResponseEntity.ok(leadService.findById(id));
	}
	
	@GetMapping("/all")
	public List<LeadEntity> findAllLeads() throws Exception {
		return leadService.findAll();
	}
	
	@GetMapping("/ativos")
	public List<LeadEntity> findAllLeadsActives() throws Exception {
		return leadService.findAllActives();
	}
	
	@GetMapping("/ativos/paginado")
	public Page<LeadEntity> findAllActivesPage(Pageable pageable) throws Exception {
		return leadService.findAllActivesPage(pageable);
	}
	
	@GetMapping("/nome/{nome}")
	public Page<LeadEntity> findByName(@PathVariable String nome, Pageable pageable) throws Exception {
		return leadService.findByName(nome,pageable);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLead(@PathVariable Long id) throws Exception {
		leadService.deleteLead(id);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
	@GetMapping("/teste")
	public ResponseEntity<String> teste(){
		Integer i = scoreCalculatorService.getCityScore(600);
		return ResponseEntity.ok(i.toString());
	}
}
