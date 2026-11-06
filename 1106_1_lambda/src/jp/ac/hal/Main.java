package jp.ac.hal;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        MyIF m = new Sample();
        m.myMethod();

        // 匿名(無名)クラス(Anonymous class)
        // わざわざクラスファイルを
        // 作らずに、インタフェースの
        // 実装ができる。

        MyIF m2 = new MyIF() {
            @Override
            public void myMethod() {
                System.out.println("mm");
            }
        };

        m2.myMethod();

        // ラムダ式
        // 匿名クラスの簡素化した記述方法。
        // ただし、関数型インタフェースで
        // あることが必須。
        // [書式]
        // (引数定義) -> {実処理};

        MyIF m3 = () -> {};
        m3.myMethod();

        // java.util.functionに基本的な関数型インタフェースが定義されている。
        // ※以下で出現するT, Rは、任意の参照型。
        // Consumer<T> … void accept(T t) → 引数Tを受け取り、戻り値は返さない。
        // Supplier<T> … T get() → 引数は無しで、戻り値Tを返す。
        // Predicate<T> … boolean test(T t) → 引数Tを受け取り、booleanを返す。
        // Function<T, R> … R apply(T t) → 引数Tを受け取り、戻り値Rを返す。
        // Operator<T> … T apply(T t) → 引数Tを受け取り、戻り値Tを返す。
        // その他命名規則として、
        //  Unary～ … ユーナリー。引数を１つ受け取る。
        //  Bi～, Binary～ … バイナリー。引数を２つ受け取る。 ※おまけ。3つはターナリー。
        //  Boolean～,Double～等 … その型が引数や、戻り値の型となる。
        // ①To②～ … ①が引数の型、②が戻り値の型。
        // java.util.function. で試してみよう！

        // 引数あり戻り値なし
        Consumer<Integer> c = (Integer i) -> {
            System.out.println(i);
        };

        c.accept(100);

        // 引数なし戻り値あり
        Supplier<String> s = () -> {
            return "hello";
        };

        System.out.println(s.get());

        // 引数戻り値ともにあり
        Function<Integer, String> f = (Integer v) -> {
            return "¥" + v;
        };

        System.out.println(f.apply(100));

        Function<Integer, String> f2 = (v) -> {
            return "¥" + v;
        };

        System.out.println(f2.apply(100));

        // もっと省略
        //  ・１行なら{}不要
        //  ・１行ならreturn不要
        //  ・引数１つだけなら()不要

        Function<Integer, String> s3 = v -> "¥" + v;

        System.out.println(s3.apply(100));

        //関数型インタフェース
        // 抽象メソッドを１つだけもつ
        // インタフェースのこと。
        // クラスアノテーションとして、
        // @FunctionalInterface
        // がある。

        // 1. 引数あり・戻り値なしの例
        @FunctionalInterface
        interface Greeting {
            void sayHello(String name);
            // ※ 抽象メソッドをもう1つ追加しようとすると、
            //    @FunctionalInterface によってコンパイルエラーとして検知される。
            // void test();
        }

        // ラムダ式による実装
        Greeting greeting = (name) -> System.out.println("こんにちは、" + name + "さん！");
        greeting.sayHello("HAL");

        // 2. 引数あり・戻り値ありの例
        @FunctionalInterface
        interface Calculation {
            int calc(int a, int b);
        }

        Calculation add = (a, b) -> a + b;
        int result = add.calc(10, 20);
        System.out.println("計算結果: " + result);
    }
}
