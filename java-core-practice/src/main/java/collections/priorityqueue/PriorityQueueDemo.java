package collections.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.offer(5);
        numbers.offer(1);
        numbers.offer(3);
        // Đoán output: mặc định ưu tiên phần tử nhỏ nhất, không phải phần tử vào trước.
        System.out.println(numbers.peek());
        while (!numbers.isEmpty()) System.out.println(numbers.poll());
        // for-each hoặc toString không bảo đảm thứ tự tăng dần.
    }
}
