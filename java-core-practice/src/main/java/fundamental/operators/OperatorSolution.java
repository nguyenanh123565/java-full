package fundamental.operators;

public class OperatorSolution {
    public static void main(String[] args) {
        System.out.println("Bài 1: giá sau giảm");
        double price = 100.0;
        int discountPercent = 20;
        double result = price * (1 - discountPercent / 100.0);
        System.out.println(result); // 80.0

        System.out.println("Bài 2: kiểm tra chuỗi an toàn");
        for (String text : new String[]{null, "", "Java"}) {
            System.out.println(text != null && !text.isEmpty());
        }
        // Nếu dùng & thì cả hai vế được tính; gọi isEmpty() trên null gây lỗi.

        System.out.println("Bài 3: thứ tự đánh giá");
        int a = 5;
        int b = a++ + ++a;
        System.out.println("a=" + a + ", b=" + b); // a=7, b=12

        int explicitA = 5;
        int left = explicitA;
        explicitA = explicitA + 1;
        explicitA = explicitA + 1;
        int right = explicitA;
        int explicitB = left + right;
        System.out.println("a=" + explicitA + ", b=" + explicitB);
        // Java tính toán hạng trái trước toán hạng phải; left=5, right=7.
    }
}
