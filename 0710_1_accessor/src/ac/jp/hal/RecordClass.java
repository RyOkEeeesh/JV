package ac.jp.hal;

// record クラス ※Java 16（2021年）で正式機能になった。
// データ保持専用のクラス。
// ゲッターをフィールド名の形式で呼び出せる。
// 設計思想として不変(Immutable)のデータのため、書き換えのセッターはない。

public record RecordClass(int id, String name) {}
