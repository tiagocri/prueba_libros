#docker build -t jaimesalvador/app-books:1.0.0 .
FROM eclipse-temurin:17.0.5_8-jre-alpine

RUN mkdir /app
WORKDIR /app

COPY build/libs/libs ./libs
COPY build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]