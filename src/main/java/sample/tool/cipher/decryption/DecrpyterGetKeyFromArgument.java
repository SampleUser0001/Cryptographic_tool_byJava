package sample.tool.cipher.decryption;

import sample.tool.cipher.util.EncryptionUtil;

/**
 * 復号サンプル
 */
public class DecrpyterGetKeyFromArgument {
    
    public static void decrypt( String[] args ) throws Exception{
        String keyString = args[0];
        String cipherText = args[1];

        System.out.println(EncryptionUtil.decrypt(keyString, cipherText));

    }

}
