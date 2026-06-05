package jp.ac.hal;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 配列
        // データが横に連なった形。
        // 配列はメモリ上連続した
        // 領域に確保される。
        // 添え字を用いて要素を指定。
        // 固定長。

        // 配列を使うには、次の３つの手順が必要。
        // ①配列操作用の変数を用意。※先頭アドレス格納用
        // ②配列長分の領域確保。
        // ③各要素値のセット。

        // ①配列操作用の変数を用意。※先頭アドレス格納用
        // [配列変数宣言書式]
        // 型[] 変数名;
        int[] arr;

        System.out.println(Arrays.toString(args));

        // ②配列長分の領域確保。
        arr = new int[3];

        // ③各要素値のセット
        arr[0] = 1;
        arr[1] = 2;

        System.out.println(Arrays.toString(arr));

        // ①と②はまとめてかける
        int[] arr2 = new int[3];

        // 初期値を指定した初期化
        // ※変数宣言時限定
        int[] arr3 = {10, 20, 30, 40};
        String[] arr4 = {"a", "b", "c"};

        // 配列超を取得する時には .length フィールド
        System.out.println(arr2.length);
        System.out.println(arr3.length);

        for (int i = 0; i < arr4.length; i++) {
            System.out.println(arr4[i]);
        }

        String[] names = {"a", "b", "c"};
        for (String name : names) {
            System.out.println(name);
        }
    }
}
