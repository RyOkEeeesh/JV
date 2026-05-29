package jp.ac.hal;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        // for(1, 2, 3)
        for (int j = 1; j < 10; j++) {
            System.out.println(j);
        }

        // 1で変数を宣言し、スコープを小さくすることが推奨される
        for (int j = 1; j < 10; j++) {
            System.out.println(j * 10);
        }

        // 後判定 do-while
        do {
            System.out.println(i--);
        } while (i > 0);

        // 多重ループをラベル+breakで抜ける
        outer:
        for(int j = 1; j < 10; j++) {
            for(int k = 1; k < 10; k++) {
                if (j == 5) {
                    break outer;
                }
                System.out.print((j * k) + "\t");
            }
            System.out.println();
        }
    }
}
