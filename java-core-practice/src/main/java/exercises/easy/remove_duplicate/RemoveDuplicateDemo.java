package exercises.easy.remove_duplicate;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateDemo {
    public static void main(String[] args) {
        Set<Integer> seen = new LinkedHashSet<>();
        // Dự đoán output: add trả false nếu giá trị đã có.
        System.out.println(seen.add(3));
        System.out.println(seen.add(1));
        System.out.println(seen.add(3));
        System.out.println(seen);
    }
}
