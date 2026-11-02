package fundamental.strings;

public class StringExercise {
    public static void main(String[] args) {
        // TODO Bài 1 (dễ): Chuỗi gốc là "  java core  ".
        // Tạo chuỗi mới bỏ khoảng trắng ở hai đầu và viết hoa bằng Locale.ROOT.
        // In "JAVA CORE" và chứng minh chuỗi gốc vẫn giữ nguyên khoảng trắng.
        // Giải thích vì sao gọi trim()/toUpperCase() mà bỏ kết quả không đủ.

        // TODO Bài 2 (vừa): Tạo literal = "Java", alias = literal,
        // separate = new String("Java"). Đoán rồi in literal == alias,
        // literal == separate, literal.equals(separate): true, false, true.
        // Giải thích danh tính khác nội dung và vì sao không dùng == cho nội dung.
        // Không cố đếm toàn bộ object String trong heap/JVM.

        // TODO Bài 3 (khó): Caller có String text = "Java".
        // Viết method void gán tham số thành text + " Core": caller vẫn "Java".
        // Viết method trả String mới, rồi caller nhận kết quả: "Java Core".
        // Thử thêm method append trên StringBuilder: caller thấy "Java Core".
        // Giải thích sự khác nhau giữa đổi biến và sửa object mutable.
    }
}
