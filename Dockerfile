FROM eclipse-temurin:21-jdk

WORKDIR /foodflow

COPY target/foodflow-0.0.1.jar foodflow.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","foodflow.jar"]
