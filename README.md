# Coreography API

Coreography API é uma aplicação desenvolvida em Java usando Spring Boot, que permite gerenciar usuários, coreografias e passos ordenados. Os usuários podem criar, editar e seguir coreografias, com a possibilidade de explorar recursos como feed social e edição de coreografias existentes.

## Funcionalidades Principais

- **Gerenciamento de Usuários**:
    - Criação de perfis de usuário.
    - Seguimento de outros usuários.
    - Listagem e busca por usuários.

- **Coreografias**:
    - Criação de coreografias com sequências de passos.
    - Controle de visibilidade (pública ou privada).
    - Reorganização e edição de passos em coreografias existentes.

- **Passos**:
    - Associação de passos ordenados às coreografias.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.0.0**
- **H2 Database** (Banco de dados em memória para testes e desenvolvimento)
- **Spring Data JPA** (ORM para interação com o banco de dados)
- **Spring Web** (Criação de APIs REST)
- **Maven** (Gerenciador de dependências e build)

## Estrutura do Projeto

O projeto segue a arquitetura padrão do Spring Boot:

```
src/main/java/com/example/coreographyapi
├── CoreographyApiApplication.java
├── controller
│   ├── UserController.java
│   └── CoreographyController.java
├── model
│   ├── User.java
│   ├── Coreography.java
│   └── Step.java
├── repository
│   ├── UserRepository.java
│   ├── CoreographyRepository.java
│   └── StepRepository.java
```

## Endpoints Disponíveis

### Usuários (`/users`)

- **GET `/users`**: Lista todos os usuários.
- **POST `/users`**: Cria um novo usuário.
- **GET `/users/{id}`**: Retorna um usuário pelo ID.

### Coreografias (`/coreographies`)

- **GET `/coreographies`**: Lista todas as coreografias.
- **POST `/coreographies`**: Cria uma nova coreografia.
- **GET `/coreographies/{id}`**: Retorna uma coreografia pelo ID.

## Configuração do Ambiente

1. Certifique-se de ter o **Java 17** instalado.
2. Clone este repositório:
   ```bash
   git clone <URL-do-repositorio>
   cd coreography-api
   ```
3. Compile e execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Acesse a aplicação em: [http://localhost:8080](http://localhost:8080).

## Banco de Dados H2

A API usa o banco de dados em memória H2 para testes. Você pode acessar o console do H2 em:

- URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (vazio)

## Melhorias Futuras

- Implementação de feed para sugerir coreografias com base em usuários seguidos.
- Sistema de autenticação e autorização.
- Suporte a bancos de dados persistentes como PostgreSQL.
- Validação e tratamento de erros mais robustos.
- Testes unitários e de integração mais abrangentes.

---

## Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo `LICENSE` para mais informações.

