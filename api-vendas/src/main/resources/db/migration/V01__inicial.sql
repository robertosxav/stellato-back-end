CREATE SCHEMA administrador;
CREATE SCHEMA vendas;

CREATE TABLE "administrador"."tb_pessoa"(
    "id" BIGINT NOT NULL,
	"codigo" VARCHAR(40) NULL,
    "nome" VARCHAR(200) NOT NULL,
    "cpf" VARCHAR(11) NOT NULL,
    "nome_fantasia" VARCHAR(300) NOT NULL,
    "cnpj" VARCHAR(14) NOT NULL,
    "telefone" VARCHAR(14) NOT NULL,
    "whatsapp" VARCHAR(14) NOT NULL,
    "email" VARCHAR(100) NOT NULL,
    "tipo_pessoa" INTEGER NOT NULL,
    "status" NUMERIC(1) NOT NULL DEFAULT '1',
    "criado_em" DATE NULL,
    "criado_por" BIGINT NULL,
    "alterado_em" DATE NULL,
    "alterado_por" BIGINT NULL
);
CREATE INDEX "tb_pessoa_id_index" ON
    "administrador"."tb_pessoa"("id");
ALTER TABLE
    "administrador"."tb_pessoa" ADD PRIMARY KEY("id");
    
CREATE SEQUENCE "administrador"."tb_pessoa_seq"
START 1
INCREMENT 1
MINVALUE 1
OWNED BY "administrador"."tb_pessoa".id;
		
CREATE TABLE "administrador"."tb_fornecedor"(
    "id" BIGINT NOT NULL,
	"codigo" VARCHAR(40) NULL,
    "razao_social" VARCHAR(200) NOT NULL,
    "cnpj" VARCHAR(14) NOT NULL,
    "status" NUMERIC(1) NOT NULL DEFAULT '1',
    "criado_em" DATE NULL,
    "criado_por" BIGINT NULL,
    "alterado_em" DATE NULL,
    "alterado_por" BIGINT NULL
);
CREATE INDEX "tb_fornecedor_id_index" ON
    "administrador"."tb_fornecedor"("id");
ALTER TABLE
    "administrador"."tb_fornecedor" ADD PRIMARY KEY("id");
	
CREATE SEQUENCE "administrador"."tb_fornecedor_seq"
START 1
INCREMENT 1
MINVALUE 1
OWNED BY "administrador"."tb_fornecedor".id;

CREATE TABLE "vendas"."tb_lead"(
    "id" BIGINT NOT NULL,
	"codigo" VARCHAR(40) NULL,
    "nome" VARCHAR(200) NOT NULL,
    "telefone" VARCHAR(14) NOT NULL,
    "whatsapp" VARCHAR(14) NOT NULL,
    "email" VARCHAR(100) NULL,
    "cidade" VARCHAR(250) NOT NULL,
    "origem" INTEGER NOT NULL,
    "tipo_lead" INTEGER NOT NULL,
    "status" NUMERIC(1) NOT NULL DEFAULT '1',
    "id_pessoa" BIGINT NULL,
    "criado_em" DATE NULL,
    "criado_por" BIGINT NULL,
    "alterado_em" DATE NULL,
    "alterado_por" BIGINT NULL
);
CREATE INDEX "tb_lead_id_index" ON
    "vendas"."tb_lead"("id");
ALTER TABLE
    "vendas"."tb_lead" ADD PRIMARY KEY("id");
    
CREATE SEQUENCE "vendas"."tb_lead_seq"
START 1
INCREMENT 1
MINVALUE 1
OWNED BY "vendas"."tb_lead".id;

COMMENT
ON COLUMN
    "vendas"."tb_lead"."origem" IS 'enum- pode ser facebook, whatsApp, instagram...';
COMMENT
ON COLUMN
    "vendas"."tb_lead"."tipo_lead" IS 'Enum, pode ser pessoa fisica, juridica';

CREATE TABLE "administrador"."tb_material"(
    "id" BIGINT NOT NULL,
	"codigo" VARCHAR(40) NULL,
    "descricao" VARCHAR(300) NOT NULL,
	"observao_interna" VARCHAR(2000) NULL,
    "tipo" INTEGER NOT NULL,
	"unidade_medida" INTEGER NOT NULL,
    "status" NUMERIC(1) NOT NULL DEFAULT '1',
    "criado_em" DATE NULL,
    "criado_por" BIGINT NULL,
    "alterado_em" DATE NULL,
    "alterado_por" BIGINT NULL
);
CREATE INDEX "tb_material_id_index" ON
    "administrador"."tb_material"("id");
