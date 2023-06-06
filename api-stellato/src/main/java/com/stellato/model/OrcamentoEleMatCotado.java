package com.stellato.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orcamento_ele_mat_cotado") 
public class OrcamentoEleMatCotado implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "orcamento_ele_mat_cotado_id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "material_cotado_id",referencedColumnName = "material_cotado_id")
	private MaterialCotado materialCotado;

	@ManyToOne()
	@JoinColumn(name = "orcamento_eletrico_id",referencedColumnName = "orcamento_eletrico_id")
	private OrcamentoEletrico orcamentoEletrico;

	@Column(name = "orcamento_ele_mat_cotado_qtd")
	private Integer qtd;

	@Column(name = "orcamento_ele_mat_cotado_valor")
	private String valor;
	
	@Column(name = "orcamento_ele_mat_status")
	private Integer status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "orcamento_ele_mat_criado_em")
	private LocalDate criadoEm;

	@Column(name = "funil_vendas_criado_por")
	private Integer criadoPor;

}