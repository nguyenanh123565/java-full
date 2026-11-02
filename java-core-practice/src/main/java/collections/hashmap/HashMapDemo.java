package collections.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("An", 8);
        // Đoán output: put trả giá trị cũ; cùng key sẽ thay value.
        System.out.println(scores.put(new String("An"), 9));
        System.out.println(scores.size());
        scores.put("Bình", null);
        System.out.println(scores.get("Bình"));
        System.out.println(scores.get("Chi"));
        System.out.println(scores.containsKey("Bình"));
        System.out.println(scores.containsKey("Chi"));
        // get trả null cho cả key không tồn tại lẫn value null.
    }
}
