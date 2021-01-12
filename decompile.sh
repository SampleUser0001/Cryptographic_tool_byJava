#!/bin/bash

export OBF_FILENAME=SampleCipher-1.0.1-SNAPSHOT-jar-with-dependencies_obf.jar
export OBF_SRC_FILENAME=SampleCipher-1.0.1-SNAPSHOT-jar-with-dependencies_obf.src.jar

rm -rf decompile
mkdir decompile
cp workdir/${OBF_FILENAME} decompile/

cd decompile
jd-cli ${OBF_FILENAME}
jar xvf ${OBF_SRC_FILENAME}

cat sample/tool/cipher/SampleCipher.java

cd `dirname $0`
