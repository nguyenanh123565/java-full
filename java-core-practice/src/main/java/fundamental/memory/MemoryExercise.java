package fundamental.memory;

public class MemoryExercise {
    public static void main(String[] args) {
        // TODO Bài 1 (dễ): Caller có int x = 3; gọi method nhận int x,
        // tăng tham số và in bên trong (4), rồi in caller sau lời gọi (3).
        // Vẽ frame main và frame method đang chạy; giải thích hai biến x riêng.
        // Không suy luận địa chỉ hay số byte stack từ mô hình học tập này.

        // TODO Bài 2 (vừa): a = new int[]{1}; b = a; sau đó b = null.
        // In a, giải thích mảng còn được tham chiếu không. Tiếp tục a = null;
        // giải thích có còn đường tới mảng từ đoạn mã này không.
        // Bao nhiêu mảng được tạo bởi các biểu thức new int[] của đoạn này?
        // Vì sao gán null không đồng nghĩa GC chạy ngay? Không gọi System.gc().

        // TODO Bài 3 (khó): Viết createNumbers() tạo và trả int[]{7, 8, 9}.
        // Caller nhận mảng và in [7, 8, 9] sau khi method đã return.
        // Tạo alias rồi bỏ tham chiếu ban đầu; in alias vẫn [7, 8, 9].
        // Giải thích vì sao frame method kết thúc mà object vẫn sử dụng được.
        // Phân biệt vòng đời biến cục bộ, khả năng truy cập object và thời điểm GC.
    }
}
