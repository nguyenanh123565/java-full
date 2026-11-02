package exercises.easy.find_min;

import java.util.*;

public class FindMinSolution {
    // Lời giải mẫu; input không null. Quy ước và trường hợp biên xem README.
    public static int findMin(int[] values) {
        if (values.length == 0) throw new IllegalArgumentException("Mảng rỗng");
        int best = values[0];
        for (int i = 1; i < values.length; i++) if (values[i] < best) best = values[i];
        return best;
    }

    public static void main(String[] args) {
        // Bài 1: đối chiếu kết quả đã dự đoán.
        // Bài 2: phương thức ở trên thực hiện thuật toán.
        // Bài 3: các ví dụ dưới có trường hợp biên; giải thích vì sao đúng.
        System.out.println(findMin(new int[]{7, 2, 9}));
        System.out.println(findMin(new int[]{5}));
        System.out.println(findMin(new int[]{3, 3}));
        System.out.println(findMin(new int[]{Integer.MAX_VALUE, 1}));
        try { findMin(new int[0]); }
        catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
    }
}
