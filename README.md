# Mini-Autorizador

Este é um miniautorizador, com a possibilidade de:

* criação de um cartão — saldo 500,00;
* verificação do saldo do cartão recém-criado;
* realização transação, verificando-se o saldo;

Validações: 
Uma transação pode ser autorizada se:
* verificar se o cartão existir
* verificar a senha do cartão for a correta
* verificar se o cartão possuir saldo disponível

Caso uma dessas regras não ser atendida, a transação não será autorizada.

## Pré-requisitos

* Maven
* Java 11
* Docker

## Frameworks
* MapStruct é um gerador de código que simplifica muito a implementação de mapeamentos entre os tipos de bean Java com base em uma convenção sobre abordagem de configuração.
* O Lombok é um framework para Java que permite escrever código eliminando a verbosidade, o que permite ganhar tempo de desenvolvimento para o que realmente é importante. Seu uso permite gerar em tempo de compilação os métodos getters e setters, métodos construtores, padrão builder e muito mais.
* Spring Validation é uma especificação Java para tratar validações de dados de forma centralizada, pois as validações são inseridas no próprio modelo através de anotações, assim possibilitando a consistência das informações em diferentes camadas.

## Testes unitário
Foram aplicados testes para os Services, Mapstruct, Validator

## Documentação
* Swagger:  `http://localhost:8080/v1/miniautorizador/swagger-ui.html`

## Execução da aplicação

Utilizando o Docker, é possível criar a estrutura de banco de dados e levantar a aplicação seguindo os passos abaixo:

1. Construir a aplicação com Maven executando o comando `mvn clean install`
2. Acessar o diretório principal do projeto (onde encontra-se o arquivo `docker-compose.yaml`)
3. Executar o comando `docker-compose up -d` para iniciar a aplicação
4. Ao concluir o passo anterior, você poderá acessar : http://localhost:8080/v1/miniautorizador/swagger-ui.html para verificar a documentação ou testar os end-points da aplicação utilizando a Collection do Postman `mini-automatizador.postman_collection` que encontra-se no diretório raiz do projeto.

