package exception.throws_demo;

public class ThrowsExercise {
    public static void main(String[] args) {
        // Bài 1 — Dễ: Viết parseCount(text) throws ParseException.
        // TODO: Chuyển NumberFormatException từ parseInt thành ParseException và giữ cause.
        // TODO: Thử "12"/"abc"; giải thích vì sao caller phải catch hoặc khai báo throws.
        // Bài 2 — Vừa: Viết requirePositive(int), ném IllegalArgumentException nếu <= 0.
        // TODO: Thử 2/0; giải thích vì sao compiler không bắt buộc khai báo throws ở đây.
        // Bài 3 — Khó: Viết parsePositiveCount gọi hai hàm trên; main thử "3"/"abc"/"-1".
        // TODO: Phân biệt lỗi định dạng và lỗi giá trị bằng catch phù hợp.
        // TODO: Vẽ đường exception truyền qua các hàm; vì sao throws không xử lý lỗi?
        // TODO: So sánh khai báo main throws với catch ở main về nơi xử lý lỗi.
    }
}
