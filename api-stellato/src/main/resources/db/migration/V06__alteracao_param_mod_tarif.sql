ALTER TABLE public.modalidade_tarifaria RENAME TO param_mod_tarifaria;
ALTER TABLE public.param_mod_tarifaria RENAME COLUMN modalidade_tarifaria_id TO param_mod_tarifaria_id;
ALTER TABLE public.param_mod_tarifaria RENAME COLUMN modalidade_tarifaria_valor TO param_mod_tarifaria_valor;
ALTER TABLE public.param_mod_tarifaria RENAME COLUMN modalidade_tarifaria_status TO param_mod_tarifaria_status;
ALTER TABLE public.param_mod_tarifaria RENAME COLUMN modalidade_tarifaria_criado_em TO param_mod_tarifaria_criado_em;
ALTER TABLE public.param_mod_tarifaria RENAME COLUMN modalidade_tarifaria_criado_por TO param_mod_tarifaria_criado_por;
commit;

ALTER TABLE public.param_mod_tarifaria RENAME CONSTRAINT modalidade_tarifaria_pkey TO param_mod_tarifaria_pkey;
commit;
ALTER TABLE public.param_mod_tarifaria RENAME CONSTRAINT imodalidadetarifaria1 TO iparammodtarifaria1;
commit;

ALTER SEQUENCE public.seq_modalidade_tarifaria RENAME TO seq_param_mod_tarifaria;

ALTER TABLE public.param_mod_tarifaria ADD COLUMN modalidade_tarifaria smallint;
commit;

ALTER TABLE public.dados_conta_energia DROP CONSTRAINT fkhk7bjn415a4o2c5m8bs9o44yn;
ALTER TABLE public.dados_conta_energia DROP COLUMN modalidade_tarifaria_id;
commit;

ALTER TABLE public.dados_conta_energia ADD COLUMN modalidade_tarifaria smallint;
commit;

ALTER TABLE public.dados_conta_energia ADD COLUMN distribuidora_id smallint NOT NULL;
CREATE INDEX IDADOSCONTAENERGIA1 ON dados_conta_energia (distribuidora_id);
commit;