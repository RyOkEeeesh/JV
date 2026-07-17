package jp.ac.hal;

public class Car {
    // 継承(inheritance)
    // → クラスのメンバを引き継ぐ
    private String maker;
    protected double gas;
    // protected: 子 or 同一パッケージに公開

    public Car(String maker, double gas) {
        this.maker = maker;
        this.gas = gas;
    }

    public void drive() {
        System.out.println("driving...");
    }
}
