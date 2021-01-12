package sample.tool.cipher;

/**
 * 暗号化サンプル
 */
public class NoKeyRequired {
    
    public static void encrypt( String[] args ) throws Exception{
        String keyString = "0123456789abcdef0123456789abcdef";
        String plainTextString = args[0];
        
        System.out.println(EncryptionUtil.encrypt(keyString, plainTextString));
        
    }
}
