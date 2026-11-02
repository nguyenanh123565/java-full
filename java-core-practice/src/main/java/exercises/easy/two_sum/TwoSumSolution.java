package exercises.easy.two_sum;

import java.util.*;

public class TwoSumSolution {
    // Lời giải mẫu; input không null. Quy ước và trường hợp biên xem README.
    public static int[] twoSum(int[] values, int target) {
        Map<Long, Integer> seen = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            long complement = (long) target - values[i];
            Integer previous = seen.get(complement);
            if (previous != null) return new int[]{previous, i};
            seen.put((long) values[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        // Bài 1: đối chiếu kết quả đã dự đoán.
        // Bài 2: phương thức ở trên thực hiện thuật toán.
        // Bài 3: các ví dụ dưới có trường hợp biên; giải thích vì sao đúng.
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{Integer.MAX_VALUE, 1}, Integer.MIN_VALUE)));
        System.out.println(Arrays.toString(twoSum(new int[0], 0)));
    }
}
