package collections.priorityqueue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueSolution {
    public static void main(String[] args) {
        PriorityQueue<Integer> min = new PriorityQueue<>(List.of(5, 1, 3, 1));
        System.out.println("Bài 1, peek: " + min.peek());
        while (!min.isEmpty()) System.out.println("Min: " + min.poll());

        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        max.addAll(List.of(5, 1, 3, 1));
        while (!max.isEmpty()) System.out.println("Bài 2, max: " + max.poll());

        Comparator<Job> order = Comparator.comparingInt((Job job) -> job.priority)
                .thenComparingLong(job -> job.sequence);
        PriorityQueue<Job> jobs = new PriorityQueue<>(order);
        jobs.offer(new Job("A", 2, 0));
        jobs.offer(new Job("B", 1, 1));
        jobs.offer(new Job("C", 1, 2));
        while (!jobs.isEmpty()) System.out.println("Bài 3: " + jobs.poll().name); // B, C, A
        // Sequence làm rõ thứ tự giữa các job cùng priority; queue tự nó không ổn định.
    }

    private static final class Job {
        private final String name;
        private final int priority;
        private final long sequence;

        private Job(String name, int priority, long sequence) {
            this.name = name;
            this.priority = priority;
            this.sequence = sequence;
        }
    }
}
