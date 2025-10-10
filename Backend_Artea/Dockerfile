# Etapa de construcción
FROM amazoncorretto:23.0.2-alpine3.18 as build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa final
FROM amazoncorretto:23.0.2-alpine3.18
WORKDIR /app
COPY --from=build /app/target/PTS-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app.jar"]
