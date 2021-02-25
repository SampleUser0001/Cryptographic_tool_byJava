#!/bin/bash

export JAR_FILENAME=SampleCipher-1.0.1-SNAPSHOT-jar-with-dependencies.jar

rm -rf jre-min/
rm jre-min.zip

jlink --compress=2 --module-path . --add-modules java.base --output jre-min
# zip -r jar-min.zip jar-min/
