package exercises.easy.count_frequency;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountFrequencyDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> counts = new LinkedHashMap<>();
        // Dự đoán output: put ghi đè value, không tạo thêm key trùng.
        System.out.println(counts.getOrDefault(2, 0));
        counts.put(2, 1);
        counts.put(2, 2);
        System.out.println(counts.size());
        System.out.println(counts.get(2));
    }
}
