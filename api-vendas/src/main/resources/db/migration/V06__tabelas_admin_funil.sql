CREATE TABLE "administrador"."tb_funil_vendas"(
    "id" BIGINT NOT NULL,
    "codigo" VARCHAR(40) NULL,
    "descricao" VARCHAR(250) NOT NULL,
    "status" INTEGER NULL DEFAULT '1',
    "criado_em" DATE NULL,
    "criado_por" BIGINT NULL,
    "alterado_em" DATE NULL,
    "alterado_por" BIGINT NULL
);
CREATE INDEX "tb_funil_vendas_id_index" ON
    "administrador"."tb_funil_vendas"("id");
    
ALTER TABLE
    "administrador"."tb_funil_vendas" ADD PRIMARY KEY("id");
    
CREATE TABLE "administrador"."tb_etapas_funil_vendas"(
    "id" BIGINT NOT NULL,
    "id_funil_vendas" BIGINT NOT NULL,
    "codigo" VARCHAR(40) NOT NULL,
    "etapa" VARCHAR(100) NOT NULL,
    "status" INTEGER NULL DEFAULT '1',
    "criado_em" DATE NULL,
    "criado_por" BIGINT NULL,
    "alterado_em" DATE NOT NULL,
    "alterado_por" BIGINT NOT NULL
);
CREATE INDEX "tb_etapas_funil_vendas_id_index" ON
    "administrador"."tb_etapas_funil_vendas"("id");

ALTER TABLE
    "administrador"."tb_etapas_funil_vendas" ADD PRIMARY KEY("id");
    
ALTER TABLE
    "administrador"."tb_etapas_funil_vendas" ADD CONSTRAINT "tb_etapas_funil_vendas_id_funil_vendas_foreign" FOREIGN KEY("id_funil_vendas") REFERENCES "administrador"."tb_funil_vendas"("id");
    