package jp.ac.hal;

public class Main {

    public static void main(String[] args) {
        // 値呼び出し、参照呼び出しについて。
        // 要は、メソッドの引数の受け渡しについての話。
        // 値渡し、参照渡しとも言われる。
        // （pass by value, pass by ref）

        // 値渡し
        // データそのもののコピーを受け渡す。
        // →オリジナルに影響をきたさない。
        int i = 0;
        System.out.println(i);
        a(i);
        System.out.println(i);

        // 参照渡し
        // アドレスのコピーを受け渡す。
        // →オリジナルに影響をきたす。
        int[] list = {1, 2, 3};
        System.out.println(list[1]);
        b(list);
        System.out.println(list[1]);

        // 何を持って値渡し、参照渡しになるのか
        // プリミティブ型を受け渡す→値渡し
        // プリミティブ型以外を受け渡す→参照渡し

        User user = new User(5, "a");
        System.out.println(user.getId() + user.getName());
        c(user);
        System.out.println(user.getId() + user.getName());

        // 上の様に、引き渡したデータを壊すメソッドを
        // 特に、「破壊的なメソッド」と言う。
        // 参照渡しの利点は、メモリの節約。
        // ソートアルゴリズムを例としたとき、
        // 破壊的なメソッドは、メモリが節約される。
        // 逆に破壊的でないメソッドの場合、
        // 並び替え前のオリジナルデータの複製がなされ、
        // その複製に対し並び替えが行われる。
        // 結果、戻り値で先頭アドレスを返却する。
        // →オリジナルデータは保持されるが、
        // メモリを倍食うことになる。

        d(user);
        System.out.println(user.getId() + user.getName());

        String s = "d";
        e(s);
        System.out.println(s);
    }

    static void a(int i) {
        i = 1;
    }

    static void b(int[] list) {
        list[1] = 4;
    }

    static void c(User user) {
        user.setId(6);
        user.setName("b");
    }

    static void d(User user) {
        user = new User(7, "c");
    }

    static void e(String s) {
        s = "e";
    }
}
