FROM openjdk:17-oracle
EXPOSE 9191
ADD target/payment-service.jar payment-service.jar
ENTRYPOINT ["java", "-jar", "/payment-service.jar"]
