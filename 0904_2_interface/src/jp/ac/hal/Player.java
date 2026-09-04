package jp.ac.hal;

public interface Player {
    // インタフェースに定義できるのは、
    // 抽象メソッドのみ。
    // これが大前提なので、キーワードとしての
    // abstractは不要。
    public void play();
    public void stop();
}
