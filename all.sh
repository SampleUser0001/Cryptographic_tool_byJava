#!/bin/bash

docker rm $(docker ps -a -q)
docker rmi $(docker images -a -q)

rm -rf workdir/*.jar
rm -rf decompile

mvn clean compile package
cp target/SampleCipher-1.0-SNAPSHOT-jar-with-dependencies.jar workdir/

docker-compose build --force-rm
docker-compose up

sh decompile.sh
