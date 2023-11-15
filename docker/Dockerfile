FROM postgres:latest

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB db_case
COPY init.sql /docker-entrypoint-initdb.d/
