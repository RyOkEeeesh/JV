package jp.ac.hal;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 多態性(ポリモーフィズム)
        // オブジェクト指向３大要素の
        // 最後の１つ。
        // 同一のメッセージで、
        // インスタンスによって異なる
        // 動作をすること。
        Animal animal = (new Random()).nextBoolean() ? new Cat() : new Dog();

        animal.naku();
    }
}
