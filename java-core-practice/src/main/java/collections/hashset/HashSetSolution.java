package collections.hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HashSetSolution {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        System.out.println("Bài 1: " + names.add("An"));
        System.out.println("Bài 1: " + names.add("Bình"));
        System.out.println("Bài 1: " + names.add(new String("An")));
        System.out.println("Size: " + names.size());

        Set<Integer> unique = new HashSet<>(List.of(3, 1, 3, 2, 1));
        List<Integer> sorted = new ArrayList<>(unique);
        Collections.sort(sorted);
        System.out.println("Bài 2: " + sorted);

        Set<Student> students = new HashSet<>();
        students.add(new Student("S01"));
        students.add(new Student("S01"));
        students.add(new Student("S02"));
        System.out.println("Bài 3, size: " + students.size()); // 2
    }

    private static final class Student {
        private final String id; // Không đổi dữ liệu tham gia hashing khi ở trong set.

        private Student(String id) {
            this.id = Objects.requireNonNull(id);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof Student)) return false;
            Student student = (Student) other;
            return id.equals(student.id);
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }
}
