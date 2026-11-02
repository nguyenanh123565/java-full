package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class LambdaSolution {
    public static void main(String[] args) {
        // Bài 1: khai báo hành vi rồi gọi qua functional interface.
        IntUnaryOperator triple = value -> value * 3;
        for (int value : new int[]{-2, 0, 4}) System.out.println(triple.applyAsInt(value));
        // Bài 2: vòng lặp duyệt; Predicate chỉ xét một giá trị.
        Predicate<Integer> adult = age -> age >= 18;
        List<Integer> adults = new ArrayList<>();
        for (int age : List.of(15, 18, 21)) if (adult.test(age)) adults.add(age);
        System.out.println(adults);
        // Bài 3: hai biến capture không bị gán lại.
        double discountRate = 0.10;
        double taxRate = 0.05;
        DoubleUnaryOperator discount = price -> price * (1 - discountRate);
        DoubleUnaryOperator tax = price -> price * (1 + taxRate);
        System.out.println(discount.andThen(tax).applyAsDouble(100));
        // double chỉ dùng minh họa; mini project tiền dùng số đồng nguyên.
    }
}
