DROP TABLE algamoneyapi.categoria;
DROP TABLE algamoneyapi.flyway_schema_history;
SELECT * FROM algamoneyapi.categoria;
DELETE FROM categoria;
INSERT INTO algamoneyapi.categoria (nome) values ('Lazer');
INSERT INTO categoria (nome) values ('Alimentação');
INSERT INTO categoria (nome) values ('Supermercado');
INSERT INTO categoria (nome) values ('Farmacia');
INSERT INTO categoria (nome) values ('Outros');
select * from lancamento;
select * from categoria