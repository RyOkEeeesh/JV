package jp.ac.hal;

public class Main {

    public static void main(String[] args) {
        // インスタンス化
        // [書式]
        // new クラス名()
        new User();

        User user = new User();
        user.method();

        User user2;
        // この状態でのuser2はnull

        // 以下フィールドアクセス(やらないけど)
        user.id = 10;
        user.name = "b";

        user.c(10, 20, 30);
        user.c(100);
        user.c(null);
    }

}