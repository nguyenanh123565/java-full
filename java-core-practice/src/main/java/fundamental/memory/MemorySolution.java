package fundamental.memory;

import java.util.Arrays;

public class MemorySolution {
    public static void main(String[] args) {
        System.out.println("Bài 1: các biến cục bộ thuộc các frame khác nhau");
        int x = 3;
        showIncremented(x); // Trong method: 4
        System.out.println("Caller: " + x); // Caller: 3

        System.out.println("Bài 2: khả năng truy cập và GC");
        int[] a = new int[]{1};
        int[] b = a;
        b = null;
        System.out.println(Arrays.toString(a)); // [1]
        System.out.println(b == null);          // true
        a = null;
        System.out.println(a == null);          // true
        // Một mảng được tạo bởi new int[] của bài 2; phép gán không tạo mảng.
        // Sau a=null và b=null, không còn đường tới mảng trong đoạn này.
        // Mảng có thể được GC thu hồi; không khẳng định đã thu hồi hoặc khi nào.

        System.out.println("Bài 3: object sống lâu hơn lời gọi tạo ra nó");
        int[] numbers = createNumbers();
        System.out.println(Arrays.toString(numbers)); // [7, 8, 9]
        int[] alias = numbers;
        numbers = null;
        System.out.println(Arrays.toString(alias));   // [7, 8, 9]
        // Frame createNumbers đã kết thúc nhưng alias còn dẫn tới mảng.
        // Scope/vòng đời biến cục bộ không phải vòng đời của object được trỏ tới.
    }

    private static void showIncremented(int x) {
        x++;
        System.out.println("Trong method: " + x);
    }

    private static int[] createNumbers() {
        int[] local = new int[]{7, 8, 9};
        return local; // Trả giá trị tham chiếu; không phải trả địa chỉ biến local.
    }
}
