package collections.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class DequeSolution {
    public static void main(String[] args) {
        Deque<Integer> numbers = new ArrayDeque<>();
        numbers.offerLast(1);
        numbers.offerLast(2);
        numbers.offerFirst(0);
        System.out.println("Bài 1, đầu: " + numbers.pollFirst());
        System.out.println("Cuối: " + numbers.pollLast());
        System.out.println("Còn lại: " + numbers); // [1]

        Deque<String> fifo = new ArrayDeque<>();
        Deque<String> lifo = new ArrayDeque<>();
        for (String item : List.of("A", "B", "C")) {
            fifo.offerLast(item);
            lifo.push(item);
        }
        while (!fifo.isEmpty()) System.out.println("Bài 2, FIFO: " + fifo.pollFirst());
        while (!lifo.isEmpty()) System.out.println("Bài 2, LIFO: " + lifo.pop());

        Deque<String> undo = new ArrayDeque<>();
        undo.push("Insert A");
        undo.push("Insert B");
        undo.push("Delete A");
        while (!undo.isEmpty()) {
            System.out.println("Bài 3, undo thao tác: " + undo.pop());
        }
        if (undo.isEmpty()) System.out.println("Không còn thao tác để undo.");
        // LIFO lấy thao tác mới nhất để hoàn tác trước; đây chỉ là mô phỏng lịch sử.
    }
}
