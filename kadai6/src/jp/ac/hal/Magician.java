package jp.ac.hal;

public class Magician extends Character {
    public Magician(String name, int health) {
        super(name, health);
    }

    @Override
    int attack() {
        int correction = (int)(Math.random() * 11);
        if (Math.random() < 0.3) {
            correction = -correction;
        }
        return 20 + correction;
    }
}
