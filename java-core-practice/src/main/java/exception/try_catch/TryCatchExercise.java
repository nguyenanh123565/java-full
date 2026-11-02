package exception.try_catch;

public class TryCatchExercise {
    public static void main(String[] args) {
        // Bài 1 — Dễ: Viết parseOrDefault(text, fallback), bắt NumberFormatException,
        // trả fallback nếu text không biểu diễn int. Thử "12" và "abc" với fallback=0.
        // TODO: Giải thích vì sao đây là xử lý lỗi có chủ đích và exception là unchecked.
        // Bài 2 — Vừa: Parse hai chuỗi rồi chia số nguyên; thử ("6","2"), ("6","0"), ("six","2").
        // TODO: Bắt riêng NumberFormatException và ArithmeticException, thông báo rõ nguyên nhân.
        // TODO: finally in "Hoàn tất"; giải thích vì sao dòng sau điểm lỗi bị bỏ qua.
        // Bài 3 — Khó: Dùng BufferedReader + StringReader trong try-with-resources,
        // đọc từng dòng số và tính tổng. Thử "1\n2\n3" và "1\nx\n3".
        // TODO: Xử lý IOException và NumberFormatException ở nơi phù hợp; không nuốt lỗi.
        // TODO: Giải thích vì sao reader vẫn được close khi một dòng không phải số.
    }
}
