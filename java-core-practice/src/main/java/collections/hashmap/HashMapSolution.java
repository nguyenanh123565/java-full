package collections.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class HashMapSolution {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("An", 8);
        System.out.println("Bài 1, điểm cũ: " + scores.put("An", 9));
        scores.put("Bình", null);
        System.out.println("Size: " + scores.size());
        System.out.println("Bình: " + scores.get("Bình") + ", có key: " + scores.containsKey("Bình"));
        System.out.println("Chi: " + scores.get("Chi") + ", có key: " + scores.containsKey("Chi"));

        Map<String, Integer> frequencies = new HashMap<>();
        for (String word : List.of("java", "core", "java", "map", "core")) {
            frequencies.merge(word, 1, Integer::sum);
        }
        System.out.println("Bài 2: " + new TreeMap<>(frequencies));

        Map<Key, String> values = new HashMap<>();
        values.put(new Key("A"), "Alpha");
        values.put(new Key("B"), "Beta");
        System.out.println("Bài 3, size: " + values.size()); // 2 dù cùng hash.
        System.out.println("Lookup A: " + values.get(new Key("A")));
        // Hash xác định vùng tìm; equals phân biệt key va chạm.
        // Key bất biến giữ dữ liệu nhận diện ổn định trong toàn bộ thời gian nằm trong map.
    }

    private static final class Key {
        private final String id;

        private Key(String id) {
            this.id = Objects.requireNonNull(id);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof Key)) return false;
            Key key = (Key) other;
            return id.equals(key.id);
        }

        @Override
        public int hashCode() {
            return 1; // Cố tình tạo collision để học; không dùng thiết kế này trong thực tế.
        }
    }
}
