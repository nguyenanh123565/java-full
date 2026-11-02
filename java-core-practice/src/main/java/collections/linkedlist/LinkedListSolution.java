package collections.linkedlist;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListSolution {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("B");
        list.addFirst("A");
        list.addLast("C");
        System.out.println("Bài 1, peek: " + list.peekFirst()); // Không xóa.
        System.out.println("Bài 1, poll: " + list.pollFirst()); // Xóa A.
        System.out.println("Còn lại: " + list);

        LinkedList<String> jobs = new LinkedList<>();
        jobs.addLast("An");
        jobs.addLast("Bình");
        jobs.addLast("Chi");
        while (!jobs.isEmpty()) {
            System.out.println("Bài 2, xử lý: " + jobs.removeFirst());
        } // FIFO: công việc đến trước được xử lý trước.

        LinkedList<String> empty = new LinkedList<>();
        System.out.println("Bài 3, peekFirst: " + empty.peekFirst());
        System.out.println("Bài 3, pollFirst: " + empty.pollFirst());
        try {
            empty.getFirst();
        } catch (NoSuchElementException e) {
            System.out.println("getFirst: NoSuchElementException");
        }
        try {
            empty.removeFirst();
        } catch (NoSuchElementException e) {
            System.out.println("removeFirst: NoSuchElementException");
        }
        // get(i) cần đi qua các liên kết từ đầu/cuối tới vị trí đó.
    }
}
