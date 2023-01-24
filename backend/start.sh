
export DB_USERNAME=""
export SPRING_DATASOURCE_URL=""
export DB_PASSWORD=""

mvn clean package
java -jar target/ManhwaLabBackend-0.0.1-SNAPSHOT.jar backend.jar
