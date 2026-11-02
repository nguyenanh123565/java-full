package lambda;

import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class LambdaDemo {
    public static void main(String[] args) {
        int bonus = 2; // effectively final: không gán lại sau đây.
        IntUnaryOperator addBonus = value -> value + bonus;
        Predicate<Integer> even = value -> value % 2 == 0;
        // Dự đoán output: khai báo lambda chưa gọi phần thân lambda.
        System.out.println(addBonus.applyAsInt(3));
        System.out.println(even.test(5));
    }
}
