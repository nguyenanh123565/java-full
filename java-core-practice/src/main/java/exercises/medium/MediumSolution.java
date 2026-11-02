package exercises.medium;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MediumSolution {
    public static Character firstUnique(String text) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : text.toCharArray()) counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        for (char ch : text.toCharArray()) if (counts.get(ch) == 1) return ch;
        return null;
    }

    private static String normalize(String word) {
        String result = word.trim().toLowerCase(Locale.ROOT);
        for (int i = 0; i < result.length(); i++) {
            char ch = result.charAt(i);
            if (ch < 'a' || ch > 'z') throw new IllegalArgumentException("Chỉ nhận chữ ASCII a-z");
        }
        return result;
    }

    public static boolean isAnagram(String left, String right) {
        String a = normalize(left), b = normalize(right);
        if (a.length() != b.length()) return false;
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : a.toCharArray()) counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        for (char ch : b.toCharArray()) {
            int count = counts.getOrDefault(ch, 0);
            if (count == 0) return false;
            counts.put(ch, count - 1);
        }
        return true; // Độ dài bằng nhau, mọi phần tử của b đều trừ được.
    }

    public static long maxWindowSum(int[] values, int k) {
        if (k <= 0 || k > values.length) throw new IllegalArgumentException("k không hợp lệ");
        long sum = 0;
        for (int i = 0; i < k; i++) sum += values[i];
        long best = sum;
        for (int i = k; i < values.length; i++) {
            sum += (long) values[i] - values[i - k];
            best = Math.max(best, sum);
        }
        return best;
    }

    public static void main(String[] args) {
        // Bài 1: cần thứ tự của nguồn, không dựa vào thứ tự HashMap.
        System.out.println(firstUnique("swiss"));
        System.out.println(firstUnique("aabb"));
        // Bài 2: cùng số lượng mỗi chữ sau chuẩn hóa.
        System.out.println(isAnagram(" Listen ", "silent"));
        // Bài 3: thêm phần tử vào cửa sổ và bỏ phần tử ra.
        System.out.println(maxWindowSum(new int[]{2, 1, 5, 1, 3, 2}, 3));
        System.out.println(maxWindowSum(new int[]{-3, -1, -2}, 2));
    }
}
