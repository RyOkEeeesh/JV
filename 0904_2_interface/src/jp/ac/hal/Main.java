package jp.ac.hal;

public class Main {
    public static void main(String[] args) {
        Android android = new Android();
        android.play();
        android.stop();

        ((Android)android).patternAuth();
    }
}
