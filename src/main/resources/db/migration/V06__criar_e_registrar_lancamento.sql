CREATE TABLE lancamento (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL,
	data_vencimento DATE NOT NULL,
	data_pagamento DATE,
	valor DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(100),
	tipo DECIMAL(1,0) NOT NULL,
	situacao DECIMAL(1,0) NOT NULL,
	codigo_categoria BIGINT(20) NOT NULL,
	codigo_pessoa BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
	FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Salário mensal', '2017-06-10', null, 6500.00, 'Distribuição de lucros', 1, 1, (SELECT codigo FROM categoria WHERE nome = 'Lazer'), (SELECT codigo FROM pessoa WHERE nome = 'João Silva'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 2, 2, (SELECT codigo FROM categoria WHERE nome = 'Alimentação'), (SELECT codigo FROM pessoa WHERE nome = 'Maria Rita'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Top Club', '2017-06-10', null, 120, null, 1, 1, (SELECT codigo FROM categoria WHERE nome = 'Supermercado'), (SELECT codigo FROM pessoa WHERE nome = 'Pedro Santos'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Geração', 1, 2, (SELECT codigo FROM categoria WHERE nome = 'Supermercado'), (SELECT codigo FROM pessoa WHERE nome = 'Ricardo Pereira'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('DMAE', '2017-06-10', null, 200.30, null, 2, 1, (SELECT codigo FROM categoria WHERE nome = 'Supermercado'), (SELECT codigo FROM pessoa WHERE nome = 'Josué Mariano'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 1, 1, (SELECT codigo FROM categoria WHERE nome = 'Farmacia'), (SELECT codigo FROM pessoa WHERE nome = 'Pedro Barbosa'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Bahamas', '2017-06-10', null, 500, null, 1, 1, (SELECT codigo FROM categoria WHERE nome = 'Lazer'), (SELECT codigo FROM pessoa WHERE nome = 'Henrique Medeiros'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 2, 1, (SELECT codigo FROM categoria WHERE nome = 'Farmacia'), (SELECT codigo FROM pessoa WHERE nome = 'Carlos Santana'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Despachante', '2017-06-10', null, 123.64, 'Multas', 2, 2, (SELECT codigo FROM categoria WHERE nome = 'Supermercado'), (SELECT codigo FROM pessoa WHERE nome = 'Leonardo Oliveira'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Pneus', '2017-04-10', '2017-04-10', 665.33, null, 1, 2, (SELECT codigo FROM categoria WHERE nome = 'Outros'), (SELECT codigo FROM pessoa WHERE nome = 'Isabela Martins'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Café', '2017-06-10', null, 8.32, null, 2, 3, (SELECT codigo FROM categoria WHERE nome = 'Lazer'), (SELECT codigo FROM pessoa WHERE nome = 'Josué Mariano'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Eletrônicos', '2017-04-10', '2017-04-10', 2100.32, null, 2, 3, (SELECT codigo FROM categoria WHERE nome = 'Outros'), (SELECT codigo FROM pessoa WHERE nome = 'Ricardo Pereira'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Instrumentos', '2017-06-10', null, 1040.32, null, 2, 1, (SELECT codigo FROM categoria WHERE nome = 'Farmacia'), (SELECT codigo FROM pessoa WHERE nome = 'Pedro Santos'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Café', '2017-04-10', '2017-04-10', 4.32, null, 2, 1, (SELECT codigo FROM categoria WHERE nome = 'Farmacia'), (SELECT codigo FROM pessoa WHERE nome = 'Josué Mariano'));
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, situacao, codigo_categoria, codigo_pessoa) values ('Lanche', '2017-06-10', null, 10.20, null, 2, 2, (SELECT codigo FROM categoria WHERE nome = 'Farmacia'), (SELECT codigo FROM pessoa WHERE nome = 'Ricardo Pereira'));