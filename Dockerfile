FROM openjdk:20

ARG JAR_PATH
ARG API_PORT

WORKDIR /usr/src/app

COPY ${JAR_PATH} app.jar

EXPOSE ${API_PORT}

ENTRYPOINT ["java","-jar","app.jar"]