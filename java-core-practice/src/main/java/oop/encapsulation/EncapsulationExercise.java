package oop.encapsulation;

public class EncapsulationExercise {
    public static void main(String[] args) {
        // Bài 1 - Dễ: TODO tạo Student với private age, getter và setter.
        // Chỉ nhận age từ 0 đến 150, thử cập nhật hợp lệ và không hợp lệ.
        // Giải thích vì sao private + setter không kiểm tra chưa đủ bảo vệ dữ liệu.

        // Bài 2 - Vừa: TODO tạo Wallet private balance; deposit/withdraw số dương.
        // Không rút quá số dư; không có setBalance; dùng long cho tiền nguyên.
        // Kiểm tra dữ liệu sai không làm đổi số dư, giải thích vì sao.

        // Bài 3 - Khó: TODO tạo Scores giữ private int[] từ constructor.
        // Không để sửa mảng đầu vào hay mảng getter trả về ảnh hưởng dữ liệu nội bộ.
        // Giải thích vì sao chỉ dùng private với array vẫn có thể lộ trạng thái.
    }
}
