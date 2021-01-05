FROM openjdk:7-jdk-slim

RUN apt update && apt install -y proguard maven

WORKDIR /app

COPY src /app/src
COPY pom.xml /app/pom.xml

RUN mkdir /app/workdir
COPY workdir/proguard.cfg /app/workdir/proguard.cfg

COPY start.sh /app/start.sh
RUN chmod 755 /app/start.sh


CMD [ "/app/start.sh" ]