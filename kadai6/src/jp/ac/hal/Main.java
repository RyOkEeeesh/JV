package jp.ac.hal;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Character[] characters = { new Warrior("戦士", 100), new Magician("魔術師", 80) };

        int i = (int)(Math.random() * 2);

        outer:
        while (true) {
            int idx = i % 2;
            int damage = attack(characters[idx]);
            boolean dead = attacked(characters[idx ^ 1], damage);
            if (dead) {
                System.out.println(characters[idx].getName() + "の勝ち！");
                break;
            }
            i++;
        }
    }

    private static int attack(Character character) throws InterruptedException {
        int power = character.attack();
        System.out.print(character.getName() + "の攻撃！");
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(150);
        }
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(" " + power + " のダメージ！");
        return power;
    };

    private static boolean attacked(Character character, int damage) {
        character.setHealth(character.getHealth() - damage);
        int health = character.getHealth();
        System.out.println("[" + character.getName() +"の残り HP : " + health + "]");
        return health <= 0;
    }
}
