package sample.tool.cipher.decryption;

public class DecrypterMain {
    public static void main( String[] args ) throws Exception{
        // 引数の個数で振り分ける。
        // 設計が妥当かどうかは無視。
        if (args.length == 1) {
            DecrpyterNoKeyRequired.decrypt(args);
        } else if (args.length >= 2){
            DecrpyterGetKeyFromArgument.decrypt(args);
        }
    }
}