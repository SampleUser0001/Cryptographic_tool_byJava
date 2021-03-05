package sample.tool.cipher.encryption;

import sample.tool.cipher.util.EncryptionUtil;

/**
 * 暗号化サンプル
 */
public class EncrypterGetKeyFromArgument {
    
    public static void encrypt( String[] args ) throws Exception{
        String keyString = args[0];
        String plainTextString = args[1];

        System.out.println(EncryptionUtil.encrypt(keyString, plainTextString));

    }

}
