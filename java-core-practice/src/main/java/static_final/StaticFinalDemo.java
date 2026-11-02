package static_final;

public class StaticFinalDemo {
    private static int count;
    private final int id = ++count;

    public static void main(String[] args) {
        StaticFinalDemo first = new StaticFinalDemo();
        StaticFinalDemo second = new StaticFinalDemo();
        final int[] values = {1, 2};
        values[0] = 9; // final giữ reference; phần tử vẫn mutable.
        // Dự đoán output và giải thích field nào thuộc lớp.
        System.out.println(first.id + " " + second.id + " " + count);
        System.out.println(values[0]);
    }
}
