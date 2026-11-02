package exercises.easy.reverse_array;

import java.util.Arrays;

public class ReverseArrayDemo {
    public static void main(String[] args) {
        int[] a = {2, 1, 2};
        int[] b = a;
        int[] copy = a.clone();
        b[0] = 9; // alias cùng trỏ một mảng; clone tạo mảng khác.
        // Dự đoán output trước khi chạy. Bài ReverseArray yêu cầu chú ý dữ liệu đầu vào.
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(copy));
    }
}
