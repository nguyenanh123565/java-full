package exercises.easy.remove_duplicate;

import java.util.*;

public class RemoveDuplicateSolution {
    // Lời giải mẫu; input không null. Quy ước và trường hợp biên xem README.
    public static int[] unique(int[] values) {
        Set<Integer> seen = new LinkedHashSet<>();
        for (int value : values) seen.add(value);
        int[] result = new int[seen.size()];
        int index = 0;
        for (int value : seen) result[index++] = value;
        return result;
    }

    public static void main(String[] args) {
        // Bài 1: đối chiếu kết quả đã dự đoán.
        // Bài 2: phương thức ở trên thực hiện thuật toán.
        // Bài 3: các ví dụ dưới có trường hợp biên; giải thích vì sao đúng.
        int[] source = {3, 1, 3, 2, 1};
        int[] result = unique(source);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(source));
        System.out.println(source == result);
        System.out.println(Arrays.toString(unique(new int[0])));
        System.out.println(Arrays.toString(unique(new int[]{7, 7})));
    }
}
