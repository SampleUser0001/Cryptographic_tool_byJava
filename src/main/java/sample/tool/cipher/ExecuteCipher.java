package sample.tool.cipher;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 暗号化サンプル
 */
public class ExecuteCipher {
    public static final String CHARSET = "Shift_JIS";
    public static final String ALGORITHM = "AES";
    
    public static void encrypt( String[] args ) throws Exception{
        String keyString = "0123456789abcdef0123456789abcdef";
        String plainTextString = args[1];
        
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        byte[] plainTextBytes = plainTextString.getBytes(CHARSET);
        byte[] keyBytes = toBytes(keyString);
        
        cipher.init(1, new SecretKeySpec(keyBytes, ALGORITHM));
        System.out.println(toHexString(cipher.doFinal(plainTextBytes)));
        
    }

    private static byte[] toBytes(String hexString){
        byte[] bytes = null;
        if(hexString.length() % 2 == 1){
            hexString = '0' + hexString;
        }
        bytes = new byte[hexString.length() / 2];
        for(int i= bytes.length -1 ; i>=0 ;i--){
            String b = hexString.substring(i*2, i*2+2);
            bytes[i] = (byte)Integer.parseInt(b,16);
        }
        return bytes;
    }
    
    private static String toHexString(byte[] byteArray){
        StringBuilder builder = new StringBuilder(byteArray.length * 2);
        for(int i=0; i<byteArray.length; i++){
            if(byteArray[i] >= 0 && byteArray[i] < 16){
                builder.append('0');
            }
            builder.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return builder.toString();
    }
}
