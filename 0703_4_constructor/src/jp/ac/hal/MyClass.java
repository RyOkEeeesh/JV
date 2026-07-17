package jp.ac.hal;

public class MyClass {
    // [コンストラクタ定義書式]
    // [アクセス修飾子] クラス名([引数リスト]){}
    // 注意：メソッドだけど、戻り値の型は書かない！
	
	MyClass() {
		System.out.println("コンストラクタ動作");
	}
	
    // デフォルトコンストラクタ
    // コンストラクタが明示的に
    // 記述されていない場合、コンパイラが
    // 引数なしのコンストラクタを
    // 自動で生成している。
    // これを、デフォルトコンストラクタと言う。
	// memo:上のコンストラクタに引数を追加して、
	// エラーになることを確認する
	
	// コンストラクタ&オーバーロード
	private int id;
	private String name;
	MyClass(int id, String name) {
        // this()でコンストラクタ呼び出し。
        this(id);
        //注意：自コンストラクタ呼び出しは、
        //最初(1行目)に書く必要がある。
       
        // this.id = id; // このコードは↑の方が良い。
        this.name = name;
	}
	
	MyClass(int id) {
		this.id = id;
	}
	
}
