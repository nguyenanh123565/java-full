package collections.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> jobs = new ArrayDeque<>();
        jobs.offer("A");
        jobs.offer("B");
        // Đoán output: peek chỉ xem, poll lấy và xóa đầu hàng đợi.
        System.out.println(jobs.peek());
        System.out.println(jobs.poll());
        System.out.println(jobs.poll());
        System.out.println(jobs.poll()); // Rỗng: null.
    }
}
