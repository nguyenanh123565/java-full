package exercises.easy.count_frequency;

import java.util.*;

public class CountFrequencySolution {
    // Lời giải mẫu; input không null. Quy ước và trường hợp biên xem README.
    public static Map<Integer, Integer> frequency(int[] values) {
        Map<Integer, Integer> counts = new LinkedHashMap<>();
        for (int value : values) counts.put(value, counts.getOrDefault(value, 0) + 1);
        return counts;
    }

    public static void main(String[] args) {
        // Bài 1: đối chiếu kết quả đã dự đoán.
        // Bài 2: phương thức ở trên thực hiện thuật toán.
        // Bài 3: các ví dụ dưới có trường hợp biên; giải thích vì sao đúng.
        System.out.println(frequency(new int[]{2, 1, 2, -1, 1}));
        System.out.println(frequency(new int[0]));
        System.out.println(frequency(new int[]{5, 5, 5}));
    }
}
