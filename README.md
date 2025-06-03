# 🧼 Clean-Arch-Auth

Este projeto é uma API de autenticação desenvolvida em **Java 17** com **Spring Boot 3**, utilizando os princípios da **Clean Architecture** para promover uma estrutura sólida, escalável e de fácil manutenção. A aplicação fornece endpoints para registro, login e recuperação de informações do usuário autenticado utilizando **JWT** para autenticação stateless.

---

## 🔍 Visão Geral

A proposta do projeto é implementar uma API de autenticação que siga os princípios da Clean Architecture, separando claramente as responsabilidades entre regras de negócio, casos de uso, infraestrutura e exposição (controllers). Isso permite um alto nível de independência entre as camadas, facilitando testes e manutenção do sistema.

---

## 🏗️ Arquitetura e Estrutura de Pastas

O projeto segue a estrutura baseada na Clean Architecture, dividindo as camadas em `core` e `infra`, conforme abaixo:

com.example.auth
├── core
│ ├── domain.entities # Entidades e regras de negócio
│ ├── gateway # Interfaces (ports) para comunicação com a infraestrutura
│ └── usecases # Casos de uso da aplicação
└── infra
├── config # Beans e configurações do Spring
├── controllers # Camada de entrada: REST Controllers
├── persistence # Implementações dos repositórios (adapters)
└── security # Configuração de autenticação e autorização (JWT)

- **core**: Totalmente independente de frameworks, contém a lógica de domínio e as regras de negócio puras.
- **infra**: Depende de bibliotecas externas como Spring e lida com configurações, persistência, controle de rotas e segurança.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Web** – Criação de APIs RESTful
- **Spring Security** – Autenticação e autorização
- **JWT (JSON Web Token)** – Autenticação stateless
- **Maven** – Gerenciamento de dependências
- **JUnit 5** – Testes unitários
- **JPA (Hibernate)** – Persistência de dados
- **MySQL (DataBase)**
---

## ▶️ Como Executar

### Pré-requisitos

- Java 17+
- Maven 3.8+

### Passos:

1. Clone o repositório:

```bash
git clone https://github.com/Jcfmneto/Clean-Arch-Auth.git
cd Clean-Arch-Auth
```
```bash
./mvnw clean install
```
```bash
./mvnw spring-boot:run
```
A API estará disponível em http://localhost:8080.

🔐 Endpoints
📌 Autenticação
POST /auth/register: Cadastro de novos usuários

POST /auth/login: Login e geração de token JWT

Para acessar rotas protegidas, envie o token JWT no cabeçalho:
Authorization: Bearer {token}

🧪 Testes
Execute os testes automatizados com:

```bash
./mvnw test
```



