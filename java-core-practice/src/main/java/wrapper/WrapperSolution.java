package wrapper;

import java.util.ArrayList;
import java.util.List;

public class WrapperSolution {
    public static int valueOrZero(Integer value) {
        return value == null ? 0 : value.intValue();
    }

    public static void main(String[] args) {
        // Bài 1: catch trong vòng lặp để một input lỗi không chặn các input sau.
        for (String text : List.of("42", "abc", "-7")) {
            try { System.out.println(Integer.parseInt(text)); }
            catch (NumberFormatException e) { System.out.println("Không phải int: " + text); }
        }
        // Bài 2: chỉ unbox ở nhánh đã kiểm tra khác null.
        System.out.println(valueOrZero(null));
        System.out.println(valueOrZero(8));
        // Bài 3: kiểu đối số quyết định overload lúc biên dịch.
        List<Integer> byIndex = new ArrayList<>(List.of(1, 2, 1));
        List<Integer> byValue = new ArrayList<>(byIndex);
        byIndex.remove(1);
        byValue.remove(Integer.valueOf(1));
        int total = 0;
        for (int value : byValue) total += value;
        System.out.println(byIndex);
        System.out.println(byValue + ", tổng = " + total);
        System.out.println(Integer.valueOf(1000).equals(Integer.valueOf(1000)));
    }
}
