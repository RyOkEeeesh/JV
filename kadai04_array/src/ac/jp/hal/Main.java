package ac.jp.hal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        int[] points = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.print("点数: ");
            points[i] = sc.nextInt();
        }

        String result = Arrays.stream(points)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("入力一覧" + result);
        System.out.println("最高得点" + Arrays.stream(points).max().getAsInt());
        System.out.println("最低得点" + Arrays.stream(points).min().getAsInt());
        System.out.println("平均点" + (int) Arrays.stream(points).average().orElse(0.0));

        // op2
        System.out.println("アンケート集計アプリ");
        final int M = 10;
        int[] counts = new int[5];
        int sum = 0;

        for (int i = 0; i < M; i++) {
            System.out.print("アンケート結果(1~5)");
            int a = sc.nextInt();
            if (a == -1) {
                break;
            }
            counts[a]++;
            sum++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + ": " + counts[i]);
        }

        System.out.println("total: " + sum);
    }
}
