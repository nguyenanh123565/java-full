package fundamental.arrays;

import java.util.Arrays;

public class ArraySolution {
    public static void main(String[] args) {
        System.out.println("Bài 1: tổng phần tử");
        System.out.println(sum(new int[]{-2, 3, 5})); // 6
        System.out.println(sum(new int[0]));         // 0

        System.out.println("Bài 2: alias và bản sao");
        int[] original = {1, 2, 3};
        int[] alias = original;
        int[] copy = Arrays.copyOf(original, original.length);
        alias[0] = 99;
        System.out.println(Arrays.toString(original)); // [99, 2, 3]
        System.out.println(Arrays.toString(alias));    // [99, 2, 3]
        System.out.println(Arrays.toString(copy));     // [1, 2, 3]
        System.out.println(original == alias);        // true
        System.out.println(original == copy);         // false

        System.out.println("Bài 3: tham chiếu hàng trong mảng hai chiều");
        int[] row = {1, 2};
        int[][] shared = {row, row};
        shared[0][0] = 9;
        System.out.println(Arrays.deepToString(shared)); // [[9, 2], [9, 2]]

        int[] seed = {1, 2};
        int[][] independent = {
            Arrays.copyOf(seed, seed.length),
            Arrays.copyOf(seed, seed.length)
        };
        independent[0][0] = 9;
        System.out.println(Arrays.deepToString(independent)); // [[9, 2], [1, 2]]
        // Mảng ngoài giữ tham chiếu từng hàng; shared dùng cùng một hàng hai lần.
    }

    private static long sum(int[] numbers) {
        long total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return total;
    }
}
