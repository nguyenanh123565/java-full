package generics;

import java.util.List;

public class GenericsDemo {
    private static class Box<T> {
        private final T value;
        Box(T value) { this.value = value; }
        T get() { return value; }
    }

    public static void main(String[] args) {
        // Dự đoán output; T được xác định khi tạo Box.
        Box<String> box = new Box<>("Java");
        System.out.println(box.get().length());
        List<? extends Number> numbers = List.of(2, 3);
        Number first = numbers.get(0); // Đọc được kiểu Number.
        System.out.println(first.doubleValue());
        // numbers.add(4); không biên dịch: kiểu cụ thể của danh sách chưa biết.
    }
}
