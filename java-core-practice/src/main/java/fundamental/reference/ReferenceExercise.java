package fundamental.reference;

public class ReferenceExercise {
    public static void main(String[] args) {
        // TODO Bài 1 (dễ): Tự tạo lớp Box có int value và constructor.
        // a là new Box(10); b = a; sửa b.value thành 20.
        // In a.value và a == b (20, true). Vẽ mũi tên hai biến tới Box.
        // Giải thích vì sao chỉ có một object Box được tạo bởi đoạn này.

        // TODO Bài 2 (vừa): Tạo a và b bằng hai lần new Box(10).
        // In a == b, a.equals(b), a.value == b.value: false, false, true.
        // Chưa override equals. Giải thích danh tính object và giá trị field
        // khác nhau ở đâu; equals mặc định của Object kiểm tra gì?

        // TODO Bài 3 (khó): Caller có hai Box khác nhau: left=1, right=2.
        // Viết trySwap(Box left, Box right) chỉ đổi chỗ hai tham số.
        // Caller vẫn 1,2. Viết swapValues(...) đổi hai field value;
        // caller thành 2,1. Giải thích vì sao chỉ cách thứ hai thấy thay đổi.
        // Đầu vào đều khác null và là hai object khác nhau.
    }
}
