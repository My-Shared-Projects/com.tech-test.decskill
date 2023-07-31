FROM openjdk:20

WORKDIR /usr/src/app

COPY ${JAR_PATH} app.jar

EXPOSE ${API_PORT}

ENTRYPOINT ["java","-jar","app.jar"]