package oop.composition;

public class CompositionExercise {
    public static void main(String[] args) {
        // Bài 1 - Dễ: TODO Car tự tạo một Engine private final.
        // Car.drive() gọi Engine.start(); không extends Engine.
        // Đếm object, giải thích quan hệ has-a và vì sao final không làm Engine immutable.

        // Bài 2 - Vừa: TODO tạo interface MessageSender với send(String).
        // NotificationService nhận MessageSender qua constructor, từ chối null.
        // Đổi ConsoleSender thành LoudSender; giải thích vì sao service không cần sửa.

        // Bài 3 - Khó: TODO Student(name), Classroom có danh sách Student.
        // addStudent từ chối null; getter trả bản sao danh sách.
        // Thử clear danh sách nhận được, sau đó đổi name một Student trong đó.
        // Dự đoán hai tác động; giải thích sao chép collection có deep copy phần tử không.
    }
}
