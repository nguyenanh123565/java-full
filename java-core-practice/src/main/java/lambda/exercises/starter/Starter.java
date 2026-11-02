package lambda.exercises.starter;

import java.util.*;
import java.util.function.*;

/** Khung tự làm; main để trống để không ảnh hưởng build. */
public class Starter {
    public static void main(String[] args) {
        // TODO: làm từng mã bài, thêm dữ liệu chuẩn/biên và check riêng.
        // TODO: ghi dự đoán trước khi chạy bài suy luận; không gọi ReferenceSolution.
    }

    // TODO LAM-01: khai báo và gọi Function/Consumer/Supplier.
    // TODO LAM-02: tự ghi dự đoán thời điểm log thay đổi.
    // TODO LAM-03: sửa capture bằng snapshot đúng yêu cầu.
    // TODO LAM-04: tạo Predicate ghép, lọc bằng vòng lặp.
    public static <T,R> List<R> process(List<T> source, Predicate<T> accept, Function<T,R> transform, Consumer<R> onResult) { throw new UnsupportedOperationException("TODO LAM-05"); }
    public static String chooseName(String name, Supplier<String> fallback) { throw new UnsupportedOperationException("TODO LAM-05"); }
}
