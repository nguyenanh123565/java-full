package fundamental.methods;

public class MethodExercise {
    public static void main(String[] args) {
        // TODO Bài 1 (dễ): Tự khai báo method max(int a, int b) trả về số lớn.
        // Thử (-3, -5) -> -3 và (4, 4) -> 4; không dùng Math.max.
        // Giải thích tham số, đối số và return có vai trò gì.

        // TODO Bài 2 (vừa): Viết increment(int value) dạng void.
        // Với biến ở caller bằng 5, gọi method và chứng minh caller vẫn là 5.
        // Viết incrementAndReturn(int value), gán kết quả về caller để thành 6.
        // Giải thích vì sao hai cách có hành vi khác nhau dù đều cộng 1.

        // TODO Bài 3 (khó): Caller có int[] data = {1, 2}.
        // Tự viết replaceArray(int[] values), gán tham số sang mảng {7, 8}.
        // Sau lời gọi, caller vẫn [1, 2]. Sau đó viết changeFirst(int[] values)
        // sửa phần tử đầu thành 99; caller thành [99, 2].
        // Vẽ hai biến tham chiếu; giải thích vì sao cả hai đều là pass-by-value.
    }
}
