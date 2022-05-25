FROM openjdk:11

WORKDIR /app

COPY /target/*.jar miniautorizador.jar

EXPOSE 8080

CMD ["java", "-jar", "miniautorizador.jar"]
