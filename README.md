# API de Cadastro de Clientes

Este projeto é uma API REST desenvolvida com Java 21 e Spring Boot para
gerenciar o cadastro de clientes. A aplicação utiliza PostgreSQL como
banco de dados e Flyway para controle de versão do schema.

## Tecnologias Utilizadas

-   Java 21
-   Spring Boot
-   Spring Web
-   Spring Data JPA
-   PostgreSQL
-   Flyway
-   Maven
-   Swagger / Springdoc OpenAPI
-   Hibernate

## Estrutura do Projeto

    src/main/java/com/seuprojeto/
        controller/
        entity/
        repository/
        service/

    src/main/resources/
        application.properties
        db/migration/

### Controller

Responsável por expor os endpoints REST para cadastro, atualização,
listagem e remoção de clientes.

### Entity

Representa a estrutura da tabela de clientes no banco de dados.

### Repository

Interface que utiliza Spring Data JPA para realizar operações de
persistência.

### Service

Contém as regras de negócio e coordena as operações entre controller e
repository.

## Configuração do Banco de Dados
O projeto utiliza PostgreSQL. No arquivo `application.properties`,
configure:

    spring.datasource.url=jdbc:postgresql://localhost:5432/cliente_db
    spring.datasource.username=postgres
    spring.datasource.password=senha
    spring.jpa.hibernate.ddl-auto=none
    spring.jpa.show-sql=true
    spring.flyway.enabled=true


## Observação sobre o uso de credenciais no application.properties
Durante as etapas iniciais deste projeto, o arquivo application.properties foi versionado contendo as credenciais do banco PostgreSQL. Essa abordagem foi utilizada apenas para fins de estudo e testes locais, sem envolvimento de dados sensíveis ou ambientes externos.
Em um ambiente real, credenciais nunca devem ser incluídas no repositório. A configuração será posteriormente ajustada para utilizar:
variáveis de ambiente (SPRING_DATASOURCE_USERNAME, SPRING_DATASOURCE_PASSWORD);
arquivos externos não versionados;
ou ferramentas como Docker Secrets, Vault ou GitHub Actions Secrets, dependendo do ambiente.
Esse cuidado garante segurança, flexibilidade e boas práticas de desenvolvimento.

## Migrations com Flyway

As migrations devem ser adicionadas no diretório:

    src/main/resources/db/migration/

Exemplo de migration inicial:

    V1__create_table_clientes.sql

## Como Executar o Projeto

1.  Instale JDK 21 e Maven.
2.  Configure um banco PostgreSQL local.
3.  Execute o comando:

```{=html}
<!-- -->
```
    mvn spring-boot:run

A aplicação iniciará em:

    http://localhost:8080

## Endpoints Principais

-   GET /clientes
-   GET /clientes/{id}
-   POST /clientes
-   PUT /clientes/{id}
-   DELETE /clientes/{id}

### Acessar Swagger:

    http://localhost:8080/swagger-ui.html

## Melhorias Futuras

-   Implementação de testes automatizados
-   Criação de DTOs para entrada e saída de dados
-   Autenticação e autorização
-   Dockerização do projeto

##  Autor

**Filipe C Rodrigues**
