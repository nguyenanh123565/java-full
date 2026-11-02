package collections.hashset.exercises.solutions;

import java.util.*;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static Set<String> intersection(Set<String> a,  Set<String> b) {
        Set<String> result=new HashSet<>();
        for(String value:a) if(b.contains(value)) result.add(value);
        return result;
    }
    static Set<String> absent(Set<String> registered,  Set<String> present) {
        Set<String> result=new HashSet<>(registered);
        result.removeAll(present);
        return result;
    }
    static final class Key {
        private final String id;
        Key(String id) {
            this.id=Objects.requireNonNull(id);
        }
        public boolean equals(Object other) {
            return other instanceof Key && id.equals(((Key)other).id);
        }
        public int hashCode() {
            return 1;
        }
    }
    static void validate(String name) {
        if(name==null||name.trim().isEmpty())throw new IllegalArgumentException("name");
    }
    static final class Attendance {
        private final Set<String> registered=new HashSet<>(),  seen=new HashSet<>();
        private final List<String> order=new ArrayList<>();
        Attendance(Set<String> source) {
            for(String name:source) {
                validate(name);
                registered.add(name);
            }
        }
        boolean checkIn(String name) {
            validate(name);
            if(!registered.contains(name)||!seen.add(name))return false;
            order.add(name);
            return true;
        }
        List<String> firstArrivalOrder() {
            return new ArrayList<>(order);
        }
    }
    static void run() {
        Set<String> a=new HashSet<>(List.of("An", "Bao", "Chi"));
        Set<String> b=Set.of("Bao", "Dung");
        check(intersection(a, b).equals(Set.of("Bao"))&&a.size()==3, "HS-01 intersection/source");
        check(intersection(Set.of(), b).isEmpty(), "HS-01 empty");
        Set<Key> keys=new HashSet<>();
        check(keys.add(new Key("A"))&&keys.add(new Key("B"))&&!keys.add(new Key("A"))&&keys.size()==2, "HS-02 collision");
        Set<String> joined=new HashSet<>();
        int accepted=0;
        for(String name:List.of("An", "An", "Bao")) {
            validate(name);
            if(joined.add(name))accepted++;
        }
        check(accepted==2, "HS-03 count");
        check(absent(a, Set.of("An", "Khach")).equals(Set.of("Bao", "Chi")), "HS-04 absent/guest");
        Attendance attendance=new Attendance(Set.of("An", "Bao"));
        check(attendance.checkIn("Bao")&&attendance.checkIn("An")&&!attendance.checkIn("Bao")&&!attendance.checkIn("Khach"), "HS-05 policy");
        check(attendance.firstArrivalOrder().equals(List.of("Bao", "An")), "HS-05 order");
        attendance.firstArrivalOrder().clear();
        check(attendance.firstArrivalOrder().size()==2, "HS-05 snapshot");
        try {
            attendance.checkIn(" ");
            throw new AssertionError("HS-05 invalid");
        }
        catch(IllegalArgumentException expected) {
        }
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS HS: 5 bài");
    }
}
