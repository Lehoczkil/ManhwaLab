FROM postgres
ENV POSTGRESS_PASSWORD=password
COPY init.sql /docker-entrypoint-initdb.d/