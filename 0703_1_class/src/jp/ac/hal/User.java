package jp.ac.hal;

public class User {
    // クラス名=ファイル名
    // 1ファイル1クラスが基本

    // クラス値下に書けるのは、
    // 次の２つ
    // ・フィールド（アトリビュート）
    // ・メソッド

    // フィールドの宣言
    int id;
    String name;

    // メソッドの宣言
    // [書式]
    // 戻り値の型メソッド名（引数リスト）{}
    void method() {
        // void...無し。の意。
        System.out.println(1);
    }
    // 引数
    // 各々型が必須
    void a(int a) {}
    void b(int a, boolean b) {}

    // 可変長引数は... で、配列に置き
    void c(int... c) {
        for(int v : c) {
            System.out.println();
        }
    }

    // 戻り値
    void d() {
        return;
    }

    int e() {
        return 0;
    }

    boolean f() {
        return true;
    }

    String g() {
        return "abc";
    }

    String h() {
        return null;
    }

    void i() {
        // メソッド内で宣言された変数は
        // ローカル変数
        // このメソッド内でのみ有効
        int j = 0;
    }

    void j() {
        // pythonのselfは、this
        this.id = 123;
        this.a(id);
        this.b(id, false);
    }
}