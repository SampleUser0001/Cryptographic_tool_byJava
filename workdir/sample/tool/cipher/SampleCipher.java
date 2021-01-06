package sample.tool.cipher;

public class SampleCipher {
  public static final String CHARSET = "Shift_JIS";
  
  public static final String ALGORITHM = "AES";
  
  public static void main(String[] args) throws Exception {
    ExecuteCipher.encrypt(args);
  }
}
