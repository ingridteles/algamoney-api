CREATE TABLE app_audit.lancamento_audit (
  codigo BIGINT (20),
  rev integer NOT NULL,
  revtype smallint,
  descricao VARCHAR (50),
  data_vencimento DATE,
  data_pagamento DATE,
  valor DECIMAL (10,2),
  observacao VARCHAR (100),
  tipo DECIMAL (1,0),
  codigo_categoria BIGINT (20),
  codigo_pessoa BIGINT (20),
  CONSTRAINT lancamento_audit_pkey PRIMARY KEY (codigo, rev),
  CONSTRAINT lancamento_audit_revinfo FOREIGN KEY (rev) 
  REFERENCES revinfo (rev) MATCH SIMPLE 
  ON UPDATE NO ACTION ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;