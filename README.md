# ms-pagamentos
Repositório destinado a criação do serviços de pagamento do case proposto

# Dockerfile

O Dockerfile cria uma imagem PostgreSQL. 
O arquivo `init.sql` esta sendo copiado para o diretório `docker-entrypoint-initdb.d/`, 
garantindo que o script seja executado durante a inicialização do contêiner.

## Como Usar

### 1. Construir a Imagem

Execute o seguinte comando no diretório onde está localizado o Dockerfile:

```bash
docker build -t postgres_imagem:1.0 .
```

para executar o container, execute no bash o comando abaixo:
```bash
docker run -d --name nome_do_contêiner -p 5432:5432 postgres_imagem:1.0
```


## Iniciando a Aplicação Spring Boot na IDE do IntelliJ

Este guia fornece instruções sobre como iniciar sua aplicação Spring Boot na IDE do IntelliJ.

### Pré-requisitos

- IntelliJ IDEA instalado (https://www.jetbrains.com/idea/download/).
- JDK (Java Development Kit) instalado (https://adoptopenjdk.net/).

### Passos

1. **Clone o Repositório:**

   ```bash
   git clone https://github.com/seu-usuario/seu-projeto.git

2. **Configure o Intellij com a sua JDK e o Gradle**

3. **Configure o arquivo .properties com usuario e senha que voce configurou no dockerfile**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/db_case
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER 
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```

Rode o projeto no Run do Intellij e sua aplicação iniciará local.

### Swagger

com sua aplicação inicializada local, voce porde acesar a url  http://localhost:8080/swagger-ui.html
para acessar o endpoint e relizar um teste.

segue um json para teste com sucesso da aplicação:
```json
{
  "boletoRequest": {
    "dataEmissao": "2023-11-25",
    "dataVencimento": "2023-11-30",
    "valor": 500
  },
  "clienteRequest": {
    "cpf": "19100000000"
  }
}
```
