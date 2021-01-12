package sample.tool.cipher;

/**
 * 暗号化サンプル
 */
public class GetKeyFromArgument {
    
    public static void encrypt( String[] args ) throws Exception{
        String keyString = args[0];
        String plainTextString = args[1];

        System.out.println(EncryptionUtil.encrypt(keyString, plainTextString));

    }

}
