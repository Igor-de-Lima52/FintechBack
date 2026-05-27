# DT Money - Backend

Sistema de gestão financeira pessoal que permite controlar transações, investimentos e contas bancárias.

---

## Tecnologias:

- Java 21
- Spring Boot 4.0.6
- Spring Data JPA
- Spring Security
- Oracle Database (FIAP)
- Lombok
- Maven

---

## Como rodar:

```bash
git clone -b Backend https://github.com/Igor-de-Lima52/FintechBack.git
cd FintechBack
mvn spring-boot:run
```

O backend vai subir em `http://localhost:8080`

---

## Configuração:

No arquivo `src/main/resources/application.properties`, substitua com suas credenciais:

```properties
spring.datasource.username=SEU_RM
spring.datasource.password=SUA_SENHA
```

---

## Autenticação:

Crie um usuário pelo `POST /api/usuarios` e faça login com:

- **Email:** teste@teste.com
- **Senha:** teste123456

---

## Endpoints:

| Entidade | Base URL | Métodos |
|----------|----------|---------|
| Usuários | `/api/usuarios` | GET, POST, PUT, DELETE |
| Bancos | `/api/bancos` | GET, POST |
| Contas | `/api/contas` | GET, POST, PUT, DELETE |
| Categorias | `/api/categorias` | GET, POST, PUT, DELETE |
| Transações | `/api/transacoes` | GET, POST, PUT, DELETE |
| Investimentos | `/api/investimentos` | GET, POST, PUT, DELETE |
