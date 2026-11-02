package collections.priorityqueue;

public class PriorityQueueExercise {
    public static void main(String[] args) {
        // Bài 1 — Dễ: Thêm 5, 1, 3, 1 vào PriorityQueue; peek rồi poll đến rỗng.
        // TODO: Dự đoán output; vì sao phần tử trùng vẫn tồn tại?
        // Bài 2 — Vừa: Dùng Comparator để cùng dữ liệu trên lấy số lớn nhất trước.
        // TODO: Giải thích vì sao for-each/toString không thay thế poll khi cần thứ tự ưu tiên.
        // Bài 3 — Khó: Job có tên, priority, sequence bất biến.
        // TODO: Xử lý priority nhỏ trước, nếu bằng nhau sequence nhỏ trước.
        // TODO: Thêm A(priority=2, sequence=0), B(1,1), C(1,2); dự đoán thứ tự.
        // TODO: Giải thích vì sao cần tiêu chí phụ; tránh sửa priority khi job đang trong queue.
    }
}
