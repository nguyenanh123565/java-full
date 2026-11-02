package fundamental.memory;

import java.util.Arrays;

public class MemoryDemo {
    public static void main(String[] args) {
        // Đoán seed và nội dung alias sau khi makeValues kết thúc.
        int seed = 3;
        int[] values = makeValues(seed);
        int[] alias = values;
        values = null; // Chỉ bỏ một đường tham chiếu; alias vẫn dẫn tới mảng.
        System.out.println(seed);
        System.out.println(Arrays.toString(alias));

        alias = null;
        System.out.println(alias == null);
        // Không còn tham chiếu trong đoạn này tới mảng: có thể được GC thu hồi.
        // Không biết thời điểm GC, không thể chứng minh GC chỉ bằng phép gán null.
    }

    private static int[] makeValues(int seed) {
        seed++;
        return new int[]{seed};
        // Frame của method kết thúc khi return; mảng trả về vẫn dùng được.
    }
}
