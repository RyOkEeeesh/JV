package jp.ac.hal;

public class Main {
    public static void main(String[] args) {
        int[][] dArr = new int[][]{{0,1,2}, {3,4,5}};
        for (int[] row : dArr) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
