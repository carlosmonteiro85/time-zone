FROM maven:3.8.5-openjdk-11 as build
WORKDIR /app
COPY . .

COPY data  /data

RUN mvn clean package -DskipTests

FROM openjdk:11
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
ENTRYPOINT java -jar app.jar
