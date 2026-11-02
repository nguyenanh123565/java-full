package oop.interface_demo;

public class InterfaceExercise {
    public static void main(String[] args) {
        // Bài 1 - Dễ: TODO tạo interface Printer với print(String text).
        // ConsolePrinter implements Printer và in text; gọi qua biến Printer.
        // Giải thích vì sao method cài đặt phải public và không new Printer().

        // Bài 2 - Vừa: TODO tạo Notifier, EmailNotifier và SmsNotifier.
        // send(String) chỉ in console; sendWelcome(Notifier) không kiểm tra kiểu.
        // Giải thích vì sao thêm notifier mới không cần sửa sendWelcome.

        // Bài 3 - Khó: TODO tạo Drawable.draw(), Resizable.resize(double factor).
        // Rectangle implements cả hai, kích thước và factor phải hữu hạn, dương.
        // Gán cùng Rectangle cho Drawable và Resizable, resize rồi draw.
        // Giải thích vì sao hai reference khác kiểu vẫn quan sát cùng trạng thái.
    }
}
