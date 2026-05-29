package jp.ac.hal;

public class Main {
    public static void main(String[] args) throws Exception {
        // Javaの例外処理では、
        // 以下の２つの何れかとなる。
        // ①自分で例外処理を行う。
        // ②メソッドの呼び出し元に、
        // 例外処理をゆだねる。

        // ①自分で例外処理を行う。
        // try-catch構文を用いる。
        try {
            System.out.println(1);
            System.out.println(2);

            // 例外発生
            throw new Exception("エラー");
        } catch (Exception e) {
            System.out.println(3);
            System.err.println(e.getMessage());
        } finally {
            System.out.println("finally");
        }
        System.out.println(4);

        // ②メソッドの呼び出し元に、
        // 例外処理をゆだねる。

        // 例外発生
        // 基本的にこの書き方はしない
        throw new Exception("エラー");
    }
    
}