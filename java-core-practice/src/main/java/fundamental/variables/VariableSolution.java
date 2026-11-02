package fundamental.variables;

public class VariableSolution {
    public static void main(String[] args) {
        System.out.println("Bài 1: diện tích");
        int length = 7;
        int width = 5;
        System.out.println(length * width);

        System.out.println("Bài 2: kiểu của phép chia");
        int total = 7;
        int people = 2;
        System.out.println(total / people);                 // 3
        System.out.println((double) total / people);        // 3.5
        System.out.println((double) (total / people));      // 3.0
        // Ép kiểu một toán hạng trước phép chia làm phép chia dùng double.

        System.out.println("Bài 3: tràn số");
        int overflowing = 50_000 * 50_000;
        long tooLate = 50_000 * 50_000; // Tích đã tràn trước khi đổi sang long.
        long correct = 50_000L * 50_000; // Có toán hạng long trước phép nhân.
        System.out.println(overflowing); // -1794967296
        System.out.println(tooLate);     // -1794967296
        System.out.println(correct);     // 2500000000
        byte small = 127;
        small++;
        System.out.println(small);        // -128
    }
}
