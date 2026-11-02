package collections.arraylist.exercises.solutions;

import java.util.*;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static List<Integer> validScores(List<Integer> values) {
        List<Integer> result = new ArrayList<>();
        for (int value : values) if (value >= 0 && value <= 10) result.add(value);
        return result;
    }
    static List<String> page(List<String> values,  int offset,  int limit) {
        if (offset < 0 || limit < 0) throw new IllegalArgumentException("negative page");
        List<String> result = new ArrayList<>();
        if (offset >= values.size()) return result;
        int count = Math.min(limit,  values.size() - offset);
        for (int i = 0;  i < count;  i++) result.add(values.get(offset + i));
        return result;
    }
    static final class Item {
        int value;
        Item(int value) {
            this.value = value;
        }
    }
    static final class GradeBook {
        private final List<Integer> scores = new ArrayList<>();
        void addScore(int value) {
            if (value < 0 || value > 10) throw new IllegalArgumentException("score");
            scores.add(value);
        }
        List<Integer> snapshot() {
            return new ArrayList<>(scores);
        }
    }
    static void run() {
        List<Integer> source = List.of(8, -1, 10, 8, 11, 0);
        check(validScores(source).equals(List.of(8, 10, 8, 0)),  "AL-01 ordinary");
        check(source.size() == 6 && validScores(List.of()).isEmpty(),  "AL-01 boundary/source");
        Item item = new Item(1);
        List<Item> a = new ArrayList<>();
        a.add(item);
        List<Item> b = new ArrayList<>(a);
        b.get(0).value = 7;
        b.add(new Item(9));
        check(a.get(0).value == 7 && b.get(0).value == 7 && a.size() == 1,  "AL-02 shallow copy");
        List<Integer> values = new ArrayList<>(List.of(-1, -2, 3, -4));
        for (int i = values.size()-1;  i >= 0;  i--) if (values.get(i) < 0) values.remove(i);
        check(values.equals(List.of(3)),  "AL-03 adjacent negatives");
        check(page(List.of("A", "B", "C", "D"), 1, 2).equals(List.of("B", "C")),  "AL-04 page");
        check(page(List.of("A"), 0, Integer.MAX_VALUE).equals(List.of("A")),  "AL-04 overflow");
        check(page(List.of(), 0, 0).isEmpty(),  "AL-04 empty");
        try {
            page(List.of(), -1, 2);
            throw new AssertionError("AL-04 negative");
        }
        catch (IllegalArgumentException expected) {
        }
        GradeBook book = new GradeBook();
        book.addScore(8);
        book.addScore(10);
        List<Integer> snap = book.snapshot();
        book.addScore(7);
        snap.clear();
        check(book.snapshot().equals(List.of(8, 10, 7)),  "AL-05 defensive copy");
        try {
            book.addScore(11);
            throw new AssertionError("AL-05 validation");
        }
        catch (IllegalArgumentException expected) {
        }
        check(book.snapshot().size() == 3,  "AL-05 failed operation");
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS AL: 5 bài");
    }
}
