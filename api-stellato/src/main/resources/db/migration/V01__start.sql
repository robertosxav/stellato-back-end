CREATE TABLE EtapasFunil (EtapasFunilId smallint NOT NULL , FunilVendasId smallint NOT NULL , EtapasFunilEtapa VARCHAR(100) NOT NULL , EtapasFunilStatus smallint NOT NULL , PRIMARY KEY(EtapasFunilId));
CREATE INDEX IETAPASFUNIL1 ON EtapasFunil (FunilVendasId );

CREATE TABLE FunilVendas (FunilVendasId smallint NOT NULL , FunilVendasDescricao VARCHAR(250) NOT NULL , FunilVendasStatus smallint NOT NULL , PRIMARY KEY(FunilVendasId));

CREATE TABLE OrcamentoEleArquivo (OrcamentoEleArquivoId smallint NOT NULL , OrcamentoEletricoId smallint NOT NULL , ArquivoId smallint NOT NULL , OrcamentoEleArquivoStatus smallint NOT NULL , PRIMARY KEY(OrcamentoEleArquivoId));
CREATE INDEX IORCAMENTOELEARQUIVO1 ON OrcamentoEleArquivo (ArquivoId );
CREATE INDEX IORCAMENTOELEARQUIVO2 ON OrcamentoEleArquivo (OrcamentoEletricoId );

CREATE TABLE Arquivo (ArquivoId smallint NOT NULL , ArquivoNome VARCHAR(100) NOT NULL , ArquivoExtensao VARCHAR(10) NOT NULL , ArquivoStatus smallint NOT NULL , ArquivoBlob BYTEA NOT NULL , PRIMARY KEY(ArquivoId));

CREATE TABLE ModalidadeTarifaria (ModalidadeTarifariaId smallint NOT NULL , DistribuidoraId smallint NOT NULL , ModalidadeTarifariaValor NUMERIC(8,2) NOT NULL , ModalidadeTarifariaStatus smallint NOT NULL , PRIMARY KEY(ModalidadeTarifariaId));
CREATE INDEX IMODALIDADETARIFARIA1 ON ModalidadeTarifaria (DistribuidoraId );

CREATE TABLE Distribuidora (DistribuidoraId smallint NOT NULL , DistribuidoraNome VARCHAR(200) NOT NULL , DistribuidoraSigla VARCHAR(40) NOT NULL , DistribuidoraStatus smallint NOT NULL , DistribuidoraCriadoPor smallint NOT NULL , DistribuidoraCriadoEm date NOT NULL , DistribuidoraCriardoPorn VARCHAR(100) NOT NULL , DistribuidoraAlteradoEm date NOT NULL , DistribuidoraAlteradoPor smallint NOT NULL , DistribuidoraAlteradoPorn VARCHAR(100) NOT NULL , PRIMARY KEY(DistribuidoraId));

CREATE TABLE Dimensionamento (DimensionamentoId smallint NOT NULL , OrcamentoEletricoId smallint NOT NULL , DimensionamentoPotModulo NUMERIC(8,2) NOT NULL , DimensionamentoPercPerda NUMERIC(8,2) NOT NULL , DimensionamentoAreaModu NUMERIC(8,2) NOT NULL , DimensionamentoStatus smallint NOT NULL , PRIMARY KEY(DimensionamentoId));
CREATE INDEX IDIMENSIONAMENTO1 ON Dimensionamento (OrcamentoEletricoId );

CREATE TABLE DadosContaEnergia (DadosContaEnergiaId smallint NOT NULL , OrcamentoEletricoId smallint NOT NULL , DadosContaEnergiaUC VARCHAR(20) NOT NULL , DadosContaEnergiaDescricaoUC VARCHAR(100) NOT NULL , DadosContaEnergiaTipoPadrao smallint NOT NULL , DadosContaEnergiaModTarifa smallint NOT NULL , DadosContaEnergiaPrecoKwH NUMERIC(8,2) NOT NULL , DadosContaEnergiaConsumoMedio NUMERIC(8,2) NOT NULL , PRIMARY KEY(DadosContaEnergiaId));
CREATE INDEX IDADOSCONTAENERGIA1 ON DadosContaEnergia (OrcamentoEletricoId );

CREATE TABLE OrcamentoEleMatCotado (OrcamentoEleMatCotadoId smallint NOT NULL , MaterialCotadoId smallint NOT NULL , OrcamentoEletricoId smallint NOT NULL , OrcamentoEleMatCotadoQtd smallint NOT NULL , OrcamentoEleMatCotadoValor NUMERIC(8,2) NOT NULL , PRIMARY KEY(OrcamentoEleMatCotadoId));
CREATE INDEX IORCAMENTOELEMATCOTADO1 ON OrcamentoEleMatCotado (OrcamentoEletricoId );
CREATE INDEX IORCAMENTOELEMATCOTADO2 ON OrcamentoEleMatCotado (MaterialCotadoId );

CREATE TABLE MaterialCotado (MaterialCotadoId smallint NOT NULL , MaterialCotadoObservacao VARCHAR(1000) NOT NULL , MaterialCotadoValor NUMERIC(8,2) NOT NULL , FornecedorId smallint NOT NULL , MaterialId smallint NOT NULL , MaterialCotadoDescricao VARCHAR(500) NOT NULL , PRIMARY KEY(MaterialCotadoId));
CREATE INDEX IMATERIALCOTADO1 ON MaterialCotado (FornecedorId );
CREATE INDEX IMATERIALCOTADO2 ON MaterialCotado (MaterialId );

