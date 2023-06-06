CREATE TABLE etapas_funil (etapas_funil_id smallint NOT NULL , funil_vendas_id smallint NOT NULL , etapas_funil_etapa VARCHAR(100) NOT NULL , etapas_funil_status smallint NOT NULL , etapas_funil_criado_em date NOT NULL,etapas_funil_criado_por smallint,PRIMARY KEY(etapas_funil_id));
CREATE INDEX IETAPASFUNIL1 ON etapas_funil (funil_vendas_id);

CREATE TABLE funil_vendas (funil_vendas_id smallint NOT NULL , funil_vendas_descricao VARCHAR(250) NOT NULL , funil_vendas_status smallint NOT NULL, funil_vendas_criado_em date NOT NULL, funil_vendas_criado_por smallint,PRIMARY KEY(funil_vendas_id));

CREATE TABLE orcamento_ele_arquivo (orcamento_ele_arquivo_id smallint NOT NULL , orcamento_eletrico_id smallint NOT NULL, arquivo_id smallint NOT NULL , orcamento_ele_arquivo_status smallint NOT NULL, orcamento_ele_arquivo_criado_em date NOT NULL,orcamento_ele_arquivo_criado_por smallint, PRIMARY KEY(orcamento_ele_arquivo_id));
CREATE INDEX IORCAMENTOELEARQUIVO1 ON orcamento_ele_arquivo (arquivo_id);
CREATE INDEX IORCAMENTOELEARQUIVO2 ON orcamento_ele_arquivo (orcamento_eletrico_id);

CREATE TABLE arquivo (arquivo_id smallint NOT NULL , arquivo_nome VARCHAR(100) NOT NULL , arquivo_extensao VARCHAR(10) NOT NULL , arquivo_status smallint NOT NULL , arquivo_criado_em date NOT NULL,arquivo_criado_por smallint,arquivo_blob BYTEA NOT NULL , PRIMARY KEY(arquivo_id));

CREATE TABLE modalidade_tarifaria (modalidade_tarifaria_id smallint NOT NULL , distribuidora_id smallint NOT NULL , modalidade_tarifaria_valor NUMERIC(8,2) NOT NULL , modalidade_tarifaria_status smallint NOT NULL , modalidade_tarifaria_criado_em date NOT NULL,modalidade_tarifaria_criado_por smallint,PRIMARY KEY(modalidade_tarifaria_id));
CREATE INDEX IMODALIDADETARIFARIA1 ON modalidade_tarifaria (distribuidora_id);

CREATE TABLE distribuidora (distribuidora_id smallint NOT NULL , distribuidora_nome VARCHAR(200) NOT NULL , distribuidora_sigla VARCHAR(40) NOT NULL , distribuidora_status smallint NOT NULL, distribuidora_criado_em date NOT NULL , distribuidora_criardo_por smallint, PRIMARY KEY(Distribuidora_id));

CREATE TABLE dimensionamento (dimensionamento_id smallint NOT NULL , orcamento_eletrico_id smallint NOT NULL , dimensionamento_pot_modulo NUMERIC(8,2) NOT NULL , dimensionamento_perc_perda NUMERIC(8,2) NOT NULL , dimensionamento_area_modu NUMERIC(8,2) NOT NULL , dimensionamento_status smallint NOT NULL, dimensionamento_criado_em date NOT NULL , dimensionamento_criardo_por smallint, PRIMARY KEY(dimensionamento_id));
CREATE INDEX IDIMENSIONAMENTO1 ON dimensionamento (orcamento_eletrico_id);

CREATE TABLE dados_conta_energia (dados_conta_energia_id smallint NOT NULL , orcamento_eletrico_id smallint NOT NULL , dados_conta_energia_uc VARCHAR(20) NOT NULL , dados_conta_energia_descricao_uc VARCHAR(100) NOT NULL , dados_conta_energia_tipo_padrao smallint NOT NULL , dados_conta_energia_mod_tarifa smallint NOT NULL , dados_conta_energia_preco_kwh NUMERIC(8,2) NOT NULL , dados_conta_energia_consumo_medio NUMERIC(8,2) NOT NULL,dados_conta_energia_status smallint NOT NULL, dados_conta_energia_criado_em date NOT NULL , dados_conta_energia_criardo_por smallint,PRIMARY KEY(dados_conta_energia_id));
CREATE INDEX IDADOSCONTAENERGIA1 ON dados_conta_energia (orcamento_eletrico_id);

