package ac.jp.hal;

public class User {
    private int id;
    private String name;

    // 命名規則
    // get フィールド名
    // set フィールド名

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
        System.out.println("setId: " + id);
    }
}
