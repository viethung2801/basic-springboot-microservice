# basic-springboot-microservice
## First setup
- Create variable environment mysql_password={your_mysql_password}
- Pull keycloak:18.0.0 docker: "docker run -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:18.0.0 start-dev"
- Setup kafka broker: "docker compose up -d"

