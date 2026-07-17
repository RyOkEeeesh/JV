package jp.ac.hal;

public class Taxi extends Car {
    // [継承書式]
    // extends 親クラス
    // で、親クラスの性質を引き継げる。
    // ※extends…拡張

    // 継承先では、差分のみ開発する。
    private double meter;

    public Taxi(String maker, double gas) {
        super(maker, gas);
    }

    public void startMeter() {
        System.out.println("start meter");
        this.meter = 0.0;

        // 子であれあばprotectedは見える
        System.out.println(this.gas);

        // 親クラス: スーパークラス
        // 子クラス: サブクラス
        // this. じゃなくて、super. でアクセス可能
        System.out.println(super.gas);
    }

    // オーバードライブ
    // 親クラスの処理を書き換える
    // → 同一メソッドを定義すればOK

    @Override
    public void drive() {
        super.drive();
        System.out.println("drive!!!!!!!!!!!!!!!!!!!!!");
    }
}
