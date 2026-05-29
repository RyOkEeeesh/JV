package jp.ac.hal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("金額: ");
        int price = sc.nextInt();
        float tax = price * Constants.TAX;
        float total = price + tax;
        System.out.printf(
                "税額: %f\n税込価格: %f\n税込価格(整数): %d",
                tax,
                total,
                (int) total
        );

        sc.close();
    }

    public static class Constants {
        public static final float TAX = 0.10f;
    }
}
