package jp.ac.hal;

import java.util.Optional;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        // Optional
        // nullを考慮したデータ型。
        // 戻り値の型として用いられる。※フィールドや引数としては用いない。
        // 本来の型に加え、「空」といった状態も保持することができる、
        // その空に対する対応が存在する。
        //
        // [背景]
        // 今まではドキュメント(仕様)をしっかり読んで、
        // そのメソッドがnullを返す可能性があるということを知り、
        // その対策コードを記述していた。(例 if(x != null){})
        // よって、nullが返ってくることを知らない状態でプログラミングし、
        // この対策コードがない場合、NullPointerExceptionが実行時に発生していた。
        // このOptionalを使うと、明示的に「null」に近しい「空」を
        // 返却する可能性があるということをプログラマに知らせるため、
        // その対応を考慮した安全なプログラムを記述することができるようになる。
        //
        // [結果]
        // NullPointerExceptionの発生抑制に繋がる。

        // プリミティブ型のOptionalとして、以下3つがある。
        // OptionalInt
        // OptionalLong
        // OptionalDouble

        OptionalInt oi;
        // oi = 1;
        oi = OptionalInt.of(1);

        // Optional型はOptional型
        System.out.println(oi);
        // System.out.println(oi + 1); とか出来ない

        // int型　として取得
        System.out.println(oi.getAsInt());

        // 「空」を表すに当たり、nullではなく、emptyを使う
        OptionalInt oie = OptionalInt.empty();

        // 空チェック　（== null に等しい）
        System.out.println(oie.isEmpty());

        // 存在チェック（!= null に等しい）
        System.out.println(oie.isPresent());

        // getは空の場合、例外が発生する
        // System.out.println(oie.getAsInt());

        if (oi.isPresent()) {
            System.out.println(oi.getAsInt());
        } else {
            System.out.println(0);
        }

        // 存在しない場合を考慮した規定値が指定できる
        System.out.println(oi.orElse(0));

        // 存在しない場合は規定値が用いられる
        System.out.println(oie.orElse(0));

        // 存在する場合の処理の指定
        oi.ifPresent(System.out::println);

        // 存在しない場合を考慮した処理の指定
        oi.ifPresentOrElse(System.out::println, () -> System.out.println("空"));
        oie.ifPresentOrElse(System.out::println, () -> System.out.println("空"));


        Optional<String> os = Optional.of("abc");

        System.out.println(os);
        System.out.println(os.get());
        System.out.println(os.orElse("None"));
    }
}