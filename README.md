# Agregador de Investimentos - Java
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

## 💻 Arquitetura do projeto
<img src="/uml.png" alt="Arquitetura do Agregador de Investimentos"/>

## 🔗 Link de download
https://github.com/Ital023/AgregadorDeInvestimentos/archive/refs/heads/master.zip

## :rocket: Sobre o projeto

Desenvolvi uma aplicação em Java com Spring Boot, usando um banco de dados MySQL em um container Docker, que consome dados da bolsa de valores pela API do Brapi. Este projeto me permitiu praticar a criação de APIs RESTful, uso de DTOs, JPA e conceitos de engenharia de software, garantindo uma aplicação robusta e escalável.

## :white_check_mark: Funcionalidades
| Método | Caminho                      | Response                                           |
| ------ | -------------------------- | -------------------------------------------------- |
| GET    | http://localhost:8080/v1/users | Retorna todos os usuarios cadastrados no sistema                  |
| POST    | http://localhost:8080/v1/users | Cadastra um usuario no sistema |
| GET    | http://localhost:8080/v1/users/{userId} | Retorna apenas um usuario cadastrado no sistema                  |
| PUT    | http://localhost:8080/v1/users/{userId} | Altera o usuario no sistema |
| DELETE    | http://localhost:8080/v1/users/{userId} | Deleta o usuario no sistema |
| POST    | http://localhost:8080/v1/users/{userId}/accounts | Cadastra uma nova conta(carteira de ações) ao usuario |
| GET    | http://localhost:8080/v1/users/{userId}/accounts | Retorna as informações da carteira do usuario |
| ------ | -------------------------- | -------------------------------------------------- |
| POST    | http://localhost:8080/v1/stocks | Cadastra uma ação no sistema |
| ------ | -------------------------- | -------------------------------------------------- |
| POST    | http://localhost:8080/v1/accounts/{accountId}/stocks | Cadastrar uma ação a carteira do usuario com sua quantidade |
| GET    | http://localhost:8080/v1/accounts/{accountId}/stocks | Retorna todas as ações compradas pelo usuario |






## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/Ital023" title="Github do Ítalo Miranda">
        <img src="https://avatars.githubusercontent.com/u/113559117?v=4" width="100px;" alt="Foto do Ítalo Miranda no GitHub"/><br>
        <sub>
          <b>Ítalo Miranda</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
