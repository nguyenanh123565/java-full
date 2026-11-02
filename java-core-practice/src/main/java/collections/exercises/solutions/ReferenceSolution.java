package collections.exercises.solutions;

import java.util.*;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static Map<String, List<Integer>> copyGroups(Map<String, List<Integer>> source) {
        Map<String, List<Integer>> result=new HashMap<>();
        for(Map.Entry<String, List<Integer>> entry:source.entrySet())result.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        return result;
    }
    static final class TicketKey {
        private final String id;
        TicketKey(String id) {
            this.id=Objects.requireNonNull(id);
        }
        public boolean equals(Object other) {
            return other instanceof TicketKey&&id.equals(((TicketKey)other).id);
        }
        public int hashCode() {
            return id.hashCode();
        }
    }
    static final class Inventory {
        private final Map<String, Integer> stock;
        private final List<String> history=new ArrayList<>();
        Inventory(Map<String, Integer> source) {
            stock=new HashMap<>(source);
            for(int n:stock.values())if(n<0)throw new IllegalArgumentException("stock");
        }
        boolean take(String code, int amount) {
            if(amount<=0)throw new IllegalArgumentException("amount");
            Integer n=stock.get(code);
            if(n==null||n<amount)return false;
            stock.put(code, n-amount);
            history.add(code+":"+amount);
            return true;
        }
        List<String> history() {
            return new ArrayList<>(history);
        }
    }
    static void validate(String text) {
        if(text==null||text.trim().isEmpty())throw new IllegalArgumentException("text");
    }
    static final class JobBoard {
        private final Queue<String> order=new ArrayDeque<>();
        private final Set<String> pending=new HashSet<>();
        private final List<String> history=new ArrayList<>();
        boolean submit(String id) {
            validate(id);
            if(!pending.add(id))return false;
            order.offer(id);
            return true;
        }
        String process() {
            String id=order.poll();
            if(id!=null) {
                pending.remove(id);
                history.add(id);
            }
            return id;
        }
        List<String> history() {
            return new ArrayList<>(history);
        }
    }
    static List<String> report(List<Integer> levels) {
        Map<Integer, Integer> counts=new HashMap<>();
        for(int level:levels) {
            if(level<0||level>9)throw new IllegalArgumentException("level");
            counts.put(level, counts.getOrDefault(level, 0)+1);
        }
        List<String> result=new ArrayList<>();
        for(int level=0; level<=9; level++)if(counts.containsKey(level))result.add(level+":"+counts.get(level));
        return result;
    }
    static final class Request {
        final String id, person, code;
        final int amount;
        Request(String id, String person, String code, int amount) {
            validate(id);
            validate(person);
            validate(code);
            if(amount<=0)throw new IllegalArgumentException("amount");
            this.id=id;
            this.person=person;
            this.code=code;
            this.amount=amount;
        }
    }
    static final class Counter {
        private final Map<String, Integer> stock=new HashMap<>();
        private final Queue<Request> queue=new ArrayDeque<>();
        private final Set<String> pending=new HashSet<>();
        private final List<String> results=new ArrayList<>();
        boolean register(String code, int count) {
            validate(code);
            if(count<0)throw new IllegalArgumentException("count");
            if(stock.containsKey(code))return false;
            stock.put(code, count);
            return true;
        }
        boolean submit(Request request) {
            Objects.requireNonNull(request);
            if(!pending.add(request.id))return false;
            queue.offer(request);
            return true;
        }
        String process() {
            Request r=queue.poll();
            if(r==null)return null;
            pending.remove(r.id);
            Integer count=stock.get(r.code);
            boolean ok=count!=null&&count>=r.amount;
            if(ok)stock.put(r.code, count-r.amount);
            String result=r.id+(ok?":OK":":REJECTED");
            results.add(result);
            return result;
        }
        List<String> results() {
            return new ArrayList<>(results);
        }
        Map<String, Integer> stock() {
            return new HashMap<>(stock);
        }
    }
    static void run() {
        List<Integer> values=List.of(3, 1, 3, 2);
        Set<Integer> unique=new HashSet<>(values);
        Queue<Integer> fifo=new ArrayDeque<>(values);
        Deque<Integer> stack=new ArrayDeque<>();
        for(int n:values)stack.push(n);
        PriorityQueue<Integer> heap=new PriorityQueue<>(values);
        Map<String, Integer> prices=new HashMap<>();
        prices.put("A", 2);
        check(values.size()==4&&unique.equals(Set.of(1, 2, 3))&&fifo.poll()==3&&stack.pop()==2&&heap.poll()==1&&prices.get("A")==2, "COL-01 choices");
        List<Integer> sorted=new ArrayList<>();
        sorted.add(1);
        while(!heap.isEmpty())sorted.add(heap.poll());
        check(sorted.equals(List.of(1, 2, 3, 3))&&unique.size()==3, "COL-02 semantics");
        Map<String, List<Integer>> original=new HashMap<>();
        original.put("A", new ArrayList<>(List.of(1)));
        Map<String, List<Integer>> shallow=new HashMap<>(original);
        shallow.get("A").add(2);
        shallow.put("B", new ArrayList<>());
        check(original.get("A").equals(List.of(1, 2))&&!original.containsKey("B"), "COL-03 shallow");
        Map<String, List<Integer>> deep=copyGroups(original);
        deep.get("A").clear();
        check(original.get("A").size()==2, "COL-03 structural copy");
        Map<TicketKey, String> tickets=new HashMap<>();
        tickets.put(new TicketKey("A"), "old");
        tickets.put(new TicketKey("A"), "new");
        check(tickets.size()==1&&"new".equals(tickets.get(new TicketKey("A"))), "COL-04 immutable key");
        Inventory inventory=new Inventory(Map.of("A", 3));
        check(inventory.take("A", 2)&&!inventory.take("A", 2)&&inventory.history().equals(List.of("A:2")), "COL-05 history");
        JobBoard jobs=new JobBoard();
        check(jobs.submit("A")&&jobs.submit("B")&&!jobs.submit("A"), "COL-06 pending");
        jobs.process();
        jobs.submit("A");
        jobs.process();
        jobs.process();
        check(jobs.history().equals(List.of("A", "B", "A")), "COL-06 history");
        check(report(values).equals(List.of("1:1", "2:1", "3:2"))&&report(List.of()).isEmpty(), "COL-07 report");
        LinkedList<Integer> linked=new LinkedList<>();
        for(int i=0; i<100; i++)linked.add(i);
        int indexed=0, sequential=0;
        for(int i=0; i<linked.size(); i++)indexed+=linked.get(i);
        for(int n:linked)sequential+=n;
        check(indexed==4950&&sequential==4950, "COL-08 sums");
        Counter counter=new Counter();
        check(counter.register("CAM", 2)&&!counter.register("CAM", 5), "COL-09 register");
        check(counter.submit(new Request("R1", "An", "CAM", 1))&&counter.submit(new Request("R2", "Bao", "CAM", 2))&&!counter.submit(new Request("R1", "An", "CAM", 1)), "COL-09 duplicate");
        check("R1:OK".equals(counter.process())&&"R2:REJECTED".equals(counter.process())&&counter.process()==null&&counter.stock().get("CAM")==1, "COL-09 state");
        counter.stock().clear();
        counter.results().clear();
        check(counter.stock().size()==1&&counter.results().equals(List.of("R1:OK", "R2:REJECTED")), "COL-09 snapshots");
        check(counter.submit(new Request("R1", "An", "CAM", 1)), "COL-09 resubmit");
        try {
            new Request("X", "An", "CAM", 0);
            throw new AssertionError("COL-09 invalid");
        }
        catch(IllegalArgumentException expected) {
        }
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS COL: 9 bài");
    }
}
