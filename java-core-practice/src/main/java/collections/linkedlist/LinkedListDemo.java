package collections.linkedlist;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> tasks = new LinkedList<>();
        tasks.addLast("B");
        tasks.addFirst("A");
        // Đoán output: thao tác nào chỉ đọc, thao tác nào xóa phần tử?
        System.out.println(tasks.peekFirst());
        System.out.println(tasks.pollFirst());
        System.out.println(tasks);
        // LinkedList triển khai cả List và Deque; truy cập index phải duyệt node.
    }
}
