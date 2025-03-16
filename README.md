# PetCore API

PetCore é um sistema de cadastro e gerenciamento de animais, desenvolvido para auxiliar pequenas ONGs e abrigos na organização de seus pets. Com ele, é possível registrar informações detalhadas sobre os animais, facilitando o controle de adoções, cuidados veterinários e a gestão do abrigo.

<p align="center">
  <img src="https://github.com/user-attachments/assets/a86ddb0f-9bef-4c90-8833-56f5b02cb779" width="850">
</p>

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot 2.7.0**: Framework para desenvolvimento de aplicações Java.
- **PostgreSQL**: Banco de dados relacional.
- **Swagger**: Documentação da API.

## Features

- **CRUD de animais registrados**: Crie, leia, atualize e delete registros de animais.
- **Listagem de animais por diferentes características**: Filtre animais por nome, tipo, sexo, idade, etc.

## Instalação

1. **Clone este repositório:**
```bash
git clone https://github.com/LeiPinheiro/Petcore_API.git
```

2. **Acesse a página do projeto**
```bash
cd petcore-api
```

3. **Configure o banco de dados:**
 - Instale o PostgreSQL
 - Crie um banco de dados
```sql
CREATE DATABASE nome_do_banco
```
 - **Configure o arquivo .env ou application.properties com suas credenciais:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

4. Instale as dependências do projeto (caso esteja usando Maven):
```bash
mvn clean install
```

## Executando o Projeto
Para iniciar a API em ambiente de desenvolvimento, use:

```bash
mvnw.cmd spring-boot:run
```

- Ou simplesmente dê play na classe PetcoreApiApplication.java.
- A API rodará por padrão em http://localhost:8080, caso não tenha sido alterada a porta no arquivo de configuração.

## Documentação da API
A documentação da API pode ser acessada via Swagger em:
http://localhost:8080/swagger-ui.html

### Exemplo de Endpoint
```bash
# Recebe uma lista de animais com determinado nome
GET /api/name/Buddy
```
**Resposta:**
```json
{
  "id": 1,
  "name": "Buddy",
  "type": "Dog",
  "sex": "MALE",
  "age": 3,
  "weight": 30.5,
  "race": "Golden Retriever",
  "owner": "John Doe"
}
```
