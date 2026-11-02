package oop.class_object;

public class ClassObjectDemo {
    static class Student {
        String name;
    }

    public static void main(String[] args) {
        // Đoán từng dòng output trước khi chạy; đếm số object Student.
        Student a = new Student();
        a.name = "An";
        Student b = a; // Sao chép giá trị reference, không sao chép object.
        Student c = new Student();
        c.name = "An";

        b.name = "Bình";
        System.out.println(a.name);
        System.out.println(c.name);
        System.out.println(a == b);
        System.out.println(a == c);
    }
}
