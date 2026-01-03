FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

COPY out/artifacts/demo_jar/demo.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]