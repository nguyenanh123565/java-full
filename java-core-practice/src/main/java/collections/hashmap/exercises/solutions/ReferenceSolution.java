package collections.hashmap.exercises.solutions;

import java.util.*;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static void validate(String text) {
        if(text==null||text.trim().isEmpty())throw new IllegalArgumentException("text");
    }
    static Map<String, Integer> counts(String[] codes) {
        Map<String, Integer> result=new HashMap<>();
        for(String code:codes) {
            validate(code);
            result.put(code, result.getOrDefault(code, 0)+1);
        }
        return result;
    }
    static boolean take(Map<String, Integer> stock, String code, int amount) {
        if(amount<=0)throw new IllegalArgumentException("amount");
        Integer available=stock.get(code);
        if(available==null||available<amount)return false;
        stock.put(code, available-amount);
        return true;
    }
    static final class Directory {
        private final Map<String, String> values=new HashMap<>();
        boolean add(String id, String name) {
            validate(id);
            validate(name);
            if(values.containsKey(id))return false;
            values.put(id, name);
            return true;
        }
        boolean rename(String id, String name) {
            validate(id);
            validate(name);
            if(!values.containsKey(id))return false;
            values.put(id, name);
            return true;
        }
        String find(String id) {
            validate(id);
            return values.get(id);
        }
    }
    static Map<String, List<String>> groupNames(String[] groups, String[] names) {
        if(groups.length!=names.length)throw new IllegalArgumentException("length");
        Map<String, List<String>> result=new HashMap<>();
        for(int i=0; i<groups.length; i++) {
            validate(groups[i]);
            validate(names[i]);
            List<String> list=result.get(groups[i]);
            if(list==null) {
                list=new ArrayList<>();
                result.put(groups[i], list);
            }
            list.add(names[i]);
        }
        return result;
    }
    static void run() {
        check(counts(new String[] {
            "P1", "P2", "P1", "P3", "P2", "P1"
        }).equals(Map.of("P1", 3, "P2", 2, "P3", 1)), "HM-01 count");
        check(counts(new String[0]).isEmpty(), "HM-01 empty");
        Map<String, Integer> nullable=new HashMap<>();
        nullable.put("A", null);
        nullable.put("B", 2);
        check(nullable.getOrDefault("A", 0)==null&&nullable.getOrDefault("C", 0)==0&&nullable.containsKey("A"), "HM-02 null mapping");
        try {
            int invalid=nullable.getOrDefault("A", 0);
            throw new AssertionError("HM-02 unbox "+invalid);
        }
        catch(NullPointerException expected) {
        }
        Map<String, Integer> stock=new HashMap<>(Map.of("P1", 3));
        check(!take(stock, "P1", 5)&&stock.get("P1")==3&&take(stock, "P1", 2)&&stock.get("P1")==1, "HM-03 failure/success");
        check(!take(stock, "missing", 1), "HM-03 missing");
        try {
            take(stock, "P1", 0);
            throw new AssertionError("HM-03 invalid");
        }
        catch(IllegalArgumentException expected) {
        }
        Directory directory=new Directory();
        check(directory.add("S1", "An")&&!directory.add("S1", "Bao")&&"An".equals(directory.find("S1")), "HM-04 add");
        check(directory.rename("S1", "Chi")&&!directory.rename("missing", "An")&&"Chi".equals(directory.find("S1")), "HM-04 rename");
        Map<String, List<String>> grouped=groupNames(new String[] {
            "A", "B", "A"
        }, new String[] {
            "An", "Bao", "Chi"
        });
        check(grouped.get("A").equals(List.of("An", "Chi"))&&grouped.get("B").equals(List.of("Bao")), "HM-05 groups");
        try {
            groupNames(new String[] {
                "A"
            }, new String[0]);
            throw new AssertionError("HM-05 length");
        }
        catch(IllegalArgumentException expected) {
        }
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS HM: 5 bài");
    }
}
