package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamSolution {
    public static List<Integer> evenSquares(List<Integer> values) {
        return values.stream().filter(n -> n % 2 == 0).map(n -> n * n).toList();
    }

    public static Map<String, Long> wordCounts(List<String> words) {
        return words.stream().map(word -> word.trim().toLowerCase(Locale.ROOT))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(word -> word, TreeMap::new, Collectors.counting()));
    }

    public static List<Integer> topThree(List<Integer> scores) {
        return scores.stream().filter(score -> score >= 0).distinct()
                .sorted(Comparator.reverseOrder()).limit(3).toList();
    }

    public static void main(String[] args) {
        // Bài 1: filter giảm số phần tử cần map.
        System.out.println(evenSquares(List.of(1, 2, 3, 4)));
        // Bài 2: TreeMap giúp in kết quả theo thứ tự khóa ổn định.
        System.out.println(wordCounts(List.of(" Java ", "java", "Core", "")));
        // Bài 3: chỉ kết quả được sắp xếp, nguồn không bị thay đổi.
        List<Integer> scores = List.of(9, 5, 9, -1, 8, 7);
        System.out.println(topThree(scores));
        System.out.println(scores);
    }
}
