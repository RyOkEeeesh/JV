package jp.ac.hal;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("ToYoCha", 0.8);
        car.drive();

        Taxi taxi = new Taxi("MaTyuDa", 1.2);
        taxi.drive();
        taxi.startMeter();

        // こクラスのインスタンスは、親クラスの枠で保持できる
        Car car2 = new Taxi("ToYoCha", 0.8);
        car2.drive();
        // これはできない
        // car2.startMater();
        // キャストを使えばできる
        ((Taxi)car2).startMeter();

        // Taxi taxi2 = new Car(null, 1.2); これはできない

        // 最も大きい器(すべてのクラスの源流)
        // → Object
        Object o1 = 1;
        Object o2 = 2;
        Object a = "a";
        Object c1 = new Car(null, 1.0);
        Object c2 = new Taxi(null, 1.0);
    }
}
