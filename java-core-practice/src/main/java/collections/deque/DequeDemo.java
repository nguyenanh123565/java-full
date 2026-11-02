package collections.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();
        history.push("Trang A"); // push thêm ở đầu.
        history.push("Trang B");
        // Đoán output: stack theo LIFO, phần tử vào sau ra trước.
        System.out.println(history.peek());
        System.out.println(history.pop());
        System.out.println(history.pop());
    }
}
