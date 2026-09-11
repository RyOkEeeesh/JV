package jp.ac.hal;

public class Warrior extends Character {
    public Warrior(String name, int health) {
        super(name, health);
    }

    @Override
    int attack() {
        return Math.random() < 0.1 ? 50 : 10;
    }
}
