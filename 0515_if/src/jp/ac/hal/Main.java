package jp.ac.hal;

public class Main {

    public static void main(String[] args) {
        // 比較演算子
        System.out.println(0 == 0);
        System.out.println(0 != 0);
        System.out.println(0 < 0);
        System.out.println(0 <= 0);
        System.out.println(0 > 0);
        System.out.println(0 >= 0);


        // 数値と、文字数字の比較はできない
        // System.out.println(0 == "0");

        int a = 0;
        System.out.println(a == 0.0); // 大きい方に寄る

        System.out.println(true && true); // and
        System.out.println(true || true); // or
        System.out.println(!true); // not

        // if
        if(true) {
            System.out.println(1);
        }

        if(false) {
            System.out.println(1);
        }else {
            System.out.println(2);
        }

        if(false) {
            System.out.println(1);
        }else if(true) {
            System.out.println(3);
        }

        // 三項演算子
        int b = 0;
        String c = b == 0 ? "zero" : "other";

        // if(a == 0) {
        // 	b = "zero";
        // }else {
        // 	b = "other";
        // }

        // スクリプト言語の様に、
        // 真偽型以外は受け付けてはくれない
        // if(1) {}

        // 多分岐(一枚比較)
        int type = 0;
        switch(type) {
            case 0:
                System.out.println(0);
                break;
            case 1:
                System.out.println(1);
                //break;
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println(9);
        }

        // Java12以降のswitch new講文
        // Point
        // ・アロー演算子」（→）を使う
        // ・break不要
        // ・カンマで複数値の列強可能
        // ・基本１行。複数行はブロックで
        // ・変数に代入ができる
        type = 0;
        switch(type) {
            case 0 -> System.out.println(0);
            case 1 -> System.out.println(10);
            case 2 -> System.out.println(20);
            case 3, 4 -> {
                System.out.println(30);
                System.out.println(40);
            }
        }

        type = 0;
        String result = switch(type) {
            case 0 -> "a";
            case 1 -> "b";
            case 2 -> "c";
            default -> "other";
        };
        System.out.println(result);
        // Java21以降
        // ・nullチェックが可能に
        // ・whenによる追加条件
        String s = null;
        result = switch(s) {
            case null -> "から";
            default -> "other";
        };
        System.out.println(result);

        String s1 = "aaaa";
        result = switch (s1) {
            case String w when w.length() > 3 -> "３文字以上";
            default -> "３文字未満";
        };
        System.out.println(result);
    }
}