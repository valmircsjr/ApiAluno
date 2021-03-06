# API Aluno

API que fornece um CRUD de alunos.

---

## Indice

1. [Recursos utilizados](#id1)
2. [Como executar](#id2)
3. [EndPoints](#id3)
4. [Observações](#id4)

---

### Recursos utilizados <a name="id1"></a>
* Java EE
* Spring Boot
* Maven
* API REST
* BeanValidation
* JPA
* H2
* POSTMAN
* Visual Code

---

### Como executar <a name="id2"></a>

Será necessário instalar o Jdk, o Maven e configurar as respectivas variaveis de ambiente.

1. Faça o clone do repositório:
```
git clone https://github.com/valmircsjr/ApiAluno.git
```

2. Importe o projeto para alguma IDE. 

3. Execute o maven clean e maven install. 

4. Execute o deploy da aplicação.

5. Após isso, é possivel consumir a API em http://localhost:8000/aluno.

---

### EndPoints <a name="id3"></a>

* GET http://localhost:8000/aluno - Lista todos os alunos cadastrados.
* POST http://localhost:8000/aluno - Cadastra um aluno, passando um json no Body no formato ({"name" : "nome", "idade":"idade"}).
* GET http://localhost:8000/aluno/{ID} - Lists um aluno por meio do ID.
* PUT http://localhost:8000/aluno/{ID} - Atualiza um aluno com base no ID, passando um json no Body no formato ({"name" : "novo", "idade":"idade"}). Os campos nao podem ser null.
* DELETE http://localhost:8000/aluno/{ID} - Deleta um aluno com base no ID.

---

### Observações <a name="id4"></a>
Realizei os testes da API com o POSTMAN, por causa do tempo escasso. Mais tarde irei concluir os testes com algumas das tecnologias definidas (SOAPUI, Swagger, Teste Unitário(JUnit))
