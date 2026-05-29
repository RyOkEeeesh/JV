package jp.ac.hal;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // 1
        System.out.println("Hello");

        // 2
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        // 3
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        // 4
        System.out.print("名前を入力してください: ");
        String name = sc.nextLine();
        System.out.println("ハロー" + name);

        // 5
        System.out.print("得点を入力してください: ");
        int point = sc.nextInt();

        if (point >= 90) {
            System.out.println("A");
        } else if (point >= 70) {
            System.out.println("B");
        } else if (point >= 50) {
            System.out.println("C");
        } else if (point >= 30) {
            System.out.println("D");
        } else {
            System.out.println("E");
        }

        // 6
        System.out.print("0~4の数字を入力してください: ");
        int num = sc.nextInt();

        switch (num) {
            case 0 -> System.out.println("オレンジ");
            case 1 -> System.out.println("アップル");
            case 2 -> System.out.println("グレープ");
            case 3 -> System.out.println("ストロベリー");
            case 4 -> System.out.println("レモン");
            default -> System.out.println("0~4の範囲で入力してください");
        }

        // 7
        System.out.print("半径を入力してください: ");
        int rad = sc.nextInt();
        System.out.println("面積は" + (int)(rad * rad * Math.PI) + "です");

        // op1
        int count = 0;
        int r = rand.nextInt(10);
        int ans = -1;
        do {
            System.out.print("0~9の数値を入力してください: ");
            ans = sc.nextInt();
            count++;
        } while (ans == r);

        System.out.println("正解！");
        System.out.println("試行回数" + count);

        // op2
        int sum = 0;
        while (true) {
            System.out.println("単価と個数を入力してください。終了する場合は -1 を入力してください");
            System.out.print("単価: ");
            int price = sc.nextInt();
            if (price == -1) {
                break;
            }
            System.out.print("数量: ");
            int quantity = sc.nextInt();
            sum += price * quantity;
        }

        System.out.printf(
                "税込価格: %d\n税込価格: %d",
                sum,
                (int)(sum + sum * Constants.TAX)
        );

        sc.close();
    }

    public static class Constants {
        public static final float TAX = 0.10f;
    }
}
