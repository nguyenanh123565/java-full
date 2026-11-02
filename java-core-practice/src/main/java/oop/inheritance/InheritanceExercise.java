package oop.inheritance;

public class InheritanceExercise {
    public static void main(String[] args) {
        // Bài 1 - Dễ: TODO tạo Person(name), Teacher(name, subject) extends Person.
        // name là private; Teacher dùng getter để giới thiệu tên và môn học.
        // Giải thích vì sao Teacher không truy cập trực tiếp private name.

        // Bài 2 - Vừa: TODO tạo Employee(name) với calculateSalary() trả 0.
        // FullTimeEmployee có monthlySalary >= 0 và ghi đè calculateSalary().
        // Gọi qua biến Employee; giải thích quan hệ is-a và method được chọn.

        // Bài 3 - Khó: TODO tạo Base/Child, in dấu mốc trong hai constructor.
        // Child gọi super(...); gán Child cho Base và kiểm tra cùng reference.
        // Dự đoán thứ tự; giải thích vì sao không có hai object độc lập.
    }
}
