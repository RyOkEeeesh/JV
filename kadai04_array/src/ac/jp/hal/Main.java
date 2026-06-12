package ac.jp.hal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] seats = new int[50];

        int firstSeat;
        int lastSeat;

        while (true) {
            System.out.print("開始座席番号を入力してください: ");
            firstSeat = sc.nextInt();
            System.out.println(firstSeat);
            if (firstSeat == -1) {
                break;
            }
            System.out.print("終了座席番号を入力してください: ");
            lastSeat = sc.nextInt();
            System.out.println(lastSeat);

            Arrays.fill(seats, firstSeat, lastSeat + 1, 1);

            for (int i = 0; i < seats.length; i++) {
                System.out.print(seats[i]);
                if ((i + 1) % 10 == 0) {
                    System.out.println();
                }
            }
        }

        // op1
        System.out.println("スコア集計アプリ");
        final int N = 5;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringJoiner sj = new StringJoiner(",");

        for (int i = 0; i < N; i++) {
            System.out.print("点数: ");
            int n = sc.nextInt();
            sum += n;
            sj.add(String.valueOf(n));
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        System.out.println("入力一覧 " + sj);
        System.out.println("最高得点 " + max);
        System.out.println("最低得点 " + min);
        System.out.println("平均点 " + sum / N);

        // op2
        System.out.println("アンケート集計アプリ");
        final int M = 10;
        int[] counts = new int[5];
        sum = 0;

        for (int i = 0; i < M; i++) {
            System.out.print("アンケート結果(1~5)");
            int a = sc.nextInt();
            if (a == -1) {
                break;
            }
            counts[a-1]++;
            sum++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + 1 + ": " + counts[i]);
        }

        System.out.println("total: " + sum);

        sc.close();
    }
}
