package sample.tool.cipher.encryption;

public class EncrypterMain {
    public static void main( String[] args ) throws Exception{
        // 引数の個数で振り分ける。
        // 設計が妥当かどうかは無視。
        if (args.length == 1) {
            EncrypterNoKeyRequired.encrypt(args);
        } else if (args.length >= 2){
            EncrypterGetKeyFromArgument.encrypt(args);
        }
    }
}
