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

## 難読化

ProGuardを使う。cloud9に入れられなかったので、Dockerコンテナに入れる。

```
mkdir workdir
cp target/SampleCipher-1.0-SNAPSHOT-jar-with-dependencies.jar workdir
docker-compose build --force-rm
docker-compose up
```

### 実行例

ほとんど変わらん！
```java
package sample.tool.cipher;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SampleCipher {
  public static final String CHARSET = "Shift_JIS";
  
  public static final String ALGORITHM = "AES";
  
  public static void main(String[] paramArrayOfString) {
    String str2 = paramArrayOfString[0];
    String str1 = paramArrayOfString[1];
    Cipher cipher = Cipher.getInstance("AES");
    byte[] arrayOfByte1 = str1.getBytes("Shift_JIS");
    byte[] arrayOfByte2 = toBytes(str2);
    cipher.init(1, new SecretKeySpec(arrayOfByte2, "AES"));
    System.out.println(toHexString(cipher.doFinal(arrayOfByte1)));
  }
  
  private static byte[] toBytes(String paramString) {
    if (paramString.length() % 2 == 1)
      paramString = "0" + paramString; 
    byte[] arrayOfByte;
    for (int i = (arrayOfByte = new byte[paramString.length() / 2]).length - 1; i >= 0; i--) {
      String str = paramString.substring(i << 1, (i << 1) + 2);
      arrayOfByte[i] = (byte)Integer.parseInt(str, 16);
    } 
    return arrayOfByte;
  }
  
  private static String toHexString(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length << 1);
    for (byte b = 0; b < paramArrayOfbyte.length; b++) {
      if (paramArrayOfbyte[b] >= 0 && paramArrayOfbyte[b] < 16)
        stringBuilder.append('0'); 
      stringBuilder.append(Integer.toHexString(0xFF & paramArrayOfbyte[b]));
    } 
    return stringBuilder.toString();
  }
}
```