package static_final;

import java.util.Arrays;

public class StaticFinalSolution {
    public static final double PI = Math.PI;
    public static final class Counter {
        private static int total;
        private final int id = ++total;
        public int getId() { return id; }
        public static int getTotal() { return total; }
    }

    public static double area(double radius) {
        if (!Double.isFinite(radius) || radius < 0)
            throw new IllegalArgumentException("Bán kính phải hữu hạn và không âm");
        return PI * radius * radius;
    }

    public static final class Scores {
        private final int[] values;
        public Scores(int[] values) { this.values = values.clone(); }
        public int[] getValues() { return values.clone(); }
    }

    public static void main(String[] args) {
        // Bài 1: id riêng, total dùng chung.
        Counter first = new Counter();
        Counter second = new Counter();
        System.out.println(first.getId() + " " + second.getId() + " " + Counter.getTotal());
        // Bài 2: hàm không phụ thuộc trạng thái instance.
        System.out.println(area(0));
        System.out.println(area(2));
        // Bài 3: final một mình không bảo vệ nội dung.
        final int[] original = {1, 2};
        Scores scores = new Scores(original);
        original[0] = 9;
        int[] copy = scores.getValues();
        copy[1] = 8;
        System.out.println(Arrays.toString(original));
        System.out.println(Arrays.toString(scores.getValues()));
    }
}
