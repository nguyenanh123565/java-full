package exercises.easy.valid_parentheses;

import java.util.*;

public class ValidParenthesesSolution {
    // Lời giải mẫu; input không null. Quy ước và trường hợp biên xem README.
    public static boolean isValid(String text) {
        Deque<Character> opens = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') opens.push(ch);
            else {
                char expected;
                switch (ch) {
                    case ')' -> expected = '(';
                    case ']' -> expected = '[';
                    case '}' -> expected = '{';
                    default -> { return false; }
                }
                if (opens.isEmpty() || opens.pop() != expected) return false;
            }
        }
        return opens.isEmpty();
    }

    public static void main(String[] args) {
        // Bài 1: đối chiếu kết quả đã dự đoán.
        // Bài 2: phương thức ở trên thực hiện thuật toán.
        // Bài 3: các ví dụ dưới có trường hợp biên; giải thích vì sao đúng.
        for (String text : new String[]{"([]{})", "([)]", ")(", "", "(", "]", "a"})
        System.out.println("[" + text + "] -> " + isValid(text));
    }
}