ALTER TABLE
    "administrador"."tb_material" ADD PRIMARY KEY("id");
COMMENT
ON COLUMN
    "administrador"."tb_material"."tipo" IS 'enum - kit, individual';

CREATE SEQUENCE "administrador"."tb_material_seq"
START 1
INCREMENT 1
MINVALUE 1
OWNED BY "administrador"."tb_material".id;

CREATE TABLE "vendas"."tb_material_cotado"(
    "id" BIGINT NOT NULL,
	"codigo" VARCHAR(40) NULL,
    "observacao" VARCHAR(2000) NULL,
	"observao_interna" VARCHAR(2000) NULL,
    "valor" DOUBLE PRECISION NOT NULL,
    "id_fornecedor" BIGINT NOT NULL,
    "id_material" BIGINT NOT NULL,
    "status" NUMERIC(1) NOT NULL DEFAULT '1',
    "criado_em" DATE NULL,
    "criado_por" BIGINT NULL,
    "alterado_em" DATE NULL,
    "alterado_por" BIGINT NULL
);
CREATE INDEX "tb_material_cotado_id_index" ON
    "vendas"."tb_material_cotado"("id");
ALTER TABLE
    "vendas"."tb_material_cotado" ADD PRIMARY KEY("id");
COMMENT
ON COLUMN
    "vendas"."tb_material_cotado"."id_fornecedor" IS 'FK para tabela de fornecedor';
COMMENT
ON COLUMN
    "vendas"."tb_material_cotado"."id_material" IS 'fk para tabela de material';
    
CREATE SEQUENCE "vendas"."tb_material_cotado_seq"
START 1
INCREMENT 1
MINVALUE 1
OWNED BY "vendas"."tb_material_cotado".id;    
    
CREATE TABLE "vendas"."tb_orcamento_eletrico"(
    "id" BIGINT NOT NULL,
	"codigo" VARCHAR(40) NULL,
    "titulo" VARCHAR(100) NOT NULL,
    "observacao" VARCHAR(500) NULL,
    "observacao_interna" VARCHAR(500) NULL,
    "validade_proposta" INTEGER NOT NULL,
    "prazo_entrega" INTEGER NOT NULL,
    "distancia" BIGINT NOT NULL,
    "potencia_modulo" DOUBLE PRECISION NOT NULL,
    "percentual_perda" INTEGER NOT NULL,
    "detalhe_proposta" VARCHAR(500) NOT NULL,
    "modalida_tarifaria" INTEGER NOT NULL,
    "tipo_padrao" BIGINT NOT NULL,
    "uc" VARCHAR(20) NOT NULL,
    "consumo_medio" DOUBLE PRECISION NOT NULL,
    "preco_kwh" DOUBLE PRECISION NOT NULL,
    "tipo_instalacao" INTEGER NOT NULL,
    "tipo_estrutura" INTEGER NOT NULL,
    "status" NUMERIC(1) NOT NULL DEFAULT '1',
    "criado_em" DATE NULL,
    "criado_por" BIGINT NULL,
    "alterado_em" DATE NULL,
    "alterado_por" BIGINT NULL,
    "id_lead" BIGINT NOT NULL
);
CREATE INDEX "tb_orcamento_eletrico_id_index" ON
    "vendas"."tb_orcamento_eletrico"("id");
ALTER TABLE
    "vendas"."tb_orcamento_eletrico" ADD PRIMARY KEY("id");
COMMENT
ON COLUMN
    "vendas"."tb_orcamento_eletrico"."observacao" IS 'Campo para escrever a observacao cliente';
COMMENT
ON COLUMN
    "vendas"."tb_orcamento_eletrico"."observacao_interna" IS 'campo para observação interna';
COMMENT
ON COLUMN
    "vendas"."tb_orcamento_eletrico"."tipo_padrao" IS 'Enum - monofasico, bifasico';
