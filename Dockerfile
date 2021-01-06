FROM openjdk:11.0.9.1-jdk-buster

USER root

RUN apt -y update && apt -y upgrade && apt -y  autoremove
RUN apt install -y proguard

WORKDIR /workdir

COPY workdir /workdir

RUN chmod 755 /workdir/start.sh

CMD [ "/workdir/start.sh" ]