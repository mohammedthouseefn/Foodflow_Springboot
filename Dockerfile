FROM eclipse-temurin:21-jdk

WORKDIR /foodFlow

COPY target/foodflow-0.0.1.jar foodflow.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","foodflow.jar"]