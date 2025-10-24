FROM eclipse-temurin:21-jdk

WORKDIR /

COPY / .

RUN ./gradlew --no-daemon clean build

CMD ["java", "-jar", "build/libs/project4tests-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]
