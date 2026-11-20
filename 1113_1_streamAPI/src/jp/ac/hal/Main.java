package jp.ac.hal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Stream API
        // コレクションや配列のデータを
        // 関数型スタイルで
        // 簡潔に処理するための仕組み。
        // 保守性と可読性が上がる。
        // 端的に言うと、データ群に対する処理を、
        // スッキリ書けるよ！です。
        // 一般的にはStream APIを用い、
        // 速度が問題となった場合には、
        // 一般的な繰り返し構造との速度差を検証する。

        // Stream APIの基本
        // ①データ群から、Streamを生成する。
        //   Streamは"流れ"で、データ群に対して
        //   ベルトコンベアを付けるイメージ。
        //   これによって、順番にデータ群を
        //   処理することが可能となる。
        // ②中間処理を施す ※複数の処理可
        //   算術処理や、フィルタリング処理等々が行える。
        // ③終端処理を施す
        //   それらのデータ群を最後にどうするのか？を決める。
        //   例）出力する。合算する。等々。

        // Collection(データ群)の作成
        int[] prices = new int[] {10, 20,15, 30, 20};
        for (int price : prices) {
            System.out.println(price);
        }

        // Streamの生成
        IntStream is = Arrays.stream(prices);

        // 中間処理を施す

        // 終端処理を施す
        is.forEach(System.out::println);

        // .forEachで、全てのデータに対する"処理"を指定できる。
        // この処理を受け取る引数は「関数型インターフェース」
        // （抽象メソッドが1つだけのインターフェースのため、
        //  ラムダ式や匿名クラスでも記述は可能）。

        // 終端処理を行った後に、さらなる
        // 終端処理は行えない。
        // is.forEach(System.out::println);

        // ①&③を纏めて書ける。(メソッドチェーン)
        Arrays.stream(prices).forEach(System.out::println);

        // ストリームは1回限りの使い捨てなので、
        // この書き方がスタンダード。

        // その他のIntStreamの終端処理。
        System.out.println(Arrays.stream(prices).count());
        System.out.println(Arrays.stream(prices).sum());
        System.out.println(Arrays.stream(prices).max());
        System.out.println(Arrays.stream(prices).min());
        System.out.println(Arrays.stream(prices).average());

        // プリミティブ方にはそのほかに
        // LongSteamとDoubleStreamが存在する

        // 参照方の配列のStream
        String[] emails = {"a", "b", "c"};

        // ジェネリクスで型指定する方式をとる
        Stream<String> stream = Arrays.stream(emails);
        stream.forEach(System.out::println);

        // 参照方のリストのStream生成
        List<String> addr = List.of("a", "b", "c");
        // addしなくても、List.ofで作成できる
        // リストはそのものにstream()が実装されているのでそれをつかう。
        addr.stream().forEach(System.out::println);

        // 中間処理を施す
        List<Integer> scores = List.of(10, 20, 15, 30, 20);
        List<String> names = List.of("bb" ,"a", "ccc", "bac");

        // filter
        scores.stream()
                .filter(score -> score >= 15)
                .forEach(System.out::println);

        names.stream()
                .filter(name -> name.length() >= 2)
                .forEach(System.out::println);

        // 型変換
        names.stream()
                .mapToInt(String::length)
                .forEach(System.out::println);

        // 並び替え 昇順
        names.stream()
                .sorted()
                .forEach(System.out::println);

        // 降順
        names.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        // limit
        scores.stream()
                .limit(2)
                .forEach(System.out::println);

        // skip
        scores.stream()
                .skip(2)
                .forEach(System.out::println);

        // 重複解除
        scores.stream()
                .distinct()
                .forEach(System.out::println);

        // 加工と型変換 map
        names.stream()
                .map(name -> name + "さん")
                .forEach(System.out::println);

        // int -> str
        scores.stream()
                .map(score -> score + "点")
                .filter(score -> score.startsWith("2"))
                .forEach(System.out::println);

        // 中間処理は複数可能
        scores.stream()
                .distinct()
                .filter(score -> score > 10)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);

        // コレクション生成
        List<Integer> newList = scores.stream().toList();
        Object[] newObjects = scores.stream().toArray();

        // コンストラクタを渡し、型指定する
        Integer[] newArray = scores.stream().toArray(Integer[]::new);

        // マッチング
        // anyMatch 何かがマッチしたらtrue
        System.out.println(
            scores.stream().anyMatch(s -> s == 20)
        );

        System.out.println(
            scores.stream().anyMatch(s -> s == 40)
        );

        // allMatch 全てがマッチしたらtrue
        System.out.println(
                scores.stream().allMatch(s -> s >= 10)
        );

        System.out.println(
                scores.stream().allMatch(s -> s > 10)
        );

        // noneMatch
        System.out.println(
                scores.stream().noneMatch(s -> s < 10)
        );

        System.out.println(
                scores.stream().noneMatch(s -> s >= 10)
        );

        // findFirst
        System.out.println(
                names.stream()
                        .filter(name -> name.startsWith("b"))
                        .findFirst()
                        .orElse("Not Found")
        );

        System.out.println(
                scores.stream()
                        .mapToInt(s -> s)
                        .sum()
        );

        System.out.println(
                scores.stream()
                        .reduce(0, Integer::sum)
        );

        // 他にも階乗で全てかけるか
        List<Integer> data = List.of(1, 2, 3, 4, 5);

        System.out.println(
                data.stream()
                        .reduce(1, (fact, val) -> fact * val)
        );

        // MapによるStreamの紹介
        // そのままでは呼べないので、
        // keySet(),values(),entrySet()を経由して
        // ストリームに変換する。
        Map<String, Integer> ages = Map.of(
                "a", 21,
                "c", 23,
                "b", 22
        );

        // キー
        ages.keySet().forEach(System.out::println);

        // バリュー
        ages.values().forEach(System.out::println);

        // キーバリュ＝
        ages.forEach((key, value) -> System.out.printf("%s さん %d 歳%n", key, value));

        // sorted
        ages.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        // キーと値をセット(エントリー)で処理したい場合。
        ages.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(entry -> System.out.printf("%s さん: %d歳%n", entry.getKey(), entry.getValue()));

        // 最後に
        // Stream APIによる関数型スタイルは、
        // Javaだけでなく、Scala、Kotlin、Rust、F#などでも
        // 採用されています。
        // バグが起きにくく、並行処理（マルチコアCPUでの同時処理）に強く、
        // コードが圧倒的に読みやすくなる といったメリットがあるので、是非ものにしましょう！
    }
}
