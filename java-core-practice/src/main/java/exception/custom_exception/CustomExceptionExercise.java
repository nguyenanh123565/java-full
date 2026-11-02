package exception.custom_exception;

public class CustomExceptionExercise {
    public static void main(String[] args) {
        // Bài 1 — Dễ: Tạo checked InsufficientFundsException và hàm withdraw(balance, amount).
        // TODO: Không đủ tiền thì ném custom exception; đủ tiền thì trả số dư mới.
        // TODO: Thử (100,40)/(100,150); giải thích vì sao caller phải xử lý checked exception.
        // Bài 2 — Vừa: Tạo Account, số dư private, phương thức withdraw cập nhật số dư.
        // TODO: Constructor từ chối số dư âm; withdraw từ chối amount <= 0 bằng unchecked exception.
        // TODO: Thử amount=0/-10; giải thích vì sao không dùng cùng exception với thiếu tiền.
        // Bài 3 — Khó: Account(100), lần lượt rút 30, 100, 20; xử lý từng lần độc lập.
        // TODO: In số dư sau mỗi lần, giải thích vì sao lần thất bại không đổi trạng thái.
        // TODO: Bổ sung amountRequested và currentBalance vào custom exception để caller đọc.
        // TODO: Kiểm tra điều kiện trước khi cập nhật; giải thích vì sao thứ tự này quan trọng.
    }
}
