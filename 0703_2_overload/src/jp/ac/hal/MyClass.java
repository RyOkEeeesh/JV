package jp.ac.hal;

public class MyClass {
    // オーバーロード
    // 同一のメソッド名に、複数のメソッドが作成可能
    // ただし、引数にて差異を持たせる
    void a() {
        System.out.println(1);
    }

    //同一メソッド名は基本NG
//    void a() {
//        System.out.println("a");
//    }

    void a(int i) {
        System.out.println(i);
    }
}
