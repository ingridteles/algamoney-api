CREATE TABLE pessoa (
  codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  logradouro VARCHAR(50),
  numero VARCHAR(5),
  complemento VARCHAR(50),
  bairro VARCHAR(50),
  cep VARCHAR(8),
  cidade VARCHAR(50),
  estado VARCHAR(50),
  ativo boolean NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) 
  VALUES ('André', 'Rua das Acacias', '232', 'apt. 701', 'Torres', '60124220', 'Recife', 'Pernambuco', 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) 
  VALUES ('Amanda', null, null, null, null, null, null, null, 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) 
  VALUES ('Arthur', null, null, null, null, null, null, null, 0);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) 
  VALUES ('Vanessa', null, null, null, null, null, null, null, 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) 
  VALUES ('Viviane', null, null, null, null, null, null, null, 1);;
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) 
  VALUES ('Vinícius', null, null, null, null, null, null, null, 0);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) 
  VALUES ('Lucas', null, null, null, null, null, null, null, 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) 
  VALUES ('Gabriel', null, null, null, null, null, null, null, 0);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) 
  VALUES ('Bruno', null, null, null, null, null, null, null, 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo)
  VALUES ('Thiago', null, null, null, null, null, null, null, 0);