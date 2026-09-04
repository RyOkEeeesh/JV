package jp.ac.hal;

public class Main {
    public static void main(String[] args) {
        Sample.sta_f = 20;
        Sample.sta_m();

        Sample sample = new Sample();
        sample.insta_f = 20;
        sample.insta_m();

        sample.sta_f = 15;
        sample.sta_m();
    }
}
