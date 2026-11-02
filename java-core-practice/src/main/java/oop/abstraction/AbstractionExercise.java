package oop.abstraction;

public class AbstractionExercise {
    public static void main(String[] args) {
        // Bài 1 - Dễ: TODO tạo abstract Shape với abstract area().
        // Rectangle nhận width, height > 0; cài đặt area và thử dữ liệu sai.
        // Giải thích vì sao Shape không thể được new trực tiếp.

        // Bài 2 - Vừa: TODO thêm Circle(radius > 0) extends Shape.
        // Duyệt Shape[] gồm Rectangle, Circle để tính tổng diện tích.
        // Giải thích vì sao vòng lặp không cần biết công thức của từng hình.

        // Bài 3 - Khó: TODO tạo abstract Report có final printReport().
        // printReport in tiêu đề, gọi abstract body(), rồi in kết thúc.
        // Tạo StudentReport; giải thích vì sao quy trình chung không cần ghi đè.
    }
}
