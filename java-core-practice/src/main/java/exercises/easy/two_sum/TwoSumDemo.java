package exercises.easy.two_sum;

public class TwoSumDemo {
    public static void main(String[] args) {
        int first = Integer.MAX_VALUE;
        int second = 1;
        // Dự đoán output: cast trước phép cộng giúp tránh overflow int.
        System.out.println(first + second);
        System.out.println((long) first + second);
    }
}
