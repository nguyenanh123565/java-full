package collections.linkedlist.exercises.solutions;

import java.util.*;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static void rotateOnce(LinkedList<String> values) {
        if (!values.isEmpty()) values.addLast(values.removeFirst());
    }
    static final class RecentMessages {
        private final int capacity;
        private final LinkedList<String> values = new LinkedList<>();
        RecentMessages(int capacity) {
            if (capacity <= 0) throw new IllegalArgumentException("capacity");
            this.capacity=capacity;
        }
        void add(String value) {
            if(value==null)throw new IllegalArgumentException("message");
            values.addLast(value);
            if (values.size()>capacity) values.removeFirst();
        }
        LinkedList<String> snapshot() {
            return new LinkedList<>(values);
        }
    }
    static final class DutyRoster {
        private final LinkedList<String> people = new LinkedList<>();
        DutyRoster(List<String> source) {
            for (String name : source) {
                if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("name");
                people.add(name);
            }
        }
        String next() {
            if (people.isEmpty()) return null;
            String name=people.removeFirst();
            people.addLast(name);
            return name;
        }
        List<String> snapshot() {
            return new ArrayList<>(people);
        }
    }
    static void run() {
        LinkedList<String> list=new LinkedList<>(List.of("A", "B", "C"));
        rotateOnce(list);
        check(list.equals(List.of("B", "C", "A")),  "LL-01 rotate");
        rotateOnce(new LinkedList<>());
        LinkedList<String> nullable=new LinkedList<>();
        nullable.add(null);
        nullable.add("A");
        check(nullable.pollFirst()==null && nullable.size()==1 && "A".equals(nullable.pollFirst()),  "LL-02 null element");
        LinkedList<String> people=new LinkedList<>(List.of("An", "Bao", "Chi"));
        List<String> turn=new ArrayList<>();
        int count=people.size();
        for(int i=0; i<count; i++) {
            String p=people.removeFirst();
            turn.add(p);
            people.addLast(p);
        }
        check(turn.equals(people) && turn.size()==3,  "LL-03 finite round");
        RecentMessages messages=new RecentMessages(3);
        for(String s:List.of("A", "B", "C", "D")) messages.add(s);
        check(messages.snapshot().equals(List.of("B", "C", "D")),  "LL-04 capacity");
        messages.snapshot().clear();
        check(messages.snapshot().size()==3,  "LL-04 snapshot");
        try {
            messages.add(null);
            throw new AssertionError("LL-04 null");
        }
        catch(IllegalArgumentException expected) {
        }
        check(messages.snapshot().equals(List.of("B", "C", "D")), "LL-04 invalid does not mutate");
        try {
            new RecentMessages(0);
            throw new AssertionError("LL-04 invalid");
        }
        catch(IllegalArgumentException expected) {
        }
        DutyRoster roster=new DutyRoster(List.of("An", "Bao", "Chi"));
        List<String> turns=new ArrayList<>();
        for(int i=0; i<5; i++) turns.add(roster.next());
        check(turns.equals(List.of("An", "Bao", "Chi", "An", "Bao")),  "LL-05 turns");
        check(roster.snapshot().equals(List.of("Chi", "An", "Bao")),  "LL-05 state");
        check(new DutyRoster(List.of()).next()==null,  "LL-05 empty");
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS LL: 5 bài");
    }
}
