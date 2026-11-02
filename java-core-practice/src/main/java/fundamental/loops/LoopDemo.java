package fundamental.loops;

public class LoopDemo {
    public static void main(String[] args) {
        // Đoán các số được in; chú ý điều kiện < thay vì <=.
        for (int i = 0; i < 3; i++) {
            System.out.println("for: " + i);
        }

        int count = 2;
        while (count > 0) {
            System.out.println("while: " + count);
            count--; // Tiến tới điều kiện dừng.
        }

        int value = 0;
        do {
            System.out.println("do-while: " + value);
        } while (value > 0); // Kiểm tra sau thân: thân chạy ít nhất một lần.

        for (int i = 1; i <= 5; i++) {
            if (i == 2) continue; // Bỏ phần còn lại của lượt hiện tại.
            if (i == 4) break;    // Dừng vòng lặp gần nhất.
            System.out.println("lọc: " + i);
        }
    }
}
