package collections.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        // Đoán output; equals quyết định hai String này có cùng giá trị.
        System.out.println(names.add("An"));
        System.out.println(names.add(new String("An")));
        System.out.println(names.size());
        // Thứ tự duyệt HashSet không được bảo đảm; không đoán bằng thứ tự chèn.
    }
}
