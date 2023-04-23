package com.stellato.vendas.infrastructure.orcamentoMaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stellato.vendas.infrastructure.orcamentoMaterial.OrcamentoMaterialModel;

@Repository
public interface OrcamentoMaterialRepository extends JpaRepository<OrcamentoMaterialModel, Long>{

}
