package exercises.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class MediumDemo {
    public static void main(String[] args) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        counts.put("Java", 1);
        counts.put(new String("Java"), 2);
        // Dự đoán output: Map xét key theo equals, không phải ==.
        System.out.println(counts.size());
        System.out.println(counts.get("Java"));
    }
}
