
ALTER TABLE public.pessoa ALTER COLUMN pessoa_cnpj DROP NOT NULL;

ALTER TABLE public.pessoa ALTER COLUMN pessoa_nome DROP NOT NULL;

ALTER TABLE public.pessoa ALTER COLUMN pessoa_cpf DROP NOT NULL;

ALTER TABLE public.pessoa ALTER COLUMN pessoa_nome_fantasia DROP NOT NULL;
