
# API Dados Coletados de Sonda Espacial

API REST desenvolvida com Java 25 e Spring Boot para
registrar e gerenciar dados coletados por sondas espaciais.

## Tecnologias

- Java 25
- Spring Boot
- Maven
- Spring Data JPA
- H2
- MySQL
- Flyway
- Swagger/OpenAPI
- Docker

## Funcionalidades

- Cadastrar dados coletados
- Listar todos os registros
- Buscar registro por ID
- Atualizar registro
- Excluir registro
- Validar os dados recebidos

## Requisitos

- JDK 25
- Maven Wrapper do projeto
- MySQL para o perfil dev
- Docker e Docker Compose para executar em containers

## Executar com o perfil test (H2)

No Linux/macOS:

    ./mvnw spring-boot:run -Dspring-boot.run.profiles=test

No Windows:

    .\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=test"

O perfil test utiliza H2 em memória.

## Executar com o perfil dev (MySQL)

Configure as variáveis de ambiente:

- SPRING_PROFILES_ACTIVE=dev
- DB_URL=jdbc:mysql://localhost:3306/dados_coletados
- DB_USERNAME=root
- DB_PASSWORD=sua_senha

Crie o banco dados_coletados no MySQL e execute:

    ./mvnw spring-boot:run

No Windows, utilize .\mvnw.cmd no lugar de ./mvnw.

## Executar os testes

    ./mvnw test

## Executar com Docker Compose

    docker compose up --build

Para encerrar:

    docker compose down

## Documentação da API

Com a aplicação em execução:

    http://localhost:8080/swagger-ui/index.html

## Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /api/dados-coletados | Cadastrar |
| GET | /api/dados-coletados | Listar |
| GET | /api/dados-coletados/{id} | Buscar por ID |
| PUT | /api/dados-coletados/{id} | Atualizar |
| DELETE | /api/dados-coletados/{id} | Excluir |

## Migrations

O Flyway executa as migrations versionadas
localizadas em src/main/resources/db/migration.

- V1: criação da tabela
- V2: inserção de três registros iniciais
