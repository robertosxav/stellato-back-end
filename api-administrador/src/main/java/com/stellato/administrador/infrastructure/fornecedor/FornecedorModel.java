package com.stellato.administrador.infrastructure.fornecedor;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stellato.administrador.infrastructure.shared.BaseModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_FORNECEDOR",schema = "ADMINISTRADOR")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name ="RAZAO_SOCIAL")
	private String razaoSocial;
	
	@Column(name="CNPJ")
	private String cnpj;
	
	public FornecedorModel(Long id, String razaoSocial,String cnpj, Integer status, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super(status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}
    
	public FornecedorModel(String razaoSocial,String cnpj, Integer status, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super(status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}


}
