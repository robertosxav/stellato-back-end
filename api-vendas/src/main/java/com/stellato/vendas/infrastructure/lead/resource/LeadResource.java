package com.stellato.vendas.infrastructure.lead.resource;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/lead")
public class LeadResource {

	@Autowired
	LeadService leadService;
	
	@PostMapping()
	public ResponseEntity<LeadEntity> createLead(@RequestBody LeadEntity leadEntity) throws Exception {
		LeadEntity leadEntitySave = leadService.create(leadEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(leadEntitySave);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LeadEntity> updateLead(@PathVariable BigDecimal id,@RequestBody LeadEntity leadEntity) throws Exception {
		LeadEntity leadEntityUpdated = leadService.update(id,leadEntity);
		return ResponseEntity.ok(leadEntityUpdated);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LeadEntity> findLead(@PathVariable BigDecimal id) {
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLead(@PathVariable BigDecimal id) throws Exception {
		leadService.deleteLead(id);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
}
