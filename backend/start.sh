#!/bin/bash


export DB_USERNAME=""
export DB_NAME=""
export DB_PASSWORD=""

mvn clean package
java -jar target/ManhwaLabBackend-0.0.1-SNAPSHOT.jar backend.jar
