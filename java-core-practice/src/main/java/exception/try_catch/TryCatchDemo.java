package exception.try_catch;

public class TryCatchDemo {
    public static void main(String[] args) {
        // Đoán output: dòng ngay sau parseInt có chạy khi parse thất bại không?
        try {
            int value = Integer.parseInt("abc");
            System.out.println(value);
        } catch (NumberFormatException e) {
            System.out.println("Không phải số nguyên");
        } finally {
            System.out.println("Kết thúc lần thử");
        }
        // finally thường chạy cả khi thành công lẫn thất bại; không bảo đảm nếu JVM bị dừng.
        // NumberFormatException là unchecked: compiler không bắt buộc catch hoặc khai báo throws.
    }
}
