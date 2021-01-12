package sample.tool.cipher;

public class SampleCipher {
  public static void main(String[] args) throws Exception {
    if (args.length == 1) {
      NoKeyRequired.encrypt(args);
    } else if (args.length >= 2) {
      GetKeyFromArgument.encrypt(args);
    } 
  }
}
