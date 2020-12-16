FROM postgres:latest
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB mobile-management
ADD init_database.sql /docker-entrypoint-initdb.d/


# docker build -t postgres/mdm-postgres:latest .