package exception.throws_demo.exercises.starter;

import java.text.ParseException;

/** Khung tự làm; main để trống để không ảnh hưởng build. */
public class Starter {
    public static void main(String[] args) {
        // TODO: làm từng mã bài, thêm dữ liệu chuẩn/biên và check riêng.
        // TODO: ghi dự đoán trước khi chạy bài suy luận; không gọi ReferenceSolution.
    }

    public static int parseId(String text) throws ParseException { throw new UnsupportedOperationException("TODO TH-01"); }
    // TODO TH-02: viết outer/middle, vẽ đường lan truyền.
    // TODO TH-03: sửa service để bảo toàn hợp đồng.
    public static int[] parsePoint(String text) throws ParseException { throw new UnsupportedOperationException("TODO TH-04"); }
    public static int[][] readAll(String[] lines) throws ParseException { throw new UnsupportedOperationException("TODO TH-05"); }
}
