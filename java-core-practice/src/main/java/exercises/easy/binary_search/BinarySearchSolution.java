package exercises.easy.binary_search;

import java.util.*;

public class BinarySearchSolution {
    // Lời giải mẫu; input không null. Quy ước và trường hợp biên xem README.
    public static int search(int[] sorted, int target) {
        int left = 0, right = sorted.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted[mid] == target) return mid;
            if (sorted[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Bài 1: đối chiếu kết quả đã dự đoán.
        // Bài 2: phương thức ở trên thực hiện thuật toán.
        // Bài 3: các ví dụ dưới có trường hợp biên; giải thích vì sao đúng.
        System.out.println(search(new int[]{1, 3, 5, 7, 9}, 7));
        System.out.println(search(new int[0], 7));
        System.out.println(search(new int[]{4}, 4));
        System.out.println(search(new int[]{1, 3, 5}, 2));
        System.out.println(search(new int[]{1, 2, 2, 3}, 2));
    }
}
