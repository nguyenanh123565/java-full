package exercises.easy.valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesesDemo {
    public static void main(String[] args) {
        Deque<Character> stack = new ArrayDeque<>();
        stack.push('(');
        stack.push('[');
        // Dự đoán output: stack dùng LIFO, ngoặc mở gần nhất được lấy trước.
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
