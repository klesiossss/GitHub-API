FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} dev.jar
ENTRYPOINT ["java","-jar","/service1.jar"]