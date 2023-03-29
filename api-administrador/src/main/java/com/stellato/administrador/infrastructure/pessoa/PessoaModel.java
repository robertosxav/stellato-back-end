package com.stellato.administrador.infrastructure.pessoa;

import java.io.Serializable;
import java.time.LocalDate;

import com.stellato.administrador.infrastructure.shared.BaseModel;

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

@Table(name = "TB_PESSOA",schema = "ADMINISTRADOR")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_PESSOA")
	@SequenceGenerator(name = "SEQUENCE_PESSOA",sequenceName = "administrador.tb_pessoa_seq",allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name= "NOME")
	private String nome;
	
	@Column(name= "CPF")
	private String cpf;
	
	@Column(name="NOME_FANTASIA")
	private String nomeFantasia;
	
	@Column(name="CNPJ")
	private String cnpj;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@Column(name="WHATSAPP")
	private String whatsapp;
	
	@Column(name="EMAIL")
	private String email;
	
	public PessoaModel(Long id, String nome,String cpf,String nomeFantasia,String cnpj,String telefone, String whatsapp,
			String email,Integer status, LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.whatsapp = whatsapp;
		this.email = email;
	}
	
	public PessoaModel(String nome,String cpf,String nomeFantasia,String cnpj,String telefone, String whatsapp, 
			String email,Integer status, LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.nome = nome;
		this.cpf = cpf;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.whatsapp = whatsapp;
		this.email = email;
	}	
	
}
