package oop.constructor;

public class ConstructorExercise {
    public static void main(String[] args) {
        // Bài 1 - Dễ: TODO tạo Book có title; constructor không tham số
        // đặt title mặc định, constructor có tham số nhận title từ bên ngoài.
        // Giải thích vì sao constructor không khai báo kiểu trả về.

        // Bài 2 - Vừa: TODO tạo Product(name, price) với price >= 0.
        // Constructor Product(name) dùng this(...) để đặt price mặc định 0.
        // Từ chối giá âm; giải thích vì sao gom kiểm tra vào một constructor.

        // Bài 3 - Khó: TODO tạo Student(name, age) và Student(Student other).
        // Tạo bản sao, đổi age bản sao; dự đoán identity và dữ liệu của bản gốc.
        // Giải thích copy constructor khác gán reference; Java có tự tạo nó không?
    }
}
