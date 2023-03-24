package com.stellato.administrador.infrastructure.pessoa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.stellato.administrador.infrastructure.shared.BaseModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "TB_PESSOA",schema = "ADMINISTRADOR")
@Entity
//@Getter
//@Setter
public class PessoaModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_LEAD")
	@SequenceGenerator(name = "SEQUENCE_LEAD",sequenceName = "vendas.tb_lead_seq",allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String nomeFantasia;
	
	private String cnpj;
	
	private String telefone;
	
	private String whatsapp;
	
	private String email;
	
	private String cidade;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getWhatsapp() {
		return whatsapp;
	}


	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}



	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getwhatsapp() {
		return whatsapp;
	}


	public void setwhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public PessoaModel() {
		super();
	
	}


	public PessoaModel(Long id, String nome,String cpf,String nomeFantasia,String cnpj,String telefone, String whatsapp,
			String email, String cidade,Integer status, LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.whatsapp = whatsapp;
		this.email = email;
		this.cidade = cidade;
	}
	
	public PessoaModel(String nome,String cpf,String nomeFantasia,String cnpj,String telefone, String whatsapp, 
			String email, String cidade,Integer status, LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(status, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.nome = nome;
		this.cpf = cpf;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.whatsapp = whatsapp;
		this.email = email;
		this.cidade = cidade;
	}


	@Override
	public String toString() {
		return "PessoaModel [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", whatsapp=" + whatsapp
				+ ", email=" + email + ", cidade=" + cidade + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaModel other = (PessoaModel) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
