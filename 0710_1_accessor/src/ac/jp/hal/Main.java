package ac.jp.hal;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        RecordClass r = new RecordClass(3, "kaji");
        System.out.println(r.id());
        System.out.println(r.name());
    }
}
