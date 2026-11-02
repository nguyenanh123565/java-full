package generics;

import java.util.List;

public class GenericsSolution {
    public static final class Box<T> {
        private T value;
        public Box(T value) { this.value = value; }
        public T get() { return value; }
        public void set(T value) { this.value = value; }
    }

    public static <T> T first(T[] values) {
        if (values.length == 0) throw new IllegalArgumentException("Mảng rỗng");
        return values[0];
    }

    public static double sum(List<? extends Number> values) {
        double total = 0;
        for (Number value : values) total += value.doubleValue();
        return total;
    }

    public static void main(String[] args) {
        // Bài 1: compiler bảo đảm get() trả đúng T.
        Box<String> text = new Box<>("Java");
        text.set("Core");
        Box<Integer> number = new Box<>(7);
        System.out.println(text.get() + ": " + number.get());
        // Bài 2: kiểm tra rỗng trước khi truy cập chỉ số 0.
        System.out.println(first(new String[]{"A", "B"}));
        System.out.println(first(new Integer[]{3, 4}));
        try { first(new Integer[0]); }
        catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        // Bài 3: extends cho phép đọc Number từ cả hai danh sách.
        System.out.println(sum(List.of(1, 2, 3)));
        System.out.println(sum(List.of(1.5, 2.5)));
    }
}
