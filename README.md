# Santander Dev Week 2023

Java RESTful API criada para a Santander Dev Week.

Criei lógica para existir os tipos de cartões fisicos e virtuais, e também para haver data de validade, onde uma rotina verifica a cada minuto se a validade do cartão for menor que a data atual, desativando-o caso precise, a validade do cartão fisíco após criado é de 3 anos, para cartões virtuais 1 hora.

## Principais Tecnologias
 - **Java 17**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
 - **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
 - **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
 - **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
 - **Railway**: facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.

## [Link do Figma](https://www.figma.com/file/0ZsjwjsYlYd3timxqMWlbj/SANTANDER---Projeto-Web%2FMobile?type=design&node-id=1421%3A432&mode=design&t=6dPQuerScEQH0zAn-1)

O Figma foi utilizado para a abstração do domínio desta API, sendo útil na análise e projeto da solução.

## Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
    class User {
        -id: int
        -name: string
        -account: Account
        -card: Card[]
        -features: Feature[]
        -news: News[]
    }

    class Account {
        -id: int
        -number: string
        -agency: string
        -balance: double
        -limit: double
    }

    class Card {
        -id: int
        -number: string
        -limit: double
        -type: TypeCard
        -dateHourExpire: string
        -ative: boolean
    }

    class Feature {
        -icon: string
        -description: string
    }

    class News {
        -icon: string
        -description: string
    }

    class TypeCard {
        PHYSICAL
        VIRTUAL
    }

  User "1" *-- "1" Account
  User "1" *-- "N" Feature
  User "1" *-- "N" Card
  User "1" *-- "N" News
  Card "1" *-- "1" TypeCard
```

## IMPORTANTE

Este projeto foi construído com um viés totalmente educacional para a DIO. Por isso, disponibilizamos uma versão mais robusta dele no repositório oficial da DIO:

### [digitalinnovationone/santander-dev-week-2023-api](https://github.com/digitalinnovationone/santander-dev-week-2023-api)

Lá incluímos todas os endpoints de CRUD, além de aplicar boas práticas (uso de DTOs e refinamento na documentação da OpenAPI). Sendo assim, caso queira um desafio/referência mais completa é só acessar 👊🤩
