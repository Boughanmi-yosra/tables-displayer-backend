FROM openjdk:17-oracle
VOLUME /tmp
COPY target/*jar app.jar

LABEL authors="Boughanmi-Yosra"
ENTRYPOINT ["java","-jar","/app.jar"]