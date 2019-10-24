CREATE TABLE app_audit.pessoa_audit (
  codigo BIGINT(20),
  rev integer NOT NULL,
  revtype smallint,
  nome VARCHAR(50),
  logradouro VARCHAR(50),
  numero VARCHAR(5),
  complemento VARCHAR(50),
  bairro VARCHAR(50),
  cep VARCHAR(8),
  cidade VARCHAR(50),
  estado VARCHAR(50),
  ativo boolean,
  CONSTRAINT pessoa_audit_pkey PRIMARY KEY (codigo, rev),
  CONSTRAINT pessoa_audit_revinfo FOREIGN KEY (rev)
  REFERENCES revinfo (rev) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;