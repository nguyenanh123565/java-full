package fundamental.operators;

public class OperatorDemo {
    public static void main(String[] args) {
        // Dự đoán output và giá trị cuối của x trước khi chạy.
        int x = 5;
        System.out.println(x++); // Dùng giá trị cũ, rồi tăng x.
        System.out.println(++x); // Tăng x, rồi dùng giá trị mới.
        System.out.println(2 + 3 * 4); // Nhân có độ ưu tiên cao hơn cộng.
        System.out.println((2 + 3) * 4);

        String text = null;
        // && chỉ tính vế phải nếu vế trái là true: không dereference null.
        System.out.println(text != null && text.length() > 0);
        System.out.println(10 % 3);
    }
}
