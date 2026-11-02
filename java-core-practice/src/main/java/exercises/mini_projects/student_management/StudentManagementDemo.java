package exercises.mini_projects.student_management;

import java.util.HashMap;
import java.util.Map;

public class StudentManagementDemo {
    public static void main(String[] args) {
        // Demo nhỏ về reference trong collection, chưa triển khai nghiệp vụ.
        Map<String, String> original = new HashMap<>();
        Map<String, String> alias = original;
        Map<String, String> copy = new HashMap<>(original);
        alias.put("ID01", "Dữ liệu minh họa");
        // Dự đoán output và giải thích vì sao hai kích thước khác nhau.
        System.out.println(original.size());
        System.out.println(copy.size());
    }
}
