package sample.tool.cipher.decryption;

import sample.tool.cipher.util.EncryptionUtil;

/**
 * 暗号化サンプル
 */
public class DecrpyterNoKeyRequired {
    
    public static void decrypt( String[] args ) throws Exception{
        String cipherText = args[0];
        
        System.out.println(EncryptionUtil.decrypt(cipherText));
        
    }
}
