package fundamental.methods;

import java.util.Arrays;

public class MethodSolution {
    public static void main(String[] args) {
        System.out.println("Bài 1: tham số và giá trị trả về");
        System.out.println(max(-3, -5)); // -3
        System.out.println(max(4, 4));   // 4

        System.out.println("Bài 2: primitive được truyền bằng giá trị");
        int value = 5;
        increment(value);
        System.out.println(value); // 5: tham số là một biến riêng.
        value = incrementAndReturn(value);
        System.out.println(value); // 6: caller chủ động nhận giá trị trả về.

        System.out.println("Bài 3: tham chiếu cũng được truyền bằng giá trị");
        int[] data = {1, 2};
        replaceArray(data);
        System.out.println(Arrays.toString(data)); // [1, 2]
        changeFirst(data);
        System.out.println(Arrays.toString(data)); // [99, 2]
    }

    private static int max(int a, int b) {
        return a >= b ? a : b;
    }

    private static void increment(int value) {
        value++; // Chỉ tăng bản sao trong tham số.
    }

    private static int incrementAndReturn(int value) {
        return value + 1;
    }

    private static void replaceArray(int[] values) {
        values = new int[]{7, 8};
        // Tham số chuyển sang mảng mới; data trong main không đổi.
    }

    private static void changeFirst(int[] values) {
        values[0] = 99;
        // Bản sao tham chiếu vẫn dẫn đến cùng mảng nên caller thấy thay đổi.
    }
}
