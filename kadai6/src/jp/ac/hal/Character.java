package jp.ac.hal;

import java.util.concurrent.TimeUnit;

abstract class Character {
    private String name;
    private int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    abstract int attack();

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = Math.max(health, 0);
    }
}
