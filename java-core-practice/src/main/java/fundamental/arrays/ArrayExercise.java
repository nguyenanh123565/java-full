package fundamental.arrays;

public class ArrayExercise {
    public static void main(String[] args) {
        // TODO Bài 1 (dễ): Viết method tính tổng int[] bằng vòng lặp, trả long.
        // Thử {-2, 3, 5} -> 6 và mảng rỗng -> 0; đầu vào khác null.
        // Giải thích vì sao chỉ số cuối là length - 1, không phải length.

        // TODO Bài 2 (vừa): original = {1, 2, 3}; tạo alias bằng phép gán
        // và copy bằng Arrays.copyOf. Sửa alias[0] thành 99, in cả ba mảng.
        // Giải thích vì sao original đổi còn copy không đổi; so sánh ==.

        // TODO Bài 3 (khó): Tạo ma trận hai hàng từ cùng một int[] {1, 2}.
        // Sửa phần tử [0][0] thành 9, dự đoán cả hai hàng.
        // Tạo một ma trận khác mà mỗi hàng là một bản copy riêng của {1, 2},
        // sửa [0][0] thành 9. In bằng Arrays.deepToString và giải thích
        // vì sao hai ma trận khác nhau dù ban đầu in giống nhau.
    }
}
