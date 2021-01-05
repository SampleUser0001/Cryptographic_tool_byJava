#!/bin/bash

java -version
javac -version

mvn clean compile package
cp target/SampleCipher-1.0-SNAPSHOT-jar-with-dependencies.jar workdir

cd /app/workdir
proguard @proguard.cfg
