//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
public class Main {
    public static void main(String[] args) {
        System.out.println("a" + "b");
        //TIP 大文字に対して + があるとその他が文字列に変換される
        System.out.println("a" + 1);
        System.out.println("1" + 1);
        System.out.println("1" + true);
        //TIP 超重要注意事項!
        // javaにて、文字列比較 == はNG!
        // 文字列比較は、Stringクラスの .equals メソッドを使う
        StringBuilder a = new StringBuilder("a");
        String b = "a";
        System.out.println(a.toString() == b);
        System.out.println(a.toString().equals(b));

        //TIP 参照型の変数はその変数自体に実態を持っていない。実態は別で存在し変数にはその実態の先頭アドレスが格納されいる。なので a == b はポインタの比較を行なっているため常にfalseになる

        for (int i = 0; i < 10_000_000; i++) {
            a.append("b");
//            a += "b";
        }

        System.out.println(a);
    }
}