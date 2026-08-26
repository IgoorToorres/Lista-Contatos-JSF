COMPOSE = docker compose
MVNW = ./mvnw

.PHONY: help build test package db-up db-down up down restart logs app-logs db-logs clean

help:
	@echo "Comandos disponiveis:"
	@echo "  make db-up     - Sobe apenas o PostgreSQL"
	@echo "  make db-down   - Derruba apenas o PostgreSQL"
	@echo "  make up        - Sobe PostgreSQL e aplicacao"
	@echo "  make down      - Derruba todos os containers"
	@echo "  make restart   - Reinicia PostgreSQL e aplicacao"
	@echo "  make logs      - Mostra logs de todos os servicos"
	@echo "  make app-logs  - Mostra logs da aplicacao"
	@echo "  make db-logs   - Mostra logs do PostgreSQL"
	@echo "  make test      - Sobe o banco e roda os testes"
	@echo "  make package   - Gera o jar localmente"
	@echo "  make build     - Builda a imagem Docker da aplicacao"
	@echo "  make clean     - Limpa artefatos Maven"

db-up:
	$(COMPOSE) up -d db

db-down:
	$(COMPOSE) stop db

up:
	$(COMPOSE) up --build

down:
	$(COMPOSE) down

restart: down up

logs:
	$(COMPOSE) logs -f

app-logs:
	$(COMPOSE) logs -f app

db-logs:
	$(COMPOSE) logs -f db

test: db-up
	SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/lista_contatos \
	SPRING_DATASOURCE_USERNAME=lista_contatos \
	SPRING_DATASOURCE_PASSWORD=lista_contatos \
	$(MVNW) test

package: db-up
	SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/lista_contatos \
	SPRING_DATASOURCE_USERNAME=lista_contatos \
	SPRING_DATASOURCE_PASSWORD=lista_contatos \
	$(MVNW) package

build:
	$(COMPOSE) build app

clean:
	$(MVNW) clean
