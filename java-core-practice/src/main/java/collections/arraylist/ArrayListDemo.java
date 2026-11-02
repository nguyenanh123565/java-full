package collections.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Đoán output và giải thích vì sao alias thấy phần tử mới.
        List<String> names = new ArrayList<>();
        names.add("An");
        List<String> alias = names; // Hai biến cùng giữ reference tới một list.
        List<String> copy = new ArrayList<>(names); // Sao chép list, không phải alias.
        alias.add("Bình");
        System.out.println(names);
        System.out.println(copy);
        // Với list chứa object mutable, bản sao này vẫn dùng chung các object phần tử.
    }
}
