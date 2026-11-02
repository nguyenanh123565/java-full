package equals_hashcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class EqualsHashCodeSolution {
    public static final class StudentKey {
        private final String id;
        public StudentKey(String id) { this.id = Objects.requireNonNull(id); }
        @Override public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof StudentKey)) return false;
            StudentKey key = (StudentKey) other;
            return id.equals(key.id);
        }
        @Override public int hashCode() { return id.hashCode(); }
    }

    public static void main(String[] args) {
        // Bài 1: class final tránh vấn đề đối xứng khi mở rộng equality bằng kế thừa.
        StudentKey first = new StudentKey("S01");
        StudentKey sameId = new StudentKey("S01");
        System.out.println(first == sameId);
        System.out.println(first.equals(sameId));
        // Bài 2: hash dẫn đến vùng tìm kiếm, equals xác nhận key bằng nhau.
        Set<StudentKey> students = new HashSet<>();
        students.add(first);
        students.add(sameId);
        students.add(new StudentKey("S02"));
        System.out.println(students.size());
        // Bài 3: key bằng nhau thay value; id bất biến giữ hash ổn định.
        Map<StudentKey, String> names = new HashMap<>();
        names.put(first, "An");
        names.put(sameId, "An cập nhật");
        System.out.println(names.size());
        System.out.println(names.get(new StudentKey("S01")));
    }
}
