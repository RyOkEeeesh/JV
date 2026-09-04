package jp.ac.hal;

// abstractクラス...
//   abstractメソッドを持つ場合には、
//   クラスにもabstractの付与が必須。
//   このabstractクラスは、インスタンス化
//   することができない。

public abstract class Animal {
    // abstract...抽象
    // abstractメソッド...
    //   抽象的なメソッドで、
    //   サブクラスでのオーバーライドを
    //   強要する。
    //   ここで処理は書かない。
    public abstract void purr();
//    public abstract void eat();

    public void eat() {
        System.out.println("座る");
        System.out.println("いただきます");

        // 一部処理を抽象メソッドに委ねる
        this.eatImpl();

        System.out.println("ごちそうさまでした");
    }

    protected abstract void eatImpl();

    // 通常のメンバの実装OK
    // ※これが、後に学ぶインタフェースとの差異
    protected String name;
    public void name(String name) {
        this.name = name;
    }
    public String name() {
        return this.name;
    }

    // テンプレ＝とパターン(デザインパターン)
    // 多くの処理が一緒で、一部異なる場合に便利
}
