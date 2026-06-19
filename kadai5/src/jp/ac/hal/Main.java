package jp.ac.hal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("OXGame");
        Boolean[] lines = {null, null, null, null, null, null, null, null, null};

        printBoard(lines, true);
        System.out.println(Comment.NUM);

        for (int i = 0; i < 9; i++) {
            boolean isO = (i % 2 == 0);
            while (true) {
                System.out.print("Player" + (isO ? "O " : "X "));
                int in = playerInput(sc);
                if (lines[in] == null) {
                    lines[in] = isO;
                    break;
                }
                System.out.println(Comment.NOT_NULL);
            }
            printBoard(lines, false);

            if (i > 4) {
                Boolean winner = checkLine(lines);
                if (winner != null) {
                    System.out.println((winner ? Constants.O : Constants.X) + "の勝ち！");
                    break;
                }
            }
        }

        sc.close();
    }

    public static int playerInput(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int idx = sc.nextInt() - 1;
                if (idx >= 0 && idx < 9) {
                    return idx;
                } else {
                    System.out.println(Comment.NUM);
                }
            } else {
                System.out.println(Comment.NUM);
                sc.next();
            }
        }
    }

    public static void printBoard(Boolean[] lines, boolean printNum) {
        for (int i = 0; i < lines.length; i++) {
            if (i % 3 == 0) {
                System.out.println(Constants.W);
            }
            System.out.print(Constants.H);

            Boolean isO = lines[i];
            if (isO == null) {
                System.out.print(printNum ? i + 1 : " ");
            } else {
                System.out.print(isO ? Constants.O : Constants.X);
            }

            if ((i + 1) % 3 == 0) {
                System.out.println(Constants.H);
            }
        }
        System.out.println(Constants.W);
    }

    public static Boolean checkLine(Boolean[] lines) {
        int[] bits = {0, 0};

        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == null) continue;

            bits[lines[i] ? 1 : 0] |= (1 << (8 - i));
        }

        for (int mask : Constants.WIN_LINE) {
            if ((bits[1] & mask) == mask) return true;
            if ((bits[0] & mask) == mask) return false;
        }
        return null;
    }

    public static class Constants {
        public static final int[] WIN_LINE = {
                0b111000000,
                0b000111000,
                0b000000111,
                0b100100100,
                0b010010010,
                0b001001001,
                0b100010001,
                0b001010100,
        };

        public static final String W = "---------------";
        public static final String H = " | ";
        public static final String O = "○";
        public static final String X = "✕";
    }

    public static class Comment {
        public static final String NUM = "1~9の間で入力してください";
        public static final String NOT_NULL = "そこはもう埋まってます";
    }

}
