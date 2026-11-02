package collections.priorityqueue.exercises.solutions;

import java.util.*;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static List<Integer> smallest(List<Integer> values, int k) {
        if(k<0)throw new IllegalArgumentException("k");
        PriorityQueue<Integer> queue=new PriorityQueue<>(values);
        List<Integer> result=new ArrayList<>();
        while(result.size()<k&&!queue.isEmpty())result.add(queue.poll());
        return result;
    }
    static List<Integer> preview(PriorityQueue<Integer> source) {
        PriorityQueue<Integer> copy=new PriorityQueue<>(source);
        List<Integer> result=new ArrayList<>();
        while(!copy.isEmpty())result.add(copy.poll());
        return result;
    }
    static long mergeCost(int[] lengths) {
        long total=0;
        for(int length:lengths) {
            if(length<0)throw new IllegalArgumentException("length");
            total+=length;
            if(total>Integer.MAX_VALUE)throw new IllegalArgumentException("total");
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int length:lengths)queue.offer(length);
        long cost=0;
        while(queue.size()>1) {
            int merged=queue.poll()+queue.poll();
            cost+=merged;
            queue.offer(merged);
        }
        return cost;
    }
    static final class Deadlines {
        private final PriorityQueue<Integer> queue=new PriorityQueue<>();
        void add(int minute) {
            if(minute<0)throw new IllegalArgumentException("minute");
            queue.offer(minute);
        }
        List<Integer> takeDue(int now) {
            if(now<0)throw new IllegalArgumentException("now");
            List<Integer> result=new ArrayList<>();
            while(!queue.isEmpty()&&queue.peek()<=now)result.add(queue.poll());
            return result;
        }
    }
    static void run() {
        List<Integer> source=List.of(7, 2, 5, 2);
        check(smallest(source, 3).equals(List.of(2, 2, 5))&&source.size()==4, "PQ-01 smallest");
        check(smallest(List.of(), 2).isEmpty()&&smallest(source, 0).isEmpty(), "PQ-01 boundary");
        PriorityQueue<Integer> trace=new PriorityQueue<>(List.of(6, 3, 8));
        check(trace.poll()==3, "PQ-02 first");
        trace.offer(1);
        check(trace.peek()==1&&trace.poll()==1&&trace.size()==2, "PQ-02 new head");
        PriorityQueue<Integer> queue=new PriorityQueue<>(List.of(4, 1, 3));
        check(preview(queue).equals(List.of(1, 3, 4))&&preview(queue).equals(List.of(1, 3, 4))&&queue.size()==3, "PQ-03 preview");
        check(mergeCost(new int[] {
            1, 2, 3, 4
        })==19&&mergeCost(new int[0])==0&&mergeCost(new int[] {
            5
        })==0, "PQ-04 merge");
        try {
            mergeCost(new int[] {
                Integer.MAX_VALUE, 1
            });
            throw new AssertionError("PQ-04 overflow");
        }
        catch(IllegalArgumentException expected) {
        }
        Deadlines deadlines=new Deadlines();
        for(int value:new int[] {
            9, 3, 3, 12
        })deadlines.add(value);
        check(deadlines.takeDue(8).equals(List.of(3, 3))&&deadlines.takeDue(20).equals(List.of(9, 12))&&deadlines.takeDue(20).isEmpty(), "PQ-05 due");
        deadlines.add(5);
        check(deadlines.takeDue(5).equals(List.of(5)), "PQ-05 exact boundary");
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS PQ: 5 bài");
    }
}
