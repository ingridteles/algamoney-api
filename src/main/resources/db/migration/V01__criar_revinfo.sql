CREATE SCHEMA app_audit;

CREATE TABLE app_audit.revinfo (
  rev integer NOT NULL,
  revtstmp bigint,
  CONSTRAINT revinfo_pkey PRIMARY KEY (rev)
)