# Lista de Contatos

Aplicação web simples para cadastro, listagem, edição e inativação de contatos.

O projeto foi criado para estudo de desenvolvimento Java web usando Spring Boot, JSF, PrimeFaces e persistência com PostgreSQL.

## Tecnologias

- Java 21
- Spring Boot 4
- Maven
- JSF / Jakarta Faces
- PrimeFaces
- JoinFaces
- Spring Data JPA
- Hibernate
- PostgreSQL
- Docker
- Docker Compose

## Como Rodar

Subir banco e aplicação:

```bash
make up
```

Acessar no navegador:

```text
http://localhost:8080/contatos.xhtml
```

Rodar os testes:

```bash
make test
```

Gerar o pacote `.jar`:

```bash
make package
```

Derrubar os containers:

```bash
make down
```

## Banco de Dados

O PostgreSQL roda via Docker Compose.

Configuração padrão local:

```text
Banco: lista_contatos
Usuário: lista_contatos
Senha: lista_contatos
Porta: 5432
```

## Estrutura Principal

```text
src/main/java/br/com/estudos/lista_contatos/
├── model
├── repository
├── service
└── web
```

```text
src/main/resources/META-INF/resources/
└── contatos.xhtml
```
