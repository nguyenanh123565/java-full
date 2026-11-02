package oop.overloading;

public class OverloadingDemo {
    static String describe(Object value) { return "Object overload"; }
    static String describe(String value) { return "String overload"; }

    public static void main(String[] args) {
        // Đoán output theo kiểu khai báo của đối số trước khi chạy.
        String text = "Java";
        Object object = text; // Cùng object, nhưng kiểu khai báo khác.
        System.out.println(describe(text));
        System.out.println(describe(object));
        System.out.println(describe(null));
        // Compiler chọn overload; null khớp cả hai, String cụ thể hơn Object.
    }
}