COMMENT
ON COLUMN
    "vendas"."tb_orcamento_eletrico"."uc" IS 'uc - unidade consumidora';
COMMENT
ON COLUMN
    "vendas"."tb_orcamento_eletrico"."consumo_medio" IS 'consumo medio de enrgia';
COMMENT
ON COLUMN
    "vendas"."tb_orcamento_eletrico"."preco_kwh" IS 'Quilowatt-hora';
COMMENT
ON COLUMN
    "vendas"."tb_orcamento_eletrico"."tipo_instalacao" IS 'enum - residencial, predial';
COMMENT
ON COLUMN
    "vendas"."tb_orcamento_eletrico"."tipo_estrutura" IS 'Qual a telha, enum - cerâmico, pvc...';
COMMENT
ON COLUMN
    "vendas"."tb_orcamento_eletrico"."id_lead" IS 'FK para tabela de lead';

CREATE SEQUENCE "vendas"."tb_orcamento_eletrico_seq"
START 1
INCREMENT 1
MINVALUE 1
OWNED BY "vendas"."tb_orcamento_eletrico".id; 

CREATE TABLE "vendas"."tb_orcamento_material"(
    "id" BIGINT NOT NULL,
	"codigo" VARCHAR(40) NULL,
    "id_material_cotado" BIGINT NOT NULL,
    "id_orcamento" BIGINT NOT NULL,
    "quantidade" INTEGER NOT NULL,
    "valor" DOUBLE PRECISION NOT NULL,
    "status" NUMERIC(1) NOT NULL DEFAULT '1',
    "criado_em" DATE NULL,
    "criado_por" BIGINT NULL,
    "alterado_em" DATE NULL,
    "alterado_por" BIGINT NULL
);
CREATE INDEX "tb_orcamento_material_id_material_orcamento_index" ON
    "vendas"."tb_orcamento_material"("id");
ALTER TABLE
    "vendas"."tb_orcamento_material" ADD PRIMARY KEY("id");
COMMENT
ON COLUMN
    "vendas"."tb_orcamento_material"."id_material_cotado" IS 'fk para tabela de material';
COMMENT
ON COLUMN
    "vendas"."tb_orcamento_material"."id_orcamento" IS 'FK para tabela de orçamento';
COMMENT
ON COLUMN
    "vendas"."tb_orcamento_material"."quantidade" IS 'quantidade de determinado material em um orçamento';
		
ALTER TABLE
    "vendas"."tb_material_cotado" ADD CONSTRAINT "tb_material_cotado_id_fornecedor_foreign" FOREIGN KEY("id_fornecedor") REFERENCES "administrador"."tb_fornecedor"("id");
ALTER TABLE
    "vendas"."tb_orcamento_eletrico" ADD CONSTRAINT "tb_orcamento_eletrico_id_lead_foreign" FOREIGN KEY("id_lead") REFERENCES "vendas"."tb_lead"("id");
ALTER TABLE
    "vendas"."tb_material_cotado" ADD CONSTRAINT "tb_material_cotado_id_material_foreign" FOREIGN KEY("id_material") REFERENCES "administrador"."tb_material"("id");
ALTER TABLE
    "vendas"."tb_lead" ADD CONSTRAINT "tb_lead_id_pessoa_foreign" FOREIGN KEY("id_pessoa") REFERENCES "administrador"."tb_pessoa"("id");
ALTER TABLE
    "vendas"."tb_orcamento_material" ADD CONSTRAINT "tb_orcamento_material_id_material_cotado_foreign" FOREIGN KEY("id_material_cotado") REFERENCES "vendas"."tb_material_cotado"("id");
ALTER TABLE
    "administrador"."tb_fornecedor" ADD CONSTRAINT "tb_fornecedor_id_foreign" FOREIGN KEY("id") REFERENCES "administrador"."tb_pessoa"("id");
ALTER TABLE
    "vendas"."tb_orcamento_material" ADD CONSTRAINT "tb_orcamento_material_id_orcamento_foreign" FOREIGN KEY("id_orcamento") REFERENCES "vendas"."tb_orcamento_eletrico"("id");
    
CREATE SEQUENCE "vendas"."tb_orcamento_material_seq"
START 1
INCREMENT 1
MINVALUE 1
OWNED BY "vendas"."tb_orcamento_material".id; 