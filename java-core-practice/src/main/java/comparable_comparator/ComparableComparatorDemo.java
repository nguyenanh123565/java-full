package comparable_comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparableComparatorDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Binh", "An", "Bao"));
        names.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        // Dự đoán output: độ dài trước, cùng độ dài thì thứ tự từ điển.
        System.out.println(names);
        System.out.println(Integer.compare(Integer.MIN_VALUE, 1));
    }
}
