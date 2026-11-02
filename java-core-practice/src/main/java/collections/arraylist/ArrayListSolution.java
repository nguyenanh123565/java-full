package collections.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSolution {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("An", "Bình", "Chi"));
        names.add("Dũng");
        names.set(1, "Bảo");
        names.remove(0);
        System.out.println("Bài 1: " + names); // [Bảo, Chi, Dũng]

        List<Integer> byValue = new ArrayList<>(List.of(1, 2, 2, 3));
        byValue.remove(Integer.valueOf(2)); // Chọn overload nhận Object, xóa lần đầu khớp.
        List<Integer> byIndex = new ArrayList<>(List.of(1, 2, 2, 3));
        byIndex.remove(2); // Chọn overload nhận int, xóa phần tử ở index 2.
        System.out.println("Bài 2, theo giá trị: " + byValue);
        System.out.println("Bài 2, theo index: " + byIndex);
        // Hai kết quả tình cờ giống nhau vì vị trí 2 cũng chứa 2; thử [2, 7, 9] để phân biệt.

        List<String> original = new ArrayList<>(List.of("An"));
        List<String> alias = original;
        List<String> copy = new ArrayList<>(original);
        alias.add("Bình");
        copy.add("Chi");
        System.out.println("Bài 3, gốc: " + original);
        System.out.println("Bài 3, bản sao: " + copy);
        // Sao chép nông: list độc lập, nhưng reference tới các phần tử vẫn được chia sẻ.
    }
}
