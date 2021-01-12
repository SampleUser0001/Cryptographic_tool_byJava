#!/bin/bash

export FILENAME=SampleCipher-1.0.1-SNAPSHOT-jar-with-dependencies.jar

docker rm $(docker ps -a -q)
docker rmi $(docker images -a -q)

rm -rf workdir/*.jar
rm -rf decompile

mvn clean compile package
cp target/${FILENAME} workdir/

docker-compose build --force-rm
docker-compose up

sh decompile.sh
