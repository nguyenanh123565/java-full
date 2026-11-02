package exercises.easy.character_frequency;

import java.util.*;

public class CharacterFrequencySolution {
    // Lời giải mẫu; input không null. Quy ước và trường hợp biên xem README.
    public static Map<Character, Integer> frequency(String text) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        return counts;
    }

    public static void main(String[] args) {
        // Bài 1: đối chiếu kết quả đã dự đoán.
        // Bài 2: phương thức ở trên thực hiện thuật toán.
        // Bài 3: các ví dụ dưới có trường hợp biên; giải thích vì sao đúng.
        System.out.println(frequency("banana"));
        System.out.println(frequency("Aa a"));
        System.out.println(frequency(""));
        System.out.println(frequency("aaa"));
        System.out.println(frequency("a a"));
    }
}
