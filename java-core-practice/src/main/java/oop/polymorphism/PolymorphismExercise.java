package oop.polymorphism;

public class PolymorphismExercise {
    public static void main(String[] args) {
        // Bài 1 - Dễ: TODO tạo Animal, Dog, Cat với speak() khác nhau.
        // Duyệt Animal[] và gọi speak(), dự đoán output trước khi chạy.
        // Giải thích vì sao cùng câu lệnh gọi method cho kết quả khác nhau.

        // Bài 2 - Vừa: TODO tạo abstract Payment với pay(long amount).
        // CashPayment/CardPayment chỉ mô phỏng bằng console, từ chối amount <= 0.
        // Viết checkout(Payment, long); giải thích vì sao caller không cần instanceof.

        // Bài 3 - Khó: TODO thêm fetch() riêng cho Dog.
        // Gán Dog/Cat vào Animal, dùng instanceof trước khi gọi fetch().
        // Thử ép Animal chứa Cat thành Dog trong try/catch; giải thích vì sao lỗi
        // xuất hiện lúc chạy và vì sao ép kiểu không biến Cat thành Dog.
    }
}
