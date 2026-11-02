package exercises.easy.reverse_array;

import java.util.*;

public class ReverseArraySolution {
    // Lời giải mẫu; input không null. Quy ước và trường hợp biên xem README.
    public static void reverse(int[] values) {
        int left = 0, right = values.length - 1;
        while (left < right) {
            int temp = values[left];
            values[left++] = values[right];
            values[right--] = temp;
        }
    }

    public static void main(String[] args) {
        // Bài 1: đối chiếu kết quả đã dự đoán.
        // Bài 2: phương thức ở trên thực hiện thuật toán.
        // Bài 3: các ví dụ dưới có trường hợp biên; giải thích vì sao đúng.
        int[] a = {1, 2, 3, 4};
        int[] b = a;
        int[] c = a.clone();
        reverse(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        reverse(a);
        System.out.println(Arrays.toString(a));
        reverse(new int[0]);
    }
}
