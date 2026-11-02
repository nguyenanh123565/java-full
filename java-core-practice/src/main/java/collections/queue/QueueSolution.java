package collections.queue;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueSolution {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("A");
        queue.offer("B");
        System.out.println("Bài 1, peek: " + queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println("Bài 2, peek rỗng: " + queue.peek());
        System.out.println("Poll rỗng: " + queue.poll());
        try {
            queue.remove();
        } catch (NoSuchElementException e) {
            System.out.println("remove: NoSuchElementException");
        }
        try {
            queue.element();
        } catch (NoSuchElementException e) {
            System.out.println("element: NoSuchElementException");
        }
        // ArrayDeque cấm null; null từ peek/poll biểu thị queue rỗng rõ ràng.

        Queue<String> jobs = new ArrayDeque<>();
        jobs.offer("A");
        jobs.offer("B");
        jobs.offer("C");
        while (!jobs.isEmpty()) {
            String job = jobs.poll();
            System.out.println("Bài 3, xử lý: " + job);
            if ("A".equals(job)) jobs.offer("D");
        } // A, B, C, D. Thao tác trực tiếp queue thay vì dùng iterator đang bị thay đổi.
    }
}
