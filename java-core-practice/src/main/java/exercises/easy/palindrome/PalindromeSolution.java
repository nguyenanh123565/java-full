package exercises.easy.palindrome;

import java.util.*;

public class PalindromeSolution {
    // Lời giải mẫu; input không null. Quy ước và trường hợp biên xem README.
    public static boolean isPalindrome(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) if (text.charAt(left++) != text.charAt(right--)) return false;
        return true;
    }

    public static void main(String[] args) {
        // Bài 1: đối chiếu kết quả đã dự đoán.
        // Bài 2: phương thức ở trên thực hiện thuật toán.
        // Bài 3: các ví dụ dưới có trường hợp biên; giải thích vì sao đúng.
        for (String text : new String[]{"level", "java", "Aa", "", "a", "ab ba", "abba", "abca"})
        System.out.println("[" + text + "] -> " + isPalindrome(text));
    }
}
