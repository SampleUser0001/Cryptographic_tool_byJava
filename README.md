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

#### 変換前

```java
package sample.tool.cipher;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ExecuteCipher {
  public static final String CHARSET = "Shift_JIS";
  
  public static final String ALGORITHM = "AES";
  
  public static void encrypt(String[] args) throws Exception {
    String keyString = "0123456789abcdef0123456789abcdef";
    String plainTextString = args[1];
    Cipher cipher = Cipher.getInstance("AES");
    byte[] plainTextBytes = plainTextString.getBytes("Shift_JIS");
    byte[] keyBytes = toBytes(keyString);
    cipher.init(1, new SecretKeySpec(keyBytes, "AES"));
    System.out.println(toHexString(cipher.doFinal(plainTextBytes)));
  }
  
  private static byte[] toBytes(String hexString) {
    byte[] bytes = null;
    if (hexString.length() % 2 == 1)
      hexString = '0' + hexString; 
    bytes = new byte[hexString.length() / 2];
    for (int i = bytes.length - 1; i >= 0; i--) {
      String b = hexString.substring(i * 2, i * 2 + 2);
      bytes[i] = (byte)Integer.parseInt(b, 16);
    } 
    return bytes;
  }
  
  private static String toHexString(byte[] byteArray) {
    StringBuilder builder = new StringBuilder(byteArray.length * 2);
    for (int i = 0; i < byteArray.length; i++) {
      if (byteArray[i] >= 0 && byteArray[i] < 16)
        builder.append('0'); 
      builder.append(Integer.toHexString(0xFF & byteArray[i]));
    } 
    return builder.toString();
  }
}
```

#### 変換後

```java
package sample.tool.cipher;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class a {
  public static void a(String[] paramArrayOfString) {
    String str2 = "0123456789abcdef0123456789abcdef";
    String str1 = paramArrayOfString[1];
    Cipher cipher = Cipher.getInstance("AES");
    byte[] arrayOfByte1 = str1.getBytes("Shift_JIS");
    if ((str2 = str2).length() % 2 == 1)
      str2 = "0" + str2; 
    byte[] arrayOfByte3;
    for (int i = (arrayOfByte3 = new byte[str2.length() / 2]).length - 1; i >= 0; i--) {
      String str = str2.substring(i << 1, (i << 1) + 2);
      arrayOfByte3[i] = (byte)Integer.parseInt(str, 16);
    } 
    byte[] arrayOfByte2 = arrayOfByte3;
    cipher.init(1, new SecretKeySpec(arrayOfByte2, "AES"));
    System.out.println(a(cipher.doFinal(arrayOfByte1)));
  }
  
  private static String a(byte[] paramArrayOfbyte) {
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
…あんま変わらんな？