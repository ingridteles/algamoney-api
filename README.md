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
Olá Ingrid!

Você pode especificar um target, neste caso:

mvn flyway:migrate -Dflyway.target=<sua-versao>

Fiz um loom demonstrando umas formas de tratar erros do flyway, veja se te ajuda:

https://www.useloom.com/share/f2760909efed49009852902f31f46652

mvn flyway:repair -Dflyway.url=jdbc:mysql://localhost:3306/algamoneyapi -Dflyway.user=root -Dflyway.password=root 

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

Resposta:
Olá Ingrid!

Quando você utiliza @Enumerated(EnumType.ORDINAL), você está dizendo ao JPA para inserir no banco de dados a POSIÇÃO na qual foi declarado o seu Enum.

Como os índices começam com 0, o "valor ordinal" para RECEITA é 0 e o "valor ordinal" para DESPESA é 1.

Por isso esse recurso é totalmente desencorajado, pois você sempre precisará manter a ordem dos seus Enums.

Sempre que precisar adicionar algum novo, será obrigada a fazer isso ao final das declarações e não poderá mudar as posições. Uma vez que isso afetará no que já foi persistido.

Quando você obter esse valor da base na sua aplicação, terá o Enum de fato, dessa forma pode exibir os valores que você setou no Enum, normalmente para exibir ao usuário, ou coisa do tipo.

Mas recomendo que utilize o @Enumerated(EnumType.STRING).

Pergunta:
 Fórum Fullstack Angular e Spring Relacionamentos entre recursos REST Desafio: Cadastrando o primeiro lançamento 
 
 Fiz o desafio e testei a inclusão com o seguinte post

{
    "descricao": "Salário mensal",
    "dataVencimento": "10/10/2017",
    "dataPagamento": "10/10/2017",
    "valor": 6500.00,
    "observacao": "Distribuição de lucros",
    "categoria": {
    	"codigo": 1
    } ,
    "pessoa": {
    	"codigo": 1
    } 
}

mas ao fazer o get http://localhost:8080/lancamentos/18
as datas são recuperadas com um dia a menos, vocês sabem porque?

{
    "codigo": 18,
    "descricao": "Salário mensal",
    "dataVencimento": "09/10/2017",
    "dataPagamento": "09/10/2017",
    "valor": 6500.00,
    "observacao": "Distribuição de lucros",
    "tipo": 1,
    "situacao": 1,
    "categoriaId": 1,
    "pessoaId": 1
}

