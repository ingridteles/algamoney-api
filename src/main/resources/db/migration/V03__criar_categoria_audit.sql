CREATE TABLE app_audit.categoria_audit (
  codigo BIGINT(20),
  rev integer NOT NULL,
  revtype smallint,
  nome VARCHAR(50),
  CONSTRAINT categoria_audit_pkey PRIMARY KEY (codigo, rev),
  CONSTRAINT categoria_audit_revinfo FOREIGN KEY (rev)
  REFERENCES revinfo (rev) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;