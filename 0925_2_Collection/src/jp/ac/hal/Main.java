package jp.ac.hal;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //  コレクション
        //  動的なデータ群の管理。
        //  静的な配列…要素数が固定
        //  動的なデータ群…要素数が可変

        // 代表的なコレクションとして以下３つを学ぶ
        // ①List … 最も基本的なリスト。
        // ②Set … 数学の集合。要素値の重複がない。順序もない。
        // ③Map … キー名称で要素値を管理。
        // list();
        // set();
        map();
    }

    private static void list() {
        //ArrayList<Integer> list = new ArrayList<>();
        // ↑より↓がスタンダード
        List<Integer> list = new ArrayList<>();

        // 空チェック
        System.out.println(list.isEmpty());

        // 要素の追加
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);

        // 空チェック
        System.out.println(list.isEmpty());

        // 要素の取得（添え字指定）
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        // 要素数の取得
        System.out.println(list.size());

        // 要素数の存在確認
        System.out.println(list.contains(20));
        System.out.println(list.contains(50));

        // 特定要素値の添え字
        System.out.println(list.indexOf(20));
        System.out.println(list.indexOf(50));

        // Forで回す
        for(int v : list) {
            System.out.println(v);
        }

        // 要素の削除　その１　～添え字指定～
        list.remove(0);
        for(int v : list) {
            System.out.println(v);
        }

        // 要素の削除　その2　～ラムダ式～
        list.removeIf(v -> v == 20);
        for(int v : list) {
            System.out.println(v);
        }

    }
    private static void set() {
        Set<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20);

        for(int v : set) {
            System.out.println(v);
        }

        // その他はlistとほぼ一緒なので割愛
    }

    private static void map() {
        Map<String, Integer> colors
                = new HashMap<>();
        // putで追加
        colors.put("red", 10);
        colors.put("green", 20);
        colors.put("blue", 30);
        colors.put("blue", 40);

        // キー名指定で要素値取得
        System.out.println(colors.get("red"));
        System.out.println(colors.get("green"));
        System.out.println(colors.get("blue"));
        System.out.println(colors.get("white"));

        // キーの存在確認
        System.out.println(colors.containsKey("red"));
        System.out.println(colors.containsKey("white"));

        // 要素値の存在確認
        System.out.println(colors.containsValue(20));
        System.out.println(colors.containsValue(50));

        // 全要素の取得　その１
        System.out.println("case1---------------");
        for(String key : colors.keySet()) {
            System.out.println(key + colors.get(key));
        }

        // 全要素の取得　その２
        System.out.println("case2---------------");
        for(int v : colors.values()) {
            System.out.println(v);
        }

        // 全要素の取得　その３
        System.out.println("case3---------------");
        for(Map.Entry<String, Integer> entry : colors.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }

        // 全要素の取得　その４
        System.out.println("case3---------------");
        colors.forEach(
                (k, v) -> System.out.println(k + v)
        );

        // データが存在した場合、
        // その元のデータを生かしたput
        colors.merge("red", 100, (v1 ,v2) ->v1 + v2);
        System.out.println(colors.get("red"));

        // キーが存在しない場合通常のputの動き
        colors.merge("white", 100, (v1 ,v2) ->v1 + v2);
        System.out.println(colors.get("white"));

        // Integerのsumメソッド
        System.out.println(Integer.sum(10, 20));
        colors.merge("red", 100, Integer::sum);
        System.out.println(colors.get("red"));

        // ::は、メソッド参照と言い、
        // 既存のメソッドを、
        // 関数型インタフェースの実装として参照
        // する時に使う。
    }

}
