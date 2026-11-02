package exercises.easy.character_frequency;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterFrequencyDemo {
    public static void main(String[] args) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        counts.put('a', 1);
        counts.put('a', counts.getOrDefault('a', 0) + 1);
        // Dự đoán output: 'A' và 'a' là hai key khác nhau.
        System.out.println(counts.get('a'));
        System.out.println(counts.getOrDefault('A', 0));
        System.out.println("a a".length()); // Khoảng trắng cũng là char được tính.
    }
}
