FROM eclipse-temurin:21-jdk

ENV JDBC_DATABASE_URL="jdbc:postgresql://dpg-d3tk0mhr0fns73ai8ej0-a:5432/prj99_3poh?password=${PASSWORD}&user=${USERNAME}"
ENV PASSWORD=CsyePl8oK8aadvsPbUBBT0GFOewkY6lS
ENV USERNAME=userbd_t5t_user

WORKDIR /

COPY / .

RUN ./gradlew --no-daemon clean build

CMD ["java", "-jar", "build/libs/project4tests-0.0.1-SNAPSHOT.jar"]
