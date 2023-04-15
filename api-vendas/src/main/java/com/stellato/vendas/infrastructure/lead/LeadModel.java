package com.stellato.vendas.infrastructure.lead;

import java.io.Serializable;
import java.time.LocalDate;

import com.stellato.vendas.infrastructure.shared.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_LEAD",schema = "VENDAS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeadModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_LEAD")
	@SequenceGenerator(name = "SEQUENCE_LEAD",sequenceName = "vendas.tb_lead_seq",allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	private String nome;
	
	private String telefone;
	
	@Column(name = "WHATSAPP")
	private String whatsApp;
	
	private String email;
	
	private String cidade;
	
	private Integer origem;
	
	private Integer tipoLead;
	
	private Long idPessoa;

	public LeadModel(Long id, String codigo, String nome, String telefone, String whatsApp, String email, String cidade,
			Integer origem, Integer tipoLead, Long idPessoa, Integer status, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super(codigo, status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.email = email;
		this.cidade = cidade;
		this.origem = origem;
		this.tipoLead = tipoLead;
		this.idPessoa = idPessoa;
	}
	
	public LeadModel(String nome, String codigo,String telefone, String whatsApp, String email, String cidade,
			Integer origem, Integer tipoLead, Long idPessoa, Integer status, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super(codigo, status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.nome = nome;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.email = email;
		this.cidade = cidade;
		this.origem = origem;
		this.tipoLead = tipoLead;
		this.idPessoa = idPessoa;
		
	}
}
