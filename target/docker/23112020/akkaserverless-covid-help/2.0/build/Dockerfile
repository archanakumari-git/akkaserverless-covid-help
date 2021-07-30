FROM docker.io/library/adoptopenjdk:11-jre-hotspot
EXPOSE 8080
COPY maven /maven/
ENTRYPOINT ["java","-jar","/maven/akkaserverless-covid-help-2.0.jar"]
