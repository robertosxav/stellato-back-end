CREATE TABLE "administrador"."tb_modalidade_tarifaria"(
    "id" BIGINT NOT NULL,
    "id_distribuidora" BIGINT NOT NULL,
    "codigo_tarifario" INTEGER NOT NULL,
    "valor" DOUBLE PRECISION NOT NULL,
    "status" NUMERIC(1) NOT NULL DEFAULT '1',
    "criado_em" DATE NULL,
    "criado_por" BIGINT NULL,
    "alterado_em" DATE NULL,
    "alterado_por" BIGINT NULL
);
CREATE INDEX "tb_modalidade_tarifaria_id_index" ON
    "administrador"."tb_modalidade_tarifaria"("id");
ALTER TABLE
    "administrador"."tb_modalidade_tarifaria" ADD PRIMARY KEY("id");
    
CREATE TABLE "administrador"."tb_distribuidora"(
    "id" BIGINT NOT NULL,
    "nome" VARCHAR(200) NOT NULL,
    "sigla" VARCHAR(50) NOT NULL,
    "status" NUMERIC(1) NOT NULL DEFAULT '1',
    "criado_em" DATE NULL,
    "criado_por" BIGINT NULL,
    "alterado_em" DATE NULL,
    "alterado_por" BIGINT NULL
);
CREATE INDEX "tb_distribuidora_id_index" ON
    "administrador"."tb_distribuidora"("id");
ALTER TABLE
    "administrador"."tb_distribuidora" ADD PRIMARY KEY("id");
ALTER TABLE
    "administrador"."tb_modalidade_tarifaria" ADD CONSTRAINT "modalidade_tarifaria_id_distribuidora_foreign" FOREIGN KEY("id_distribuidora") REFERENCES "administrador"."tb_distribuidora"("id");