CREATE TABLE orcamento_ele_mat_cotado (orcamento_ele_mat_cotado_id smallint NOT NULL , material_cotado_id smallint NOT NULL , orcamento_eletrico_id smallint NOT NULL , orcamento_ele_mat_cotado_qtd smallint NOT NULL , orcamento_ele_mat_cotado_valor NUMERIC(8,2) NOT NULL, orcamento_ele_mat_status smallint NOT NULL, orcamento_ele_mat_criado_em date NOT NULL, orcamento_ele_mat_criardo_por smallint ,PRIMARY KEY(orcamento_ele_mat_cotado_id));
CREATE INDEX IORCAMENTOELEMATCOTADO1 ON orcamento_ele_mat_cotado (orcamento_eletrico_id);
CREATE INDEX IORCAMENTOELEMATCOTADO2 ON orcamento_ele_mat_cotado (material_cotado_id);

CREATE TABLE material_cotado (material_cotado_id smallint NOT NULL , material_cotado_observacao VARCHAR(1000) NOT NULL , material_cotado_valor NUMERIC(8,2) NOT NULL , fornecedor_id smallint NOT NULL , material_id smallint NOT NULL , material_cotado_descricao VARCHAR(500) NOT NULL, material_cotado_status smallint NOT NULL, material_cotado_criado_em date NOT NULL, material_cotado_criardo_por smallint, PRIMARY KEY(material_cotado_id));
CREATE INDEX IMATERIALCOTADO1 ON material_cotado (fornecedor_id);
CREATE INDEX IMATERIALCOTADO2 ON material_cotado (material_id);

CREATE TABLE orcamento_eletrico (orcamento_eletrico_id smallint NOT NULL , lead_id smallint NOT NULL , orcamento_eletrico_titulo VARCHAR(100) NOT NULL , orcamento_eletrico_observacao VARCHAR(1000) NOT NULL ,orcamento_eletrico_observacao_int VARCHAR(1000) NOT NULL , oorcamento_eletrico_validade_propo smallint NOT NULL , orcamento_eletrico_prazo_entrega smallint NOT NULL , orcamento_eletrico_distancia smallint NOT NULL , orcamento_eletrico_detalhes_propo VARCHAR(1000) NOT NULL , orcamento_eletrico_tipo_instalacao smallint NOT NULL , orcamento_eletrico_tipo_estrutura smallint NOT NULL , etapas_funil_id smallint NOT NULL , orcamento_eletrico_status smallint NOT NULL, orcamento_eletrico_criado_em date NOT NULL, orcamento_eletrico_criardo_por smallint ,PRIMARY KEY(orcamento_eletrico_id));
CREATE INDEX IORCAMENTOELETRICO1 ON orcamento_eletrico (lead_id);
CREATE INDEX IORCAMENTOELETRICO2 ON orcamento_eletrico (etapas_funil_id);

CREATE TABLE fornecedor (fornecedor_id smallint NOT NULL , fornecedor_nome VARCHAR(200) NOT NULL ,fornecedor_status smallint NOT NULL, fornecedor_criado_em date NOT NULL, fornecedor_criardo_por smallint, PRIMARY KEY(fornecedor_id));

CREATE TABLE material (material_id smallint NOT NULL , material_descricao VARCHAR(500) NOT NULL , material_tipo smallint NOT NULL , material_unidade_medida smallint NOT NULL ,  material_status smallint NOT NULL, material_criado_em date NOT NULL, material_criardo_por smallint,PRIMARY KEY(material_id));

