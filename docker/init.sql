CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE db_case.public.tb_cliente (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    nome VARCHAR(100),
    sobrenome VARCHAR(100) UNIQUE,
    documento VARCHAR(20),
    email VARCHAR(100)
);

INSERT INTO db_case.public.tb_cliente (nome, sobrenome, documento, email)
VALUES ('JOSE', 'SILVA', '19100000000', 'jose.silva@email.com');