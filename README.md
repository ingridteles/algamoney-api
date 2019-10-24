# algamoney-api

Duvidas
# Introdução ao REST - 1.1.Introdução ao curso
Pregunta:
 Boa tarde, vocês tem alguma aula gravada(ou material de estudo) explicando passo a passo a configuração do envers hibernate no spring boot? Obrigada.

Resposta:
 Olá Ingrid!
 Não temos nenhum material sobre o envers, mas você pode conferir esse artigo que é muito bom:
 https://www.baeldung.com/database-auditing-jpa

# Primeiras consultas e cadastros na API - 3.3. Migração de dados com Flyway
Pergunta:
 Quando apenas um script de migração dá erro, como faço para executar apenas ele?
 Da forma que sei preciso dar o drop em todas as tabelas e rodar o flyway:migrate que executa todos os scripts novamente.

Resposta:

# Primeiras consultas e cadastros na API -  3.8 Validando atributos desconhecidos

Pergunta:
 Boa noite, 
 estou fazendo o curso e testei o comando
 spring.jackson.deserialization.fail-on-unknown-properties=true
 na aplicação que estou desenvolvendo no meu trabalho e não deu certo.
 Vocês sabem de alguma situação em que apenas esse comado não é suficiente?
 Preciso fazer mais alguma coisa?
 Obrigada,
 Ingrid

Resposta:
 Olá Ingrid!
 Precisaria dar uma olhada melhor pra entender.
 Você conseguiria postar os códigos que você testou pra ter uma visão melhor?
 
 
Relacionamentos entre recursos REST - 5.1. Criando a migração e entidade de lançamento
Pergunta:  

Enum
Lucas Barbosa Magalhães 06/08/2019 às 21:18 

 Boa Noite, ainda sobre Enum... como faço para definir o valor inicial do enum? 

Quando fiz o mapeamento desta forma 

@Enumerated(EnumType.ORDINAL)
private TipoLancamento tipo;

o valor inicial no banco foi o 0 e gostaria que fosse o 1.
o Enum está assim:

	RECEITA(1, "Receita"),
	DESPESA(2, "Despesa");
	

no banco está assim
tipo DECIMAL(1,0) NOT NULL

E ao recuperar com o GET, o valor 1 (que tem no banco) retorna DESPESA.

Não gostaria de criar um valor dummy no enum só para representar o zero.

Obrigada,
Ingrid