CREATE TABLE pessoa (pessoa_id smallint NOT NULL , pessoa_nome VARCHAR(200) NOT NULL , pessoa_cpf CHAR(11) NOT NULL , pessoa_nome_fantasia VARCHAR(200) NOT NULL , pessoa_cnpj CHAR(14) NOT NULL , pessoa_telefone CHAR(20) NOT NULL , pessoa_whatsapp VARCHAR(12) NOT NULL , pessoa_email VARCHAR(100) NOT NULL , pessoa_tipo_pessoa smallint NOT NULL , pessoa_status smallint NOT NULL, pessoa_criado_em date NOT NULL, pessoa_criardo_por smallint,PRIMARY KEY(pessoa_id));

CREATE TABLE historico (historico_id smallint NOT NULL , PRIMARY KEY(historico_id));

CREATE TABLE lead (lead_id smallint NOT NULL , lead_nome VARCHAR(200) NOT NULL , lead_telefone VARCHAR(12) NOT NULL , pessoa_id smallint , lead_whatsapp VARCHAR(12) NOT NULL , lead_email VARCHAR(100) NOT NULL , lead_cidade VARCHAR(40) NOT NULL , lead_origem smallint NOT NULL , lead_tipo smallint NOT NULL, lead_status smallint NOT NULL, lead_criado_em date NOT NULL, lead_criardo_por smallint, PRIMARY KEY(lead_id));
CREATE INDEX ILEAD1 ON Lead (pessoa_id);

ALTER TABLE lead ADD CONSTRAINT ILEAD1 FOREIGN KEY (pessoa_id) REFERENCES pessoa (pessoa_id);

ALTER TABLE fornecedor ADD CONSTRAINT IFORNECEDOR FOREIGN KEY (fornecedor_id) REFERENCES pessoa (pessoa_id);

ALTER TABLE orcamento_eletrico ADD CONSTRAINT IORCAMENTOELETRICO1 FOREIGN KEY (lead_id) REFERENCES Lead (lead_id);
ALTER TABLE orcamento_eletrico ADD CONSTRAINT IORCAMENTOELETRICO2 FOREIGN KEY (etapas_funil_id) REFERENCES etapas_funil (etapas_funil_id);

ALTER TABLE material_cotado ADD CONSTRAINT IMATERIALCOTADO1 FOREIGN KEY (fornecedor_id) REFERENCES fornecedor (fornecedor_id);
ALTER TABLE material_cotado ADD CONSTRAINT IMATERIALCOTADO2 FOREIGN KEY (material_id) REFERENCES material (material_id);

ALTER TABLE orcamento_ele_mat_cotado ADD CONSTRAINT IORCAMENTOELEMATCOTADO2 FOREIGN KEY (material_cotado_id) REFERENCES material_cotado (material_cotado_id);
ALTER TABLE orcamento_ele_mat_cotado ADD CONSTRAINT IORCAMENTOELEMATCOTADO1 FOREIGN KEY (orcamento_eletrico_id) REFERENCES orcamento_eletrico (orcamento_eletrico_id);

ALTER TABLE dados_conta_energia ADD CONSTRAINT IDADOSCONTAENERGIA1 FOREIGN KEY (orcamento_eletrico_id) REFERENCES orcamento_eletrico (orcamento_eletrico_id);

ALTER TABLE dimensionamento ADD CONSTRAINT IDIMENSIONAMENTO1 FOREIGN KEY (orcamento_eletrico_id) REFERENCES orcamento_eletrico (orcamento_eletrico_id);

ALTER TABLE modalidade_tarifaria ADD CONSTRAINT IMODALIDADETARIFARIA1 FOREIGN KEY (distribuidora_id) REFERENCES distribuidora (distribuidora_id);

ALTER TABLE orcamento_ele_arquivo ADD CONSTRAINT IORCAMENTOELEARQUIVO2 FOREIGN KEY (orcamento_eletrico_id) REFERENCES orcamento_eletrico (orcamento_eletrico_id);
ALTER TABLE orcamento_ele_arquivo ADD CONSTRAINT IORCAMENTOELEARQUIVO1 FOREIGN KEY (arquivo_id) REFERENCES arquivo (arquivo_id);

ALTER TABLE etapas_funil ADD CONSTRAINT IETAPASFUNIL1 FOREIGN KEY (funil_vendas_id) REFERENCES funil_vendas (funil_vendas_id);

