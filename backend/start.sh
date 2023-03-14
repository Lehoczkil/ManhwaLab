#!/bin/bash

createdb "$1"
export DB_USERNAME="$1"
export SPRING_DATASOURCE_URL="$2"
export DB_PASSWORD="$3"

mvn clean package
java -jar target/ManhwaLabBackend-0.0.1-SNAPSHOT.jar backend.jar