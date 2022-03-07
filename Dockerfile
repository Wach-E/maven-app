FROM openjdk:19-oraclelinux8

WORKDIR /usr/app

EXPOSE 8080

COPY ./target/java-maven-app-1.1.0-SNAPSHOT.jar /usr/app/

ENTRYPOINT ["java", "-jar", "java-maven-app-1.1.0-SNAPSHOT.jar"]
