public class Main {
    public static void main(String[] args) {
        //TIP Javaの基本的なプリミティブ型は8つ
        byte b = 0;     // 整数1byte
        short s = 0;    // 整数2byte
        int i = 0;      // 整数4byte
        long l = 0;     // 整数8byte
        float f = 0.1f; // 浮動小数4byte
        double d = 0.1; // 浮動小数8byte
        char c = 'a';   // 1文字
        boolean bo = false; // 真偽
        //TIP 基本的に、大きい器に小さいデータは入る
        s = b;
        d = i;
        //TIP 明示的な型変換(キャスト)
        // を行えば、逆も可能で可能になる
        // ただし、消失覚悟で
        // [書式]
        // (変換後の型)変換前のデータ
        i = (int)d;
        System.out.println(i);
        int num = (int)1.9;
        System.out.println(num);
        //TIP 型の違う物同士の計算は、大きい方に寄る。
        System.out.println(2 * 3.4);

        System.out.println(2 * 3.4 * 1.2 * 4 * 5.2 * 6.9);

        //TIP オブジェクト（機能を持つデータ）として扱うことができる
        // 参照型のラッパークラス8つ
        Byte by = 0;
        Short sh = 0;
        Integer in = 0;
        Long lo = 0L;
        Float fl = 0.0f;
        Character ch = 'a';
        Boolean boo = false;
    }
}