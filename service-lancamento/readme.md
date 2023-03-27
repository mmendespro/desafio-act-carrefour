## Serviço para Cadastro de Plano de Contas

Responsável por regitrar os lançamentos e pela produção do report diário contendo o movimento diário bem como o cálculo do saldo para o fluxo de caixa.

## Pré-requisito

  - Java 11 ou mais novo
  - Maven 3.6.0 mais novo
  - Serviço "service-plano-conta" em execução

## Instalação

Após a clonagem do projeto siga as instruções abaixo para executar:

   - Navegue até a pasta do projeto: cd desafio-act-carrefour
   - Navegue até a pasta: cd service-lancamento
   - Construa o projeto: mvn clean install
   - Execute o projeto: mvn spring-boot:run

Na pasta "docs/postman" importe a collection "service-lancamento.json", caso prefira acesse a documentação da API pelo endereço abaixo:

    http://localhost:8081/swagger-ui/index.html