CREATE TABLE OrcamentoEletrico (OrcamentoEletricoId smallint NOT NULL , LeadId smallint NOT NULL , OrcamentoEletricoTitulo VARCHAR(100) NOT NULL , OrcamentoEletricoObservacao VARCHAR(1000) NOT NULL , OrcamentoEletricoObservacaoInt VARCHAR(1000) NOT NULL , OrcamentoEletricoValidadePropo smallint NOT NULL , OrcamentoEletricoPrazoEntrega smallint NOT NULL , OrcamentoEletricoDistancia smallint NOT NULL , OrcamentoEletricoDetalhesPropo VARCHAR(1000) NOT NULL , OrcamentoEletricoTipoInstalaca smallint NOT NULL , OrcamentoEletricoTipoEstrutura smallint NOT NULL , EtapasFunilId smallint NOT NULL , PRIMARY KEY(OrcamentoEletricoId));
CREATE INDEX IORCAMENTOELETRICO1 ON OrcamentoEletrico (LeadId );
CREATE INDEX IORCAMENTOELETRICO2 ON OrcamentoEletrico (EtapasFunilId );

CREATE TABLE Fornecedor (FornecedorId smallint NOT NULL , FornecedorNome VARCHAR(200) NOT NULL , Fornecedor smallint NOT NULL , PRIMARY KEY(FornecedorId));

CREATE TABLE Material (MaterialId smallint NOT NULL , MaterialDescricao VARCHAR(500) NOT NULL , MaterialTipo smallint NOT NULL , MaterialUnidadeMedida smallint NOT NULL , PRIMARY KEY(MaterialId));

CREATE TABLE Pessoa (PessoaId smallint NOT NULL , PessoaNome VARCHAR(200) NOT NULL , PessoaCPF CHAR(11) NOT NULL , PessoaNomeFantasia VARCHAR(200) NOT NULL , PessoaCNPJ CHAR(14) NOT NULL , PessoaTelefone CHAR(20) NOT NULL , PessoaWhatsapp VARCHAR(12) NOT NULL , PessoaEmail VARCHAR(100) NOT NULL , PessoaTipoPessoa smallint NOT NULL , PRIMARY KEY(PessoaId));

CREATE TABLE Historico (HistoricoId smallint NOT NULL , PRIMARY KEY(HistoricoId));

CREATE TABLE Lead (LeadId smallint NOT NULL , LeadNome VARCHAR(200) NOT NULL , LeadTelefone VARCHAR(12) NOT NULL , PessoaId smallint , LeadWhatsapp VARCHAR(12) NOT NULL , LeadEmail VARCHAR(100) NOT NULL , LeadCidade VARCHAR(40) NOT NULL , LeadOrigem smallint NOT NULL , LeadTipo smallint NOT NULL , PRIMARY KEY(LeadId));
CREATE INDEX ILEAD1 ON Lead (PessoaId );

ALTER TABLE Lead ADD CONSTRAINT ILEAD1 FOREIGN KEY (PessoaId) REFERENCES Pessoa (PessoaId);

ALTER TABLE Fornecedor ADD CONSTRAINT IFORNECEDOR FOREIGN KEY (FornecedorId) REFERENCES Pessoa (PessoaId);

ALTER TABLE OrcamentoEletrico ADD CONSTRAINT IORCAMENTOELETRICO1 FOREIGN KEY (LeadId) REFERENCES Lead (LeadId);
ALTER TABLE OrcamentoEletrico ADD CONSTRAINT IORCAMENTOELETRICO2 FOREIGN KEY (EtapasFunilId) REFERENCES EtapasFunil (EtapasFunilId);

ALTER TABLE MaterialCotado ADD CONSTRAINT IMATERIALCOTADO1 FOREIGN KEY (FornecedorId) REFERENCES Fornecedor (FornecedorId);
ALTER TABLE MaterialCotado ADD CONSTRAINT IMATERIALCOTADO2 FOREIGN KEY (MaterialId) REFERENCES Material (MaterialId);

ALTER TABLE OrcamentoEleMatCotado ADD CONSTRAINT IORCAMENTOELEMATCOTADO2 FOREIGN KEY (MaterialCotadoId) REFERENCES MaterialCotado (MaterialCotadoId);
ALTER TABLE OrcamentoEleMatCotado ADD CONSTRAINT IORCAMENTOELEMATCOTADO1 FOREIGN KEY (OrcamentoEletricoId) REFERENCES OrcamentoEletrico (OrcamentoEletricoId);

ALTER TABLE DadosContaEnergia ADD CONSTRAINT IDADOSCONTAENERGIA1 FOREIGN KEY (OrcamentoEletricoId) REFERENCES OrcamentoEletrico (OrcamentoEletricoId);

ALTER TABLE Dimensionamento ADD CONSTRAINT IDIMENSIONAMENTO1 FOREIGN KEY (OrcamentoEletricoId) REFERENCES OrcamentoEletrico (OrcamentoEletricoId);

ALTER TABLE ModalidadeTarifaria ADD CONSTRAINT IMODALIDADETARIFARIA1 FOREIGN KEY (DistribuidoraId) REFERENCES Distribuidora (DistribuidoraId);

ALTER TABLE OrcamentoEleArquivo ADD CONSTRAINT IORCAMENTOELEARQUIVO2 FOREIGN KEY (OrcamentoEletricoId) REFERENCES OrcamentoEletrico (OrcamentoEletricoId);
ALTER TABLE OrcamentoEleArquivo ADD CONSTRAINT IORCAMENTOELEARQUIVO1 FOREIGN KEY (ArquivoId) REFERENCES Arquivo (ArquivoId);

ALTER TABLE EtapasFunil ADD CONSTRAINT IETAPASFUNIL1 FOREIGN KEY (FunilVendasId) REFERENCES FunilVendas (FunilVendasId);

