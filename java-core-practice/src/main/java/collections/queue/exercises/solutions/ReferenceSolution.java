package collections.queue.exercises.solutions;

import java.util.*;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static List<String> drain(Queue<String> queue, int max) {
        if(max<0)throw new IllegalArgumentException("max");
        List<String> result=new ArrayList<>();
        while(result.size()<max&&!queue.isEmpty())result.add(queue.poll());
        return result;
    }
    static final class Job {
        final String id;
        int attempts;
        Job(String id) {
            this.id=id;
        }
    }
    static List<String> retry(String... ids) {
        Queue<Job> jobs=new ArrayDeque<>();
        for(String id:ids)jobs.offer(new Job(id));
        List<String> result=new ArrayList<>();
        while(!jobs.isEmpty()) {
            Job job=jobs.poll();
            job.attempts++;
            if(!job.id.equals("BAD"))result.add(job.id+":SUCCESS");
            else if(job.attempts<2)jobs.offer(job);
            else result.add(job.id+":FAILED");
        }
        return result;
    }
    static void validate(String id) {
        if(id==null||id.trim().isEmpty())throw new IllegalArgumentException("id");
    }
    static final class ServiceDesk {
        private final Queue<String> queue=new ArrayDeque<>();
        void join(String name) {
            validate(name);
            queue.offer(name);
        }
        String serveNext() {
            return queue.poll();
        }
        int sizePending() {
            return queue.size();
        }
    }
    static final class Scheduler {
        private final Queue<String> queue=new ArrayDeque<>();
        private final Set<String> ids=new HashSet<>();
        boolean submit(String id) {
            validate(id);
            if(!ids.add(id))return false;
            queue.offer(id);
            return true;
        }
        String next() {
            String id=queue.poll();
            if(id!=null)ids.remove(id);
            return id;
        }
    }
    static void run() {
        Queue<String> queue=new ArrayDeque<>(List.of("A", "B", "C"));
        check(drain(queue, 2).equals(List.of("A", "B"))&&queue.size()==1, "QU-01 batch");
        check(drain(queue, 0).isEmpty()&&drain(queue, 9).equals(List.of("C")), "QU-01 limits");
        Queue<String> trace=new ArrayDeque<>(List.of("A", "B"));
        check("A".equals(trace.peek())&&"A".equals(trace.peek())&&"A".equals(trace.poll())&&"B".equals(trace.peek())&&trace.size()==1, "QU-02 trace");
        check(retry("BAD", "OK").equals(List.of("OK:SUCCESS", "BAD:FAILED"))&&retry().isEmpty(), "QU-03 retry");
        ServiceDesk desk=new ServiceDesk();
        check(desk.serveNext()==null, "QU-04 empty");
        desk.join("An");
        desk.join("Bao");
        check("An".equals(desk.serveNext()), "QU-04 first");
        desk.join("Chi");
        check("Bao".equals(desk.serveNext())&&"Chi".equals(desk.serveNext())&&desk.sizePending()==0, "QU-04 FIFO");
        Scheduler scheduler=new Scheduler();
        check(scheduler.submit("A")&&scheduler.submit("B")&&!scheduler.submit("A"), "QU-05 duplicate");
        check("A".equals(scheduler.next())&&scheduler.submit("A")&&"B".equals(scheduler.next())&&"A".equals(scheduler.next())&&scheduler.next()==null, "QU-05 resubmit");
        try {
            scheduler.submit(" ");
            throw new AssertionError("QU-05 invalid");
        }
        catch(IllegalArgumentException expected) {
        }
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS QU: 5 bài");
    }
}
