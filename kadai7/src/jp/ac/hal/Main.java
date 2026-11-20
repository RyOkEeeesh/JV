package jp.ac.hal;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    // 商品レコード
    private record Item(String name, int price, int stock) {
        @Override
        public String toString() {
            return String.format("Item{name='%s', price=%d円, stock=%d個}", name, price, stock);
        }
    }

    // サンプルデータ（商品リスト）の取得
    private static List<Item> makeSampleItems(){
        return List.of(
                new Item("ワイヤレスマウス", 3500, 15),
                new Item("メカニカルキーボード", 12000, 4),
                new Item("USBハブ", 2000, 0),
                new Item("モニターアーム", 8500, 8),
                new Item("Webカメラ", 6000, 12),
                new Item("LEDデスクライト", 4500, 3)
        );
    }
    // サンプルデータ（売上管理用Map: 商品名と販売個数）の取得
    private static Map<String, Integer> makeSampleSalesMap() {
        return Map.of(
                "ワイヤレスマウス", 45,
                "メカニカルキーボード", 12,
                "モニターアーム", 20,
                "Webカメラ", 30
        );
    }

    public static void main(String[] args) {
        // 商品リストサンプルデータ取得
        List<Item> items = makeSampleItems();

        System.out.println("ex1");
        items.stream()
                .filter(entry -> entry.price <= 5000)
                .forEach(System.out::println);

        System.out.println("ex2");
        System.out.println(
                items.stream().anyMatch(entry -> entry.stock == 0)
        );

        System.out.println("ex3");
        System.out.println(
                items.stream().allMatch(entry -> entry.stock > 0)
        );

        System.out.println("ex4");
        System.out.println(
                items.stream().allMatch(entry -> entry.price > 1000)
        );

        System.out.println("ex5");
        System.out.println(
                items.stream()
                        .mapToInt(Item::stock)
                        .sum()
        );

        System.out.println("ex6");
        System.out.println(
                items.stream()
                        .mapToInt(Item::price)
                        .max()
                        .orElse(0)
        );

        System.out.println("ex7");
        System.out.println(
                items.stream()
                        .filter(entry -> entry.stock >= 10)
                        .map(Item::name)
                        .findFirst()
                        .orElse("該当なし")
        );

        // 売上管理用Mapサンプルデータ取得
        Map<String, Integer> salesMap = makeSampleSalesMap();

        System.out.println("ex8");
        salesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("ex9");
        System.out.println(
                salesMap.values().stream()
                        .reduce(Integer::sum)
                        .orElse(0)
        );

        System.out.println("Miracle Option");
        // 商品リスト(items)
        items.stream()
                .filter(entry -> entry.price >= 5000)
                .sorted(Comparator.comparingInt(Item::price).reversed())
                .limit(2)
                .forEach(System.out::println);
    }
}