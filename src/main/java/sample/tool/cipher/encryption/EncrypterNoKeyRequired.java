package sample.tool.cipher.encryption;

import sample.tool.cipher.util.EncryptionUtil;

/**
 * 暗号化サンプル
 */
public class EncrypterNoKeyRequired {
    
    public static void encrypt( String[] args ) throws Exception{
        String plainTextString = args[0];
        
        System.out.println(EncryptionUtil.encrypt(plainTextString));
        
    }
}
