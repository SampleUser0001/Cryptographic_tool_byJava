package sample.tool.cipher;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 暗号化サンプル
 */
public class SampleCipher {
    public static final String CHARSET = "Shift_JIS";
    public static final String ALGORITHM = "AES";
    
    public static void main( String[] args ) throws Exception{
        ExecuteCipher.encrypt(args);
    }
}
