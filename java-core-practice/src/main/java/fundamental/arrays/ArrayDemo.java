package fundamental.arrays;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        // Đoán nội dung ba biến và kết quả == trước khi chạy.
        int[] original = {1, 2, 3};
        int[] alias = original; // Sao chép tham chiếu, không sao chép phần tử.
        int[] copy = Arrays.copyOf(original, original.length);
        alias[0] = 99;
        System.out.println(Arrays.toString(original));
        System.out.println(Arrays.toString(alias));
        System.out.println(Arrays.toString(copy));
        System.out.println(original == alias);
        System.out.println(original == copy);

        int[] defaults = new int[2]; // Phần tử int có giá trị mặc định.
        System.out.println(Arrays.toString(defaults));
    }
}
