package fundamental.variables;

public class VariableDemo {
    public static void main(String[] args) {
        // Đoán từng dòng trước khi chạy: phép chia phụ thuộc kiểu toán hạng.
        int total = 7;
        int people = 2;
        System.out.println(total / people);
        System.out.println((double) total / people);
        System.out.println((double) (total / people));

        int original = 10;
        int copy = original; // Giá trị primitive được sao chép.
        copy = 20;
        System.out.println(original + ", " + copy);

        byte small = 127;
        small++; // Phép tăng có thể tràn miền giá trị của byte.
        System.out.println(small);
    }
}
