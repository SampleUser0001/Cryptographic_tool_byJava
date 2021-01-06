# Cryptographic_tool_byJava
暗号化ツール（Java版）  
ProGuardを使って暗号化ツールを暗号化したい。

## 実行

```
mvn clean compile exec:java -Dexec.mainClass="sample.tool.cipher.SampleCipher" -Dexec.args="'<暗号化キー>' '<平文>'"
```

### 実行例

```
mvn clean compile exec:java -Dexec.mainClass="sample.tool.cipher.SampleCipher" -Dexec.args="'0123456789abcdef0123456789abcdef' 'hogehoge'"
```

実行結果
```
516699c161e25bb692723f3e0e23dfba
```

## jar生成

```
mvn clean compile package
```

### jar実行

```
cd target
java -cp SampleCipher-1.0-SNAPSHOT-jar-with-dependencies.jar sample.tool.cipher.SampleCipher 0123456789abcdef0123456789abcdef hogehoge
```

