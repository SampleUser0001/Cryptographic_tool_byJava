# Cryptographic_tool_byJava
暗号化ツール（Java版）  
ProGuardを使って暗号化ツールを暗号化したい。

## 実行

### 暗号化キー指定
```
mvn clean compile exec:java -Dexec.mainClass="sample.tool.cipher.SampleCipher" -Dexec.args="'<暗号化キー>' '<平文>'"
```

#### 実行例

```
mvn clean compile exec:java -Dexec.mainClass="sample.tool.cipher.SampleCipher" -Dexec.args="'0123456789abcdef0123456789abcdef' 'hogehoge'"
```

実行結果
```
516699c161e25bb692723f3e0e23dfba
```

### 内部の暗号化キーを使用

```
mvn clean compile exec:java -Dexec.mainClass="sample.tool.cipher.SampleCipher" -Dexec.args="'<平文>'"
```

#### 実行例

```
mvn clean compile exec:java -Dexec.mainClass="sample.tool.cipher.SampleCipher" -Dexec.args="hogehoge"
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

key指定する。
```
java -cp SampleCipher-1.0.1-SNAPSHOT-jar-with-dependencies.jar sample.tool.cipher.SampleCipher 0123456789abcdef0123456789abcdef hogehoge
```

key指定しない。
```
java -cp SampleCipher-1.0.1-SNAPSHOT-jar-with-dependencies.jar sample.tool.cipher.SampleCipher hogehoge
```

## 難読化

ProGuardを使う。cloud9に入れられなかったので、Dockerコンテナに入れる。

```
mkdir workdir
cp target/SampleCipher-1.0.1-SNAPSHOT-jar-with-dependencies.jar workdir
docker-compose build --force-rm
docker-compose up
```

※all.shで全部できる。

### 実行例

```java
package sample.tool.cipher;

public class SampleCipher {
  public static void main(String[] paramArrayOfString) {
    String str;
    if (paramArrayOfString.length == 1) {
      paramArrayOfString = paramArrayOfString;
      String str1 = "0123456789abcdef0123456789abcdef";
      str = paramArrayOfString[0];
      System.out.println(a.a(str1, str));
      return;
    } 
    if (str.length >= 2) {
      String str1 = (str = str)[0];
      str = str[1];
      System.out.println(a.a(str1, str));
    } 
  }
}
```
keyの隠蔽まではできない。

### 難読化後jar実行

keyを指定する。
```
java -cp SampleCipher-1.0.1-SNAPSHOT-jar-with-dependencies_obf.jar sample.tool.cipher.SampleCipher 0123456789abcdef0123456789abcdef hogehoge
```

keyを指定しない。
```
java -cp SampleCipher-1.0.1-SNAPSHOT-jar-with-dependencies_obf.jar sample.tool.cipher.SampleCipher hogehoge
```

## exewrap

[窓の杜:JAR形式のJavaアプリをEXE形式へ変換して扱い易くする「exewrap」](https://forest.watch.impress.co.jp/docs/review/1078991.html)
