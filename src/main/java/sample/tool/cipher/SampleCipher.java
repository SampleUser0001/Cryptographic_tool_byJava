package sample.tool.cipher;

/**
 * 暗号化サンプル
 */
public class SampleCipher {
    public static void main( String[] args ) throws Exception{
        // 引数の個数で振り分ける。
        // 設計が妥当かどうかは無視。
        if (args.length == 1) {
            NoKeyRequired.encrypt(args);
        } else if (args.length >= 2){
            GetKeyFromArgument.encrypt(args);
        }
    }
}
