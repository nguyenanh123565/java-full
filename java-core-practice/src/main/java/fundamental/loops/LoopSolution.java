package fundamental.loops;

public class LoopSolution {
    public static void main(String[] args) {
        System.out.println("Bài 1: tổng 1..n");
        System.out.println(sumTo(5)); // 15
        System.out.println(sumTo(0)); // 0

        System.out.println("Bài 2: tổng số lẻ");
        int oddSum = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            oddSum += i;
        }
        System.out.println(oddSum); // 25
        // Nếu dùng break, vòng lặp dừng tại 2: tổng chỉ còn 1.

        System.out.println("Bài 3: tam giác sao");
        int n = 4;
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.print('*');
            }
            System.out.println();
        }
        // Số ký tự là 1 + 2 + ... + n = n(n+1)/2, nên O(n^2).
    }

    private static long sumTo(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
