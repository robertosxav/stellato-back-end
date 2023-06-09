package com.stellato.administrador.infrastructure.pessoa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.administrador.domain.fornecedor.entity.FornecedorEntity;
import com.stellato.administrador.domain.fornecedor.factory.FornecedorEntityFactory;
import com.stellato.administrador.domain.pessoa.entity.PessoaEntity;
import com.stellato.administrador.domain.pessoa.factory.PessoaEntityFactory;
import com.stellato.administrador.domain.shared.repository.RepositoryInterface;
import com.stellato.administrador.exceptions.StellatoException;
import com.stellato.administrador.infrastructure.fornecedor.FornecedorModel;
import com.stellato.administrador.infrastructure.fornecedor.repository.FornecedorRepository;
import com.stellato.administrador.infrastructure.fornecedor.service.FornecedorService;
import com.stellato.administrador.infrastructure.pessoa.PessoaModel;
import com.stellato.administrador.infrastructure.pessoa.factory.PessoaFactory;
import com.stellato.administrador.infrastructure.pessoa.repository.PessoaRepository;

@Service
public class PessoaService implements RepositoryInterface<PessoaEntity>{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaFactory factory; 
	
	@Autowired
	private PessoaEntityFactory entityFactory;
	
	@Autowired
	FornecedorService fornecedorService;
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@Override
	@Transactional
	public PessoaEntity create(PessoaEntity pessoaEntityFront){
	
		if (pessoaEntityFront.validar()) {
			pessoaEntityFront.Ativar();
			PessoaModel pessoaModel = factory.create(pessoaEntityFront);
			
			pessoaRepository.save(pessoaModel);
			
			pessoaEntityFront.SetId(pessoaModel.getId());
		
			gerarRegistroFornecedor(pessoaEntityFront);
			
			return pessoaEntityFront;
		}
		return null;
	}

	@Transactional
	private void gerarRegistroFornecedor(PessoaEntity pessoaEntity) {
		if (pessoaEntity.getIsFornecedor()) {
			FornecedorEntity fornecedorEntity 	=	new FornecedorEntity(pessoaEntity.getId(),pessoaEntity.getCodigo(),pessoaEntity.getNomeFantasia(), 
					pessoaEntity.getCnpj(),pessoaEntity.getCriadoEm(), pessoaEntity.getCriadoPor(), null, null);
			fornecedorService.create(fornecedorEntity);
		}
		
	}

	@Override
	@Transactional
	public PessoaEntity update(Long id, PessoaEntity pessoaEntityFront){
			
			pessoaEntityFront.Alterar(null);
			
			Optional<PessoaModel> pessoaModelBanco = pessoaRepository.findById(id);
			
			pessoaEntityFront.SetId(id);
			
			pessoaModelBanco.get().setNome(pessoaEntityFront.getNome());
			pessoaModelBanco.get().setCpf(pessoaEntityFront.getCpf());
			pessoaModelBanco.get().setNomeFantasia(pessoaEntityFront.getNomeFantasia());
			pessoaModelBanco.get().setCnpj(pessoaEntityFront.getCnpj());
			pessoaModelBanco.get().setTelefone(pessoaEntityFront.getTelefone());
			pessoaModelBanco.get().setWhatsapp(pessoaEntityFront.getWhatsApp());
			pessoaModelBanco.get().setStatus(pessoaEntityFront.getStatus().getNumero());
			pessoaModelBanco.get().setCriadoEm(pessoaEntityFront.getCriadoEm());
			pessoaModelBanco.get().setCriadoPor(pessoaEntityFront.getCriadoPor());
			pessoaModelBanco.get().setAlteradoEm(pessoaEntityFront.getAlteradoEm());
			pessoaModelBanco.get().setAlteradoPor(pessoaEntityFront.getAlteradoPor());
			pessoaRepository.save(pessoaModelBanco.get());
			
		return pessoaEntityFront;


	}

	@Override
	public PessoaEntity findById(Long id) {
		Optional<PessoaModel> pessoaModelSave = pessoaRepository.findById(id);
		
		 if (!pessoaModelSave.isPresent()) {
			 throw new StellatoException("Não foi encontrado nenhuma pessoa com o código: " + id);
		 }
		Optional <FornecedorModel> fornecedorModel = fornecedorRepository.findById(id);
		PessoaEntity pessoaEntity	=	entityFactory.create(pessoaModelSave.get());
		
		if(fornecedorModel.isPresent()) {
			pessoaEntity.setIsFornecedor(true);
		}
	
		return pessoaEntity;

	}

	@Override
	public List<PessoaEntity> findAll(){
		
		List<PessoaEntity> listaPessoaEntity = pessoaRepository.listarTodos();
		
		if (listaPessoaEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhuma pessoa cadastrada"); 
		}
		
		return listaPessoaEntity;
		
	}
	
	@Override
	public List<PessoaEntity> findAllActives(){
		
		List<PessoaEntity> listaPessoaEntity = pessoaRepository.listarAtivos();
		
		if (listaPessoaEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead ativo"); 
		}
	
		return listaPessoaEntity;
	
	}
	
	@Override
	public Page<PessoaEntity> findAllActivesPage(Pageable pageable) {
		Page<PessoaEntity> listaPessoaEntity = pessoaRepository.listarAtivos(pageable);
		return listaPessoaEntity;
	}
	
	public Page<PessoaEntity> findByName(String nome, Pageable pageable) {
		String nomeAux = "%"+nome.toUpperCase() +"%";
		Page<PessoaEntity> listaPessoaEntity = pessoaRepository.listarPorNome(nomeAux, pageable);
		return listaPessoaEntity;
	}
	
	
	public void deletePessoa(Long id) {
		PessoaEntity leadEntityBanco = findById(id);
		leadEntityBanco.Inativar();	
		PessoaModel pessoaModel	= factory.create(leadEntityBanco);
		pessoaRepository.save(pessoaModel);
		
	}

}
