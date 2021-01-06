#!/bin/bash

rm -rf decompile
mkdir decompile
cp workdir/SampleCipher-1.0-SNAPSHOT-jar-with-dependencies_obf.jar decompile/

cd decompile
jd-cli SampleCipher-1.0-SNAPSHOT-jar-with-dependencies_obf.jar
jar xvf SampleCipher-1.0-SNAPSHOT-jar-with-dependencies_obf.src.jar

cat sample/tool/cipher/a.java

cd `dirname $0`
