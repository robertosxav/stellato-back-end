    
ALTER TABLE public.material RENAME COLUMN material_criardo_por TO material_criado_por;

CREATE SEQUENCE seq_material MINVALUE 1 INCREMENT 1;

ALTER TABLE material
    ALTER COLUMN material_id SET DEFAULT nextval('seq_material');

CREATE SEQUENCE seq_arquivo MINVALUE 1 INCREMENT 1;

ALTER TABLE arquivo
    ALTER COLUMN arquivo_id SET DEFAULT nextval('seq_arquivo');   

CREATE SEQUENCE seq_dados_conta_energia MINVALUE 1 INCREMENT 1;

ALTER TABLE dados_conta_energia
    ALTER COLUMN dados_conta_energia_id SET DEFAULT nextval('seq_dados_conta_energia');   

CREATE SEQUENCE seq_dimensionamento MINVALUE 1 INCREMENT 1;

ALTER TABLE dimensionamento
    ALTER COLUMN dimensionamento_id SET DEFAULT nextval('seq_dimensionamento');       

CREATE SEQUENCE seq_distribuidora MINVALUE 1 INCREMENT 1;

ALTER TABLE distribuidora
    ALTER COLUMN distribuidora_id SET DEFAULT nextval('seq_distribuidora');   
  
CREATE SEQUENCE seq_etapas_funil MINVALUE 1 INCREMENT 1;

ALTER TABLE etapas_funil
    ALTER COLUMN etapas_funil_id SET DEFAULT nextval('seq_etapas_funil');   

CREATE SEQUENCE seq_fornecedor MINVALUE 1 INCREMENT 1;

ALTER TABLE fornecedor
    ALTER COLUMN fornecedor_id SET DEFAULT nextval('seq_fornecedor');    

CREATE SEQUENCE seq_funil_vendas MINVALUE 1 INCREMENT 1;

ALTER TABLE funil_vendas
    ALTER COLUMN funil_vendas_id SET DEFAULT nextval('seq_funil_vendas'); 

CREATE SEQUENCE seq_historico MINVALUE 1 INCREMENT 1;

ALTER TABLE historico
    ALTER COLUMN historico_id SET DEFAULT nextval('seq_historico'); 

CREATE SEQUENCE seq_lead MINVALUE 1 INCREMENT 1;

ALTER TABLE lead
    ALTER COLUMN lead_id SET DEFAULT nextval('seq_lead'); 

CREATE SEQUENCE seq_material_cotado MINVALUE 1 INCREMENT 1;

ALTER TABLE material_cotado
    ALTER COLUMN material_cotado_id SET DEFAULT nextval('seq_material_cotado'); 

CREATE SEQUENCE seq_modalidade_tarifaria MINVALUE 1 INCREMENT 1;

ALTER TABLE modalidade_tarifaria
    ALTER COLUMN modalidade_tarifaria_id SET DEFAULT nextval('seq_modalidade_tarifaria'); 

CREATE SEQUENCE seq_orcamento_ele_arquivo MINVALUE 1 INCREMENT 1;

ALTER TABLE orcamento_ele_arquivo
    ALTER COLUMN orcamento_ele_arquivo_id SET DEFAULT nextval('seq_orcamento_ele_arquivo'); 

CREATE SEQUENCE seq_orcamento_ele_mat_cotado MINVALUE 1 INCREMENT 1;

ALTER TABLE orcamento_ele_mat_cotado
    ALTER COLUMN orcamento_ele_mat_cotado_id SET DEFAULT nextval('seq_orcamento_ele_mat_cotado'); 

CREATE SEQUENCE seq_orcamento_eletrico MINVALUE 1 INCREMENT 1;

ALTER TABLE orcamento_eletrico
    ALTER COLUMN orcamento_eletrico_id SET DEFAULT nextval('seq_orcamento_eletrico'); 

CREATE SEQUENCE seq_pessoa MINVALUE 1 INCREMENT 1;

ALTER TABLE pessoa
    ALTER COLUMN pessoa_id SET DEFAULT nextval('seq_pessoa');             


