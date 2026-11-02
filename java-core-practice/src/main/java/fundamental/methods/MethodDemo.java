package fundamental.methods;

import java.util.Arrays;

public class MethodDemo {
    public static void main(String[] args) {
        // Đoán: biến nào của caller đổi sau mỗi lời gọi? Vì sao?
        int number = 5;
        changeNumber(number);
        System.out.println(number);

        int[] values = {1, 2};
        changeFirst(values);
        System.out.println(Arrays.toString(values));
        replaceArray(values);
        System.out.println(Arrays.toString(values));
    }

    private static void changeNumber(int number) {
        number = 99; // Đổi bản sao primitive trong tham số.
    }

    private static void changeFirst(int[] values) {
        values[0] = 99; // Tham số giữ bản sao tham chiếu tới cùng mảng.
    }

    private static void replaceArray(int[] values) {
        values = new int[]{7, 8}; // Chỉ gán lại tham số, không gán lại biến caller.
    }
}
