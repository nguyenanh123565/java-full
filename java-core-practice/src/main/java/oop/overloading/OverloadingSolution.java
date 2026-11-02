package oop.overloading;

public class OverloadingSolution {
    static int sum(int a, int b) { return a + b; }
    static double sum(double a, double b) { return a + b; }
    static int sum(int a, int b, int c) { return a + b + c; }

    static String describe(Object value) { return "Object overload"; }
    static String describe(String value) { return "String overload"; }

    static String choose(String value) { return "String overload"; }
    static String choose(Integer value) { return "Integer overload"; }

    public static void main(String[] args) {
        System.out.println(sum(2, 3));
        System.out.println(sum(2.5, 3.5));
        System.out.println(sum(1, 2, 3));
        // Tên giống nhau, danh sách kiểu/số lượng tham số khác nhau.

        String text = "Java";
        Object object = text;
        System.out.println(describe(text));
        System.out.println(describe(object));
        // Kiểu đối số khi biên dịch là String và Object, dù identity giống nhau.

        // choose(null); // Không biên dịch: String và Integer không cụ thể hơn nhau.
        System.out.println(choose((String) null));
        System.out.println(choose((Integer) null));
        // Cast null chỉ cung cấp kiểu cho compiler, không tạo object mới.
        // Bài dùng số nhỏ; nếu tổng int vượt giới hạn thì có thể overflow.
    }
}
