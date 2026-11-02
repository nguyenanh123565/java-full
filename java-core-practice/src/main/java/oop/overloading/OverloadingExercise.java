package oop.overloading;

public class OverloadingExercise {
    public static void main(String[] args) {
        // Bài 1 - Dễ: TODO overload sum(int, int), sum(double, double),
        // sum(int, int, int); gọi cả ba và giải thích yếu tố tạo signature khác.
        // Vì sao chỉ đổi kiểu trả về không tạo được overload?

        // Bài 2 - Vừa: TODO overload describe(Object), describe(String).
        // Gọi với String text và Object object = text; dự đoán trước khi chạy.
        // Giải thích vì sao cùng object nhưng compiler chọn method khác nhau.

        // Bài 3 - Khó: TODO overload choose(String), choose(Integer).
        // Thử choose(null) để quan sát lỗi compiler, sau đó sửa bằng cast rõ kiểu.
        // Giải thích vì sao không có overload cụ thể nhất khi hai kiểu không liên hệ.
        // Giữ project biên dịch được: cuối cùng để lời gọi lỗi dưới dạng comment.
    }
}